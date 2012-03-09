package com.rb.gwthope.client.gin;



import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.rb.gwthope.client.QuickStartGinApp;
import com.rb.gwthope.client.presenter.GreetingPresenter;
import com.rb.gwthope.client.presenter.MainPresenter;
import com.rb.gwthope.client.presenter.impl.GreetingPresenterImpl;
import com.rb.gwthope.client.presenter.impl.MainPresenterImpl;
import com.rb.gwthope.client.view.widget.GreetingWidget;
import com.rb.gwthope.client.view.widget.MainWidget;



public class MyModule extends AbstractGinModule {
	

		@Override
		protected void configure() {
			bind(QuickStartGinApp.class).in(Singleton.class);
//			install(new Module());

		//	bind(GreetingPresenter.class).to(GreetingPresenterImpl.class);
		//	bind(GreetingPresenter.Display.class).to(GreetingWidget.class);
//			bind(IssueDisplayPresenter.Display.class).to(IssueDisplayWidget.class);
//
//			bind(IssueEditPresenter.class).to(IssueEditPresenterImpl.class);
//			bind(IssueEditPresenter.Display.class).to(IssueEditWidget.class);
//
//			bind(MenuPresenter.class).to(MenuPresenterImpl.class);
//			bind(MenuPresenter.Display.class).to(MenuWidget.class);
//
			//bind(MainPresenter.class).to(MainPresenterImpl.class);
			//bind(MainPresenter.Display.class).to(MainWidget.class);

		}

	
}
