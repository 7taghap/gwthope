package com.rb.gwthope.client.view.widget;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.rb.gwthope.client.presenter.GreetingPresenter.Display;

public class MenuWidget extends Composite implements Display{
	
//	private final DockPanel panel;
	private Widget content;
	private final Button addIssueButton;
	
	public MenuWidget(){
		final FlowPanel panel = new FlowPanel();
		panel.setStyleName("menu");
		initWidget(panel);

		addIssueButton = new Button("add issue");
		panel.add(addIssueButton);
	}

	public HasClickHandlers getGetNameClickHandlers() {
		return addIssueButton;
	}

	public Widget asWidget() {
		return this;
	}

}
