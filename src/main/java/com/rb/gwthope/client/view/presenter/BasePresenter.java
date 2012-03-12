package com.rb.gwthope.client.view.presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.rb.gwthope.client.view.Display;


/**
 * 
 * @author caburnar
 *
 * @param <D>
 */
public abstract class BasePresenter <D extends Display> implements Presenter<D>{

	protected final EventBus eventBus;
	protected final D display;
	protected final List<HandlerRegistration> handlerRegistrations;
	
//	public BasePresenter(CustomEventBus eventBus, D display,
//			ArrayList<HandlerRegistration> handlerRegistrations) {
//		
//		this.eventBus = eventBus;
//		this.display = display;
//		this.handlerRegistrations = handlerRegistrations;
//	}
	
	public BasePresenter(EventBus eventBus, D display) {
		
		this.eventBus = eventBus;
		this.display = display;
		this.handlerRegistrations = new ArrayList<HandlerRegistration>();
	}
	
	public void bind() {
		
	}
	
	public void unbind() {
		for (HandlerRegistration reg : handlerRegistrations) {
			reg.removeHandler();
		}
		handlerRegistrations.clear();
	}
	
	public D getDisplay() {
		return this.display;
	}
	
	protected void registerHandler(HandlerRegistration handlerRegistration) {
		handlerRegistrations.add(handlerRegistration);
	}
	
}
