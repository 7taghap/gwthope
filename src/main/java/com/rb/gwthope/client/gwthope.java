package com.rb.gwthope.client;

import com.rb.gwthope.client.event.GreetingEvent;
import com.rb.gwthope.client.event.GreetingEventHandler;
import com.rb.gwthope.client.gin.ContactsGinjector;
import com.rb.gwthope.client.gin.HopeInjector;
import com.rb.gwthope.client.place.ContactPlace;
import com.rb.gwthope.client.view.SideMenuView;
import com.rb.gwthope.client.view.presenter.AppPlaceFactory;
import com.rb.gwthope.client.view.presenter.AppPlaceHistoryMapper;
import com.rb.gwthope.client.view.widget.SimpleWidgetPanel;

import com.rb.gwthope.shared.FieldVerifier;
import com.rb.gwthope.shared.dto.User;
import com.rb.gwthope.shared.services.GreetingService;
import com.rb.gwthope.shared.services.GreetingServiceAsync;
import com.rb.gwthope.shared.services.UserService;
import com.rb.gwthope.shared.services.UserServiceAsync;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class gwthope implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
  
  /**
   * Creeate a remote service proxy for User
   * 
   */
  private final UserServiceAsync userService = GWT.create(UserService.class);

  private final Messages messages = GWT.create(Messages.class);

  /**
   * This is the entry point method.
   */
//	private SimpleWidgetPanel appWidget = new SimpleWidgetPanel();
	private SimplePanel appWidget = new SimplePanel();
	
	private com.rb.gwthope.client.gin.ContactsGinjector injector = GWT.create(ContactsGinjector.class);
  public void onModuleLoad() {
	  ContactClientFactory();
  }
  private void ContactClientFactory() {
		EventBus eventBus = injector.getEventBus();
		PlaceController placeController = injector.getPlaceController();

		ActivityMapper activityMapper = injector.getActivityMapper();
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(appWidget);

		AppPlaceFactory factory = injector.getAppPlaceFactory();
		ContactPlace defaultPlace = factory.getContactPlace();
//		MenuPlace menuPlace = factory.getMenuPlace();
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		historyMapper.setFactory(factory);
		
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);
		System.out.println(factory.getContactPlace().getPlaceName());
		RootPanel.get("sidebar").add(new SideMenuView());
		RootPanel.get("content").add(appWidget);
//		RootLayoutPanel.get().add(appWidget);
		historyHandler.handleCurrentHistory();
		logEvent(eventBus);
  }
  
  
  
  private void logEvent(EventBus eventBus) {
//	  Window.alert(eventBus.getHandlerCount(GreetingEvent.TYPE)+"");
//	  eventBus.
	  eventBus.addHandler(GreetingEvent.TYPE,new GreetingEventHandler() {
		
		public void onGetName(GreetingEvent event) {
			Window.alert(event.toDebugString());
			GWT.log(event.toDebugString(), null);
			
		}
	});
  }

 
  
  
}
