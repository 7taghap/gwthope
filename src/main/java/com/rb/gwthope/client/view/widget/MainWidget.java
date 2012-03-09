package com.rb.gwthope.client.view.widget;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Widget;
import com.rb.gwthope.client.presenter.MainPresenter;
import com.rb.gwthope.client.view.Display;

public class MainWidget extends Composite implements MainPresenter.Display {
	
	private final DockPanel panel;
	private Widget content;

	public MainWidget() {

		panel = new DockPanel();
		panel.setStyleName("main");
		initWidget(panel);

	}

	public void removeContent() {
		if (content != null) {
			panel.remove(content);
		}
	}

	public void addContent(Display display) {
		removeContent();
		content = display.asWidget();
		panel.add(display.asWidget(), DockPanel.CENTER);
	}

	public void addMenu(Display display) {
		panel.add(display.asWidget(), DockPanel.NORTH);
	}

	public Widget asWidget() {
		return this;
	}

}
