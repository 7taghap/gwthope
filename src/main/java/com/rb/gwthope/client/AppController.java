package com.rb.gwthope.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.rb.gwthope.client.event.GreetingEvent;
import com.rb.gwthope.client.event.GreetingEventHandler;
import com.rb.gwthope.client.view.presenter.SimpleGreetingPresenter;
import com.rb.gwthope.client.view.presenter.SimplePresenter;
import com.rb.gwthope.client.view.widget.GreetingView;
import com.rb.gwthope.shared.services.UserService;
import com.rb.gwthope.shared.services.UserServiceAsync;



public class AppController implements SimplePresenter, ValueChangeHandler<String>{
	private final HandlerManager eventBus;
	private HasWidgets container;
	
	
	public AppController(HandlerManager eventBus) {
		super();
		this.eventBus = eventBus;
		this.container = container;
		bind();
	}

	public void onValueChange(ValueChangeEvent<String> arg0) {
		 String token = arg0.getValue();
		    
		    if (token != null) {
		      SimplePresenter presenter = null;

		      if (token.equals("list")) {
		        presenter = new SimpleGreetingPresenter(eventBus, new GreetingView());
		      }
		      
		      if (presenter != null) {
		          presenter.go(container);
		      }
		    }
		
	}

	public void go(HasWidgets container) {
		 this.container = container;
		    
		    if ("".equals(History.getToken())) {
		      History.newItem("list");
		    }
		    else {
		      History.fireCurrentHistoryState();
		    }
		
	}
	
	public void bind() {
		 History.addValueChangeHandler(this);
		 
		 eventBus.addHandler(GreetingEvent.TYPE, new GreetingEventHandler() {
			
			public void onGetName(GreetingEvent event) {
				// TODO Auto-generated method stub
				getName();
			}
		});
	}
	
	private void getName() {
		UserServiceAsync userService = GWT.create(UserService.class);
		userService.findUser(1, new AsyncCallback<String>() {
        	public void onFailure(Throwable caught) {
              // Show the RPC error message to the user
             Window.alert(caught.getLocalizedMessage());
        	}
        	public void onSuccess(String user) {
             Window.alert(user);
        	}
		});
		Window.alert("get name");
	}

}
