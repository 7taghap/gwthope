package com.rb.gwthope.client.activity;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.rb.gwthope.client.place.ProductPlace;
import com.rb.gwthope.shared.dto.UnitConversion;
import com.rb.gwthope.shared.services.ProductServiceAsync;

public class ProductActivity extends AbstractActivity {

	public interface IProductViewDisplay {

		HasClickHandlers getSaveButton();

		HasClickHandlers getClearButton();

		void setDefaultUnit(List<String> defaultUnits);

		Widget asWidget();
	}

	private ProductPlace productPlace;
	private List<UnitConversion> unitConversions;
	private PlaceController placeController;
	private IProductViewDisplay display;
	private final EventBus eventBus;
	private ProductServiceAsync productRpc;

	@Inject
	public ProductActivity(PlaceController placeController,
			IProductViewDisplay display, EventBus eventBus,
			ProductServiceAsync rpc) {
		super();
		this.placeController = placeController;
		this.display = display;
		this.eventBus = eventBus;
		this.productRpc = rpc;
	}

	public void init(ProductPlace place) {
		this.productPlace = place;
	}

	@Override
	public void start(AcceptsOneWidget container, EventBus arg1) {
		// TODO Auto-generated method stub
		container.setWidget(this.display.asWidget());
		fetchDefaultUnits();
	}

	private void fetchDefaultUnits() {
		productRpc
				.getDefaultUnits(new AsyncCallback<ArrayList<UnitConversion>>() {

					@Override
					public void onFailure(Throwable arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(ArrayList<UnitConversion> result) {
						unitConversions = result;
						List<String> units = new ArrayList<String>();
						for(UnitConversion unit : unitConversions) {
							units.add(unit.getName());
						}
						display.setDefaultUnit(units);

					}
				});
	}

}
