package com.rb.gwthope.client.presenter.impl;





import com.google.gwt.core.client.GWT;
import com.google.inject.Inject;
import com.rb.gwthope.client.event.EventBus;
import com.rb.gwthope.client.event.GetNameEvent;
import com.rb.gwthope.client.event.GetNameHandler;
import com.rb.gwthope.client.presenter.BasePresenter;
import com.rb.gwthope.client.presenter.GreetingPresenter;
import com.rb.gwthope.client.presenter.MainPresenter;
import com.rb.gwthope.client.presenter.MainPresenter.Display;
import com.rb.gwthope.client.presenter.Presenter;
import com.rb.gwthope.shared.services.UserService;
import com.rb.gwthope.shared.services.UserServiceAsync;



public class MainPresenterImpl extends BasePresenter<MainPresenter.Display> implements MainPresenter{

	
	private Presenter<? extends com.rb.gwthope.client.view.Display> presenter;
	
	@Inject
	public MainPresenterImpl(EventBus eventBus, Display display,GreetingPresenter greeting) {
		super(eventBus, display);
		// TODO Auto-generated constructor stub
		greeting.bind();
		display.addContent(greeting.getDisplay());
//		menuPresenter.bind();
//		display.addMenu(menuPresenter.getDisplay());
	}

	
	@Override
	public void bind() {

		super.bind();
		
		registerHandler(eventBus.addHandler(GetNameEvent.getType(),
				new GetNameHandler() {
					
					public void onGetName(GetNameEvent event) {
						 getUserName() ;
						
					}
				}));

	}

	@Override
	public void unbind() {
		super.unbind();
		if (presenter != null) {
			presenter.unbind();
		}
	}
//	 private final UserServiceAsync userService = GWT.create(UserService.class);
	private void getUserName() {
		
	}


}
