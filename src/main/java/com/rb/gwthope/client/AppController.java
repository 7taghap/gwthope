package com.rb.gwthope.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Inject;
import com.rb.gwthope.client.activity.MainActivity.IMainActivityView;
import com.rb.gwthope.client.gin.ContactsGinjector;
import com.rb.gwthope.client.place.ContactPlace;
import com.rb.gwthope.client.place.MainPlace;
import com.rb.gwthope.client.view.SideMenuView;
import com.rb.gwthope.client.view.presenter.AppPlaceFactory;
import com.rb.gwthope.client.view.presenter.AppPlaceHistoryMapper;


public class AppController {

	
	
	private ContactsGinjector injector;
//	private final IMainActivityView mainDisplay;
	
	@Inject
	public AppController(ContactsGinjector injector) {
		this.injector = injector;
//		this.mainDisplay = new MainWidget();
		
	}
	
	public void run(HasWidgets root) {
		EventBus eventBus = injector.getEventBus();
		PlaceController placeController = injector.getPlaceController();

		ActivityMapper activityMapper = injector.getActivityMapper();
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
//		activityManager.setDisplay(mainDisplay.);

		AppPlaceFactory factory = injector.getAppPlaceFactory();
//		MainPlace defaultPlace = factory.getMainProvider();
//		MenuPlace menuPlace = factory.getMenuPlace();
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		historyMapper.setFactory(factory);
		
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
//		historyHandler.register(placeController, eventBus, defaultPlace);
//		root.add(mainDisplay.asWidget());
		historyHandler.handleCurrentHistory();
	}
	
}

/*
 * sample code from mvp sample
 */

/*
 * public class AppController implements SimplePresenter,
 * ValueChangeHandler<String>{ private final HandlerManager eventBus; private
 * HasWidgets container;
 * 
 * 
 * public AppController(HandlerManager eventBus) { super(); this.eventBus =
 * eventBus; this.container = container; bind(); }
 * 
 * public void onValueChange(ValueChangeEvent<String> arg0) { String token =
 * arg0.getValue();
 * 
 * if (token != null) { SimplePresenter presenter = null;
 * 
 * if (token.equals("list")) { presenter = new SimpleGreetingPresenter(eventBus,
 * new GreetingView()); }
 * 
 * if (presenter != null) { presenter.go(container); } }
 * 
 * }
 * 
 * public void go(HasWidgets container) { this.container = container;
 * 
 * if ("".equals(History.getToken())) { History.newItem("list"); } else {
 * History.fireCurrentHistoryState(); }
 * 
 * }
 * 
 * public void bind() { History.addValueChangeHandler(this);
 * 
 * eventBus.addHandler(GreetingEvent.TYPE, new GreetingEventHandler() {
 * 
 * public void onGetName(GreetingEvent event) { // TODO Auto-generated method
 * stub getName(); } }); }
 * 
 * private void getName() { UserServiceAsync userService =
 * GWT.create(UserService.class); userService.findUser(1, new
 * AsyncCallback<String>() { public void onFailure(Throwable caught) { // Show
 * the RPC error message to the user Window.alert(caught.getLocalizedMessage());
 * } public void onSuccess(String user) { Window.alert(user); } });
 * Window.alert("get name"); }
 * 
 * }
 */
