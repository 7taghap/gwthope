package com.rb.gwthope.client.gin;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.rb.gwthope.client.AppController;
import com.rb.gwthope.client.view.presenter.AppPlaceFactory;


@GinModules(ContactsGinModule.class)
public interface ContactsGinjector extends Ginjector {

	ActivityMapper getActivityMapper();
	
	PlaceController getPlaceController();
	
	EventBus getEventBus();
	
	AppPlaceFactory getAppPlaceFactory();
	AppController getAppController();
	
}
