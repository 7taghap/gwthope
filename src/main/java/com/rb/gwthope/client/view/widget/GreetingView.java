package com.rb.gwthope.client.view.widget;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasFocusHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.rb.gwthope.client.view.presenter.GreetingPresenter;
import com.rb.gwthope.client.view.presenter.SimpleGreetingPresenter.Display;

public class GreetingView extends Composite implements Display{
	
	final Button sendButton;
	final TextBox nameField;
	final Label errorLabel;
	final FlowPanel panel;
	
	
	public GreetingView() {
		panel = new FlowPanel();
		initWidget(panel);
		sendButton = new Button("sdf");
		nameField = new TextBox();
		errorLabel = new Label();
		nameField.setText("Enter ID");
		// We can add style names to widgets
		sendButton.addStyleName("sendButton");
		nameField.setFocus(true);
		nameField.selectAll();
		panel.add(sendButton);
		panel.add(nameField);
		panel.add(errorLabel);
	}
	public HasClickHandlers getNameClickHandler() {
		return sendButton;
	}

	public HasFocusHandlers getTextFocusHandler() {
		return nameField;
	}
	
	public  Widget asWidget(){
		return this;
	}

}
