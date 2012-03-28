package com.rb.gwthope.client.view.widget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasFocusHandlers;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.rb.gwthope.client.activity.GreetingActivity.GreetingDisplay;
import com.rb.gwthope.client.view.presenter.GreetingPresenter.Display;

public class GreetingWidget extends Composite implements
		GreetingDisplay {

	final Button sendButton;
	final TextBox nameField;
	final Label errorLabel;
	final FlowPanel panel;

	public HasClickHandlers getNameClickHandler() {
		return sendButton;
	}

	public GreetingWidget() {
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
		
		// RootPanel.get("nameFieldContainer").add(nameField);
		// RootPanel.get("sendButtonContainer").add(sendButton);
		// RootPanel.get("errorLabelContainer").add(errorLabel);
//		 MyHandler handler = new MyHandler();
//		    sendButton.addClickHandler(handler);
		    
		
	}
//	 class MyHandler implements ClickHandler, KeyUpHandler {
//	      /**
//	       * Fired when the user clicks on the sendButton.
//	       */
//	      public void onClick(ClickEvent event) {
//	        Window.alert("click name");
//	      }
//
//		public void onKeyUp(KeyUpEvent arg0) {
//			// TODO Auto-generated method stub
//			
//		}
//	 }
	
	public Widget asWidget() {
		return this;
	}

	public HasFocusHandlers getTextFocusHandler() {
		// TODO Auto-generated method stub
		return nameField;
	}

	public HasClickHandlers getSaveButton() {
		// TODO Auto-generated method stub
		return null;
	}

	public HasClickHandlers getCancelButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
