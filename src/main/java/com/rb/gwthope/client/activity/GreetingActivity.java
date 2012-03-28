package com.rb.gwthope.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.rb.gwthope.client.event.GreetingEvent;


public class GreetingActivity extends AbstractActivity{
	
	private final EventBus eventBus;
	
	public GreetingDisplay display;
	public interface GreetingDisplay extends com.rb.gwthope.client.view.Display {
		HasClickHandlers getNameClickHandler();
//		Widget asWidget();
	}
	

	@Inject
	public GreetingActivity(EventBus eventBus) {
		super();
		this.eventBus = eventBus;
	}
	
	public void bind(){ 
	
		display.getNameClickHandler().addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent arg0) {
				// TODO Auto-generated method stub
				eventBus.fireEvent(new GreetingEvent());
			}
		});
	}




	public void start(AcceptsOneWidget container, EventBus arg1) {
		// TODO Auto-generated method stub
		bind();
		container.setWidget(display.asWidget());
	}

}
