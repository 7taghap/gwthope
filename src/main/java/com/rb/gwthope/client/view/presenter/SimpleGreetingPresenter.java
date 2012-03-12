package com.rb.gwthope.client.view.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasFocusHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.rb.gwthope.client.event.GreetingEvent;

public class SimpleGreetingPresenter implements SimplePresenter{

	
	public interface Display {
		HasClickHandlers getNameClickHandler();
		HasFocusHandlers getTextFocusHandler();
		Widget asWidget();
	}
	
	 private final HandlerManager eventBus;
	 private final Display display;
	 
	 public SimpleGreetingPresenter(HandlerManager eventBus,Display view) {
		 this.eventBus =eventBus;
		 this.display = view;
	 }

	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
		
	}
	
	public void bind() {
		
		 display.getNameClickHandler().addClickHandler(new ClickHandler() {   
		      public void onClick(ClickEvent event) {
		        eventBus.fireEvent(new GreetingEvent());
		      }
		    });
		
	}
}
