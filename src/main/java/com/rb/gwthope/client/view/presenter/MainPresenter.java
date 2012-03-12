package com.rb.gwthope.client.view.presenter;


public interface MainPresenter extends Presenter<MainPresenter.Display> {

	interface Display extends com.rb.gwthope.client.view.Display{
		
		void addMenu(com.rb.gwthope.client.view.Display display);
		void addContent(com.rb.gwthope.client.view.Display display);
		void removeContent();
	}
}
