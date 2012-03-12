package com.rb.gwthope.client.view.presenter.impl;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.rb.gwthope.client.event.GreetingEvent;
import com.rb.gwthope.client.event.GreetingEventHandler;
import com.rb.gwthope.client.view.presenter.BasePresenter;
import com.rb.gwthope.client.view.presenter.GreetingPresenter;
import com.rb.gwthope.client.view.presenter.GreetingPresenter.Display;

public class GreetingPresenterImpl extends BasePresenter<Display> 
implements GreetingPresenter {

	@Inject
	public GreetingPresenterImpl(EventBus eventBus, Display display) {
		super(eventBus, display);
		// TODO Auto-generated constructor stub
		
		
	}
	
	@Override
	public void bind() {
		
		super.bind();
//		HandlerManager gwtEventBus = new HandlerManager(null);
		
//		if (display.getNameClickHandler().)
		display.getNameClickHandler().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent arg0) {
				// TODO Auto-generated method stub
				Window.alert("fire event");
				eventBus.fireEvent(new GreetingEvent());
			
			}
		});
//		MyHandler handler = new MyHandler();
		
//		registerHandler(display.getTextFocusHandler().addFocusHandler(new FocusHandler() {
//			
//			public void onFocus(FocusEvent arg0) {
//				// TODO Auto-generated method stub
////				eventBus.fireEvent(new GreetingEvent());
//				Window.alert("on focus");
//			}
//		}));
	}
	

}
