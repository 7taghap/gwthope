package com.rb.gwthope.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface GreetingEventHandler extends EventHandler{
	
	void onGetName(GreetingEvent event);

}
