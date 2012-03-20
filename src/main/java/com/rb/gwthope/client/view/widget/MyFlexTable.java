package com.rb.gwthope.client.view.widget;

import java.util.List;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class MyFlexTable extends FlexTable{

	private List<String> headers;

	public MyFlexTable(List headers) {
		super();
		this.headers = headers;
		this.initHeaders();
		addStyleName("cw-FlexTable");
	}
	
	private void initHeaders(){
		int x = 0;
		for (String header : headers) {
			setWidget(0, x, new Label(header));
			x++;
		}
	}
	
	public void setHeaders(List<String> headers) {
		this.headers = headers;
		this.initHeaders();
	}
	
	public Widget asWidget() {
		return this;
	}
	
	
}
