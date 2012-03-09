package com.rb.gwthope.client.presenter;

import com.google.gwt.event.dom.client.HasClickHandlers;

public interface GreetingPresenter extends Presenter<GreetingPresenter.Display> {

	interface Display extends com.rb.gwthope.client.view.Display {
		HasClickHandlers getGetNameClickHandlers();
	}
}
