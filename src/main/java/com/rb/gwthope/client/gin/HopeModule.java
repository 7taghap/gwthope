package com.rb.gwthope.client.gin;




import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.rb.gwthope.client.QuickStartGinApp;

import com.rb.gwthope.client.view.presenter.GreetingPresenter;
import com.rb.gwthope.client.view.presenter.MainPresenter;
import com.rb.gwthope.client.view.widget.GreetingWidget;
import com.rb.gwthope.client.view.widget.MainWidget;

public class HopeModule extends AbstractGinModule{

	@Override
	protected void configure() {
//		bind(CustomEventBus.class).to(DefaultEventBus.class).in(Singleton.class);
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
//		bind(HandlerManager.class).in(Singleton.class);
		bind(QuickStartGinApp.class).in(Singleton.class);
		
//		bind (GreetingPresenter.class).to(GreetingPresenterImpl.class);
//		bind(GreetingPresenter.Display.class).to(GreetingWidget.class);
		
//		bind(MainPresenter.class).to(MainPresenterImpl.class);
//		bind(MainPresenter.Display.class).to(MainWidget.class);
		
		
		
	}

}
