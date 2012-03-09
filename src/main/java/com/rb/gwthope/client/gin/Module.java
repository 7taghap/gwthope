package com.rb.gwthope.client.gin;

import com.google.gwt.inject.client.AbstractGinModule;
import com.rb.gwthope.client.event.DefaultEventBus;
import com.rb.gwthope.client.event.EventBus;

public class Module extends AbstractGinModule {

	@Override
	protected void configure() {

		bind(EventBus.class).to(DefaultEventBus.class);

	}

}
