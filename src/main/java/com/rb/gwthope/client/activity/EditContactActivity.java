package com.rb.gwthope.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.rb.gwthope.client.place.ContactPlace;
import com.rb.gwthope.client.place.EditContactPlace;
import com.rb.gwthope.client.place.NewContactPlace;
import com.rb.gwthope.shared.dto.Contact;
import com.rb.gwthope.shared.services.ContactsServiceAsync;

public class EditContactActivity extends AbstractActivity {

	public interface IEditDisplay {
		HasClickHandlers getSaveButton();

		HasClickHandlers getCancelButton();

		HasValue<String> getFirstName();

		HasValue<String> getLastName();

		HasValue<String> getEmailAddress();

		Widget asWidget();
	}

	private Contact contact;
	private final ContactsServiceAsync rpcService;
	private final EventBus eventBus;
	private final IEditDisplay display;
	private final PlaceController placeController;
	
	private final Provider<ContactPlace> goToContactPlace;

	@Inject
	public EditContactActivity(EventBus eventBus, IEditDisplay display, 
							   PlaceController placeController, 
							   ContactsServiceAsync rpcService,
							   Provider<ContactPlace> goToContactPlace) {
		
		this.rpcService = rpcService;
		this.eventBus = eventBus;
		this.display = display;
		this.placeController = placeController;
		
		this.goToContactPlace = goToContactPlace;
		
		bind();
	}
	
	public void init(EditContactPlace place) {
		
		String id = place.getPlaceName();
		
		GWT.log("init(EditContactPlace called: " + id);
		
		rpcService.getContact(id, new AsyncCallback<Contact>() {
			public void onSuccess(Contact result) {
				contact = result;
				EditContactActivity.this.display.getFirstName().setValue(
						contact.getFirstName());
				EditContactActivity.this.display.getLastName().setValue(
						contact.getLastName());
				EditContactActivity.this.display.getEmailAddress().setValue(
						contact.getEmailAddress());
			}

			public void onFailure(Throwable caught) {
				Window.alert("Error retrieving contact");
			}
		});
	}
	
	public void init(NewContactPlace place) {
		
		this.contact = new Contact();
	}

	public void bind() {
		this.display.getSaveButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				doSave();
			}
		});

		this.display.getCancelButton().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				EditContactActivity.this.placeController.goTo(goToContactPlace.get());
			}
		});
	}

	public void start(AcceptsOneWidget container, EventBus eventBus) {
		container.setWidget(display.asWidget());
	}

	private void doSave() {
		contact.setFirstName(display.getFirstName().getValue());
		contact.setLastName(display.getLastName().getValue());
		contact.setEmailAddress(display.getEmailAddress().getValue());

		rpcService.updateContact(contact, new AsyncCallback<Contact>() {
			public void onSuccess(Contact result) {
				EditContactActivity.this.placeController.goTo(goToContactPlace.get());
			}

			public void onFailure(Throwable caught) {
				Window.alert("Error updating contact");
			}
		});
	}

}
