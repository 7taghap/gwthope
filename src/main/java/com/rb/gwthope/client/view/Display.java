package com.rb.gwthope.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Widget;

public interface Display {

//	HasClickHandlers getSaveButton();
//	HasClickHandlers getCancelButton();
	void clear();
	void validate();
	boolean hasErrors();
	Widget asWidget();

}