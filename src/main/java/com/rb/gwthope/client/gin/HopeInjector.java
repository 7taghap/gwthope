package com.rb.gwthope.client.gin;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.rb.gwthope.client.QuickStartGinApp;

import com.rb.gwthope.client.view.presenter.GreetingPresenter;
import com.rb.gwthope.client.view.presenter.MainPresenter;

@GinModules(HopeModule.class)
public interface HopeInjector extends Ginjector{

	QuickStartGinApp getQuickStartGinApp();
	MainPresenter getMainPresenter();
	GreetingPresenter getGreetingPresenter();
//	HandlerManager getEventBus();
}
