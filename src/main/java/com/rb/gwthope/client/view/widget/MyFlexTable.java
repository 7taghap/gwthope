package com.rb.gwthope.client.view.widget;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class MyFlexTable extends FlexTable{

	private List<String> headers;
//	private final Button btnDelete;
//	private int btnPlaceHolder;
	public MyFlexTable(List headers) {
		super();
//		btnDelete = new Button();
		this.headers = headers;
		this.initHeaders();
		addStyleName("cw-FlexTable");
		setWidth("100%");
	}
	
	private void initHeaders(){
		int x = 0;
		for (String header : headers) {
			setWidget(0, x, new Label(header));
//			getColumnFormatter().setStyleName(x, "MyFlxHeader-"+header);
			x++;
		}
		//add command 
//		setWidget(0,x,btnDelete);
//		btnPlaceHolder = x;
	}
	
	public void setHeaders(List<String> headers) {
		this.headers = headers;
		this.initHeaders();
	}
	
	public void addData(List<String> data) {
		int row = getRowCount();
		int col = 0;
		for (String value : data) {
			setWidget(row, col, new Label(value));
			col++;
		}
		
	}
	
	public Widget asWidget() {
		return this;
	}
	
	public void selectRow(int row) {
		if (!getRowFormatter().getStyleName(row).contains("selected")) {
			getRowFormatter().addStyleName(row,"selected");
		}
//		if (rowIndex != selected) {
//			display.getListTable().getRowFormatter().removeStyleName(selected,
//					"selected");
//			selected = rowIndex;
//			display.getListTable().getRowFormatter().addStyleName(selected, "selected");
//		}
	}
	
	public int[] getSelectedRows() {
		int rows[] = new int[getRowCount()];
		int selected = 0;
		for (int x = 0; x < getRowCount(); x++ ) {
			if(getRowFormatter().getStyleName(x).contains("selected")) {
				rows[selected] = x;
				selected++;
			}
		}
		return rows;
	}
//	private HorizontalPanel getActionButton() {
//		HorizontalPanel panel = new HorizontalPanel();
//		panel.add(btnDelete);
//		
//		return panel;
//	}
//	
//	public HasClickHandlers getDeleteButton() {
//		return btnDelete;
//	}
	
	
	
	
	
}
