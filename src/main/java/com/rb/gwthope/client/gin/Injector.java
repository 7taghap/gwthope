package com.rb.gwthope.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.rb.gwthope.client.QuickStartGinApp;
import com.rb.gwthope.client.event.EventBus;
import com.rb.gwthope.client.presenter.MainPresenter;


@GinModules(com.rb.gwthope.client.gin.MyModule.class)
public interface Injector extends Ginjector{
	MainPresenter getMainPresenter();
	QuickStartGinApp getQuickStartGinApp();
	EventBus getEventBus();
}
