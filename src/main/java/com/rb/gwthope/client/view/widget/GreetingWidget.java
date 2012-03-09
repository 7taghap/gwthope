package com.rb.gwthope.client.view.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
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
import com.rb.gwthope.client.Messages;
import com.rb.gwthope.client.presenter.GreetingPresenter;

public class GreetingWidget extends Composite implements
		GreetingPresenter.Display {
	private final Messages messages = GWT.create(Messages.class);

	private  Button getNameButton;
	private final TextBox nameField = new TextBox();
	final DialogBox dialogBox = new DialogBox();
	final Button closeButton = new Button("Close");
	final Label textToServerLabel = new Label();
	final HTML serverResponseLabel = new HTML();
	VerticalPanel dialogVPanel = new VerticalPanel();

	public GreetingWidget() {
		this.setupWidget();
	}

	public Widget asWidget() {
		// TODO Auto-generated method stub
		return this;
	}

	public HasClickHandlers getGetNameClickHandlers() {
		return getNameButton;
	}

	private void setupWidget() {

		final FlowPanel panel = new FlowPanel();
		panel.setStyleName("menu");
		initWidget(panel);
		nameField.setText(messages.nameField());
		panel.add(nameField);
		getNameButton = new Button();
		panel.add(getNameButton);

		// We can add style names to widgets
		getNameButton.addStyleName("sendButton");

		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box

		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);

		// We can set the id of a widget by accessing its Element
		// closeButton.getElement().setId("closeButton");

		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);
		 closeButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent arg0) {
				 dialogBox.hide();
				 getNameButton.setEnabled(true);
				 getNameButton.setFocus(true);
				
			}
		});
	}

}
