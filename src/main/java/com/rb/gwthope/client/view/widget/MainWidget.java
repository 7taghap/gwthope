package com.rb.gwthope.client.view.widget;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.rb.gwthope.client.view.presenter.MainPresenter.Display;

/**
 * Main widget, instead of using html layout
 * @author caburnar
 * 
 */
public class MainWidget extends Composite implements Display{
	
	private final DockPanel dockPanel;
	private Widget content;
	
	public MainWidget() {
		dockPanel = new DockPanel();
		
		initWidget(dockPanel);
//		this.addMenu(null);
	}

	public void removeContent() {
		if (content != null) {
			dockPanel.remove(content);
		}
		
	}
	
	public Widget asWidget() {
		return this;
	}

	public void addMenu(com.rb.gwthope.client.view.Display display) {
		dockPanel.add(display.asWidget(),DockPanel.NORTH);
		
	}

	public void addContent(com.rb.gwthope.client.view.Display display) {
		removeContent();
		content = display.asWidget();
		dockPanel.add(display.asWidget(),DockPanel.CENTER);
		
	}

//	@Override
	public HasClickHandlers getSaveButton() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
	public HasClickHandlers getCancelButton() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasErrors() {
		// TODO Auto-generated method stub
		return false;
	}

}
