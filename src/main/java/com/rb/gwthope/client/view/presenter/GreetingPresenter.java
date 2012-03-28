package com.rb.gwthope.client.view.presenter;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasFocusHandlers;

public interface GreetingPresenter extends Presenter<GreetingPresenter.Display> {

	interface Display extends com.rb.gwthope.client.view.Display {
		HasClickHandlers getNameClickHandler();
		HasFocusHandlers getTextFocusHandler();
		
	}
	
	
}
