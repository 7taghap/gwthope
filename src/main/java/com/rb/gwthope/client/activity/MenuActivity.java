package com.rb.gwthope.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.rb.gwthope.client.place.NewContactPlace;

public class MenuActivity extends AbstractActivity{

	public interface IMenuViewDisplay {
		HasClickHandlers getHompageButton();
		HasClickHandlers getProductButton();
		Widget asWidget();
	}
	private PlaceController placeController;
	private final EventBus eventBus;
	private final IMenuViewDisplay display;
	private Provider<NewContactPlace> newGoToPlaceProvider;
	
	@Inject
	public MenuActivity (EventBus eventBus,PlaceController placeController,
			Provider<NewContactPlace> newGoToPlaceProvider,
			IMenuViewDisplay display) {
		this.eventBus =eventBus;
		this.placeController = placeController;
		this.display = display;
		this.newGoToPlaceProvider = newGoToPlaceProvider;
	}
	
	public void bind() {
		display.getHompageButton().addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent arg0) {
				// TODO Auto-generated method stub
				MenuActivity.this.placeController.goTo(newGoToPlaceProvider.get());
//				arg0.
			}
		});
		
//		display.getProductButton().addClickHandler(new ClickHandler() {
//			
//			public void onClick(ClickEvent arg0) {
//				// TODO Auto-generated method stub
//				Window.alert("Product page");
//			}
//		});
	}
	
	public void start(AcceptsOneWidget container, EventBus event) {
		
		bind();
		container.setWidget(display.asWidget());
	}

}
