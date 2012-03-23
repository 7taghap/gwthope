package com.rb.gwthope.client.activity;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.rb.gwthope.client.place.ContactPlace;
import com.rb.gwthope.client.place.EditContactPlace;
import com.rb.gwthope.client.place.NewContactPlace;
import com.rb.gwthope.shared.dto.ContactDetails;
import com.rb.gwthope.shared.services.ContactsServiceAsync;

public class ContactActivity extends AbstractActivity {

	private List<com.rb.gwthope.shared.dto.ContactDetails> contactDetails;

	// injected through the init method
	private ContactPlace place;
	
	private final ContactsServiceAsync rpcService;
	private final EventBus eventBus;
	private final IContactsViewDisplay display;

	private PlaceController placeController;

	public interface IContactsViewDisplay {
		HasClickHandlers getAddButton();

		HasClickHandlers getDeleteButton();

		HasClickHandlers getList();

		void setData(List<String> data);

		int getClickedRow(ClickEvent event);

		List<Integer> getSelectedRows();

		
		Widget asWidget();
	}

	private Provider<EditContactPlace> editGoToPlaceProvider;
	private Provider<NewContactPlace> newGoToPlaceProvider;
	
	@Inject
	public ContactActivity(EventBus eventBus, IContactsViewDisplay display,
							PlaceController placeController,
							ContactsServiceAsync rpcService,
							Provider<NewContactPlace> newGoToPlaceProvider,
							Provider<EditContactPlace> editGoToPlaceProvider) {
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.placeController = placeController;
		
		this.newGoToPlaceProvider = newGoToPlaceProvider;
		this.editGoToPlaceProvider = editGoToPlaceProvider;
		
	}
	
	public void init(ContactPlace place) {
		this.place = place;
	}
	
	public void start(AcceptsOneWidget container, EventBus eventBus) {

		bind();
		container.setWidget(display.asWidget());
		fetchContactDetails();

	}

	public void bind() {
		display.getAddButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ContactActivity.this.placeController.goTo(newGoToPlaceProvider.get());
				
			}
		});

		display.getDeleteButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				deleteSelectedContacts();
			}
		});

		display.getList().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				int selectedRow = display.getClickedRow(event);

				if (selectedRow >= 0) {
					String id = contactDetails.get(selectedRow).getId();
					// need to set the id of the contact in the place
					EditContactPlace editGoToPlace = editGoToPlaceProvider.get();
					editGoToPlace.setPlaceName(id);
					ContactActivity.this.placeController.goTo(editGoToPlace);
				}
			}
		});
	}

	public void sortContactDetails() {

		// Yes, we could use a more optimized method of sorting, but the
		// point is to create a test case that helps illustrate the higher
		// level concepts used when creating MVP-based applications.
		//
		for (int i = 0; i < contactDetails.size(); ++i) {
			for (int j = 0; j < contactDetails.size() - 1; ++j) {
				if (contactDetails.get(j).getDisplayName().compareToIgnoreCase(
						contactDetails.get(j + 1).getDisplayName()) >= 0) {
					ContactDetails tmp = contactDetails.get(j);
					contactDetails.set(j, contactDetails.get(j + 1));
					contactDetails.set(j + 1, tmp);
				}
			}
		}
	}

	public void setContactDetails(List<ContactDetails> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public ContactDetails getContactDetail(int index) {
		return contactDetails.get(index);
	}

	private void fetchContactDetails() {
		rpcService
				.getContactDetails(new AsyncCallback<ArrayList<ContactDetails>>() {
					public void onSuccess(ArrayList<ContactDetails> result) {
						contactDetails = result;
						sortContactDetails();
						List<String> data = new ArrayList<String>();

						for (int i = 0; i < result.size(); ++i) {
							data.add(contactDetails.get(i).getDisplayName());
						}

						display.setData(data);
					}

					public void onFailure(Throwable caught) {
						Window.alert("Error fetching contact details");
					}
				});
	}

	private void deleteSelectedContacts() {
		List<Integer> selectedRows = display.getSelectedRows();
		ArrayList<String> ids = new ArrayList<String>();

		for (int i = 0; i < selectedRows.size(); ++i) {
			ids.add(contactDetails.get(selectedRows.get(i)).getId());
		}

		rpcService.deleteContacts(ids,
				new AsyncCallback<ArrayList<ContactDetails>>() {
					public void onSuccess(ArrayList<ContactDetails> result) {
						contactDetails = result;
						sortContactDetails();
						List<String> data = new ArrayList<String>();

						for (int i = 0; i < result.size(); ++i) {
							data.add(contactDetails.get(i).getDisplayName());
						}

						display.setData(data);

					}

					public void onFailure(Throwable caught) {
						Window.alert("Error deleting selected contacts");
					}
				});
	}

}
