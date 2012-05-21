package com.rb.gwthope.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.rb.gwthope.client.gin.ContactsGinjector;
import com.rb.gwthope.client.place.ContactPlace;
import com.rb.gwthope.client.view.SideMenuView;
import com.rb.gwthope.client.view.SlidingPanel;
import com.rb.gwthope.client.view.presenter.AppPlaceFactory;
import com.rb.gwthope.client.view.presenter.AppPlaceHistoryMapper;




/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class gwthope implements EntryPoint {


  private final Messages messages = GWT.create(Messages.class);

  /**
   * This is the entry point method.
   */
//	private SimpleWidgetPanel appWidget = new SimpleWidgetPanel();

	
	private ContactsGinjector injector = GWT.create(ContactsGinjector.class);
  public void onModuleLoad() {

	  ContactClientFactory();
  }
  
  
  private SimplePanel appWidget = new SimplePanel();
//  private SlidingPanel appWidget = new SlidingPanel();
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
		RootPanel.get("sidebar").add(new SideMenuView());
		RootPanel.get("content").add(appWidget);
//		RootLayoutPanel.get().add(appWidget);
		historyHandler.handleCurrentHistory();
		logEvent(eventBus);
  }
  
  
  
  private void logEvent(EventBus eventBus) {
//	  Window.alert(eventBus.getHandlerCount(GreetingEvent.TYPE)+"");
//	  eventBus.
//	  eventBus.addHandler(GreetingEvent.TYPE,new GreetingEventHandler() {
//		
//		public void onGetName(GreetingEvent event) {
//			Window.alert(event.toDebugString());
//			GWT.log(event.toDebugString(), null);
//			
//		}
//	});
  }

 
  
  
}
