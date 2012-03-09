package com.rb.gwthope.client.event;

import com.google.gwt.event.shared.HandlerManager;
import com.google.inject.Inject;

public class DefaultEventBus extends HandlerManager implements EventBus {

	@Inject
	public DefaultEventBus() {
		super(null);
	}

}
