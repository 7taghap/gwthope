package com.rb.gwthope.client.event;

import com.google.gwt.event.shared.GwtEvent;
//import com.google.gwt.event.shared.GwtEvent.Type;

public class GreetingEvent extends GwtEvent<GreetingEventHandler>{

	
	public static Type<GreetingEventHandler> TYPE = new Type<GreetingEventHandler>();
	
	
	@Override
	protected void dispatch(GreetingEventHandler arg0) {
		arg0.onGetName(this);
		
	}

	@Override
	public Type<GreetingEventHandler> getAssociatedType() {
		return TYPE;
	}

}
