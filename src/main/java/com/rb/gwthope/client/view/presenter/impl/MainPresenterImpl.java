package com.rb.gwthope.client.view.presenter.impl;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.rb.gwthope.client.event.GreetingEvent;
import com.rb.gwthope.client.event.GreetingEventHandler;
import com.rb.gwthope.client.view.presenter.BasePresenter;
import com.rb.gwthope.client.view.presenter.GreetingPresenter;
import com.rb.gwthope.client.view.presenter.MainPresenter;
import com.rb.gwthope.client.view.presenter.Presenter;
import com.rb.gwthope.shared.services.UserService;
import com.rb.gwthope.shared.services.UserServiceAsync;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * mao ni ang main presenter na mo handler sa tanan presenter,
 * murag ni ug main controller
 * @author caburnar
 *
 */
public class MainPresenterImpl extends BasePresenter<MainPresenter.Display> implements MainPresenter {

	private final Provider<GreetingPresenter> displayGreeting;
	private Presenter<? extends com.rb.gwthope.client.view.Display> presenter;


	@Inject
	public MainPresenterImpl(EventBus eventBus, Display display,
			Provider<GreetingPresenter> displayGreeting,
			ArrayList<HandlerRegistration> handlerRegistrations) {
		super(eventBus, display);
	
		this.displayGreeting = displayGreeting;
//		displayGreeting.
//		display = this.displayGreeting.get().getDisplay();
//		display.addContent(this.displayGreeting.get().getDisplay());
//		this.displayGreeting.get().bind();
		this.displayGreeting.get().bind();
//		display.addMenu(displayGreeting.getDisplay());
		
		// TODO Auto-generated constructor stub
	}
//final HandlerManager gwtEventBus = new HandlerManager(null);
	@Override
	public void bind() {
		// TODO Auto-generated method stub
		super.bind();
		Window.alert("bind main");

		eventBus.addHandler(GreetingEvent.TYPE, new GreetingEventHandler() {
			
			public void onGetName(GreetingEvent event) {
				// TODO Auto-generated method stub
				
				Window.alert("test");
			}
		});
//		EventBus eventBus = new Eve
//		registerHandler(eventBus.addHandler(GreetingEvent.TYPE, new GreetingEventHandler() {
//			
//			public void onGetName(GreetingEvent event) {
//				Window.alert("call user service" + event);
//				getName();
//				
//			}
//		}));
		
	}

	private void getName() {
		Window.alert("call user service");
		UserServiceAsync userService = GWT.create(UserService.class);
		 userService.findUser(1, new AsyncCallback<String>() {
	        	public void onFailure(Throwable caught) {
	             Window.alert(caught.getLocalizedMessage());
	        	}
	        	public void onSuccess(String user) {
	   	              Window.alert(user);
	        	}
			});
		
	}

}
