package com.rb.gwthope.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class ProductView extends Composite  {
	 private final Button addButton;
	  private final Button deleteButton;
	  private FlexTable productTable;
	  private final FlexTable contentTable;
	  
	  
	public ProductView() {
		DecoratorPanel contentTableDecorator = new DecoratorPanel();
		initWidget(contentTableDecorator);
		contentTableDecorator.setWidth("100%");
//		contentTableDecorator.setWidth("18em");
		this.addButton = new Button();
		this.deleteButton = new Button();
		
		this.contentTable = new FlexTable();
		this.initContentTable();
		
		//create the product table list
		this.productTable = new FlexTable();
		this.productTable  = new FlexTable();
		this.productTable .setCellSpacing(0);
		this.productTable .setCellPadding(0);
		this.productTable .setWidth("100%");
		this.productTable .addStyleName("contacts-ListContents");
		this.productTable .getColumnFormatter().setWidth(0, "15px");
	    contentTable.setWidget(1, 0, this.productTable );
	    
	    contentTableDecorator.add(contentTable);
	
	}
	
	private void initContentTable() {

		contentTable.setWidth("100%");
		contentTable.getCellFormatter().addStyleName(0, 0,
				"contacts-ListContainer");
		contentTable.getCellFormatter().setWidth(0, 0, "100%");
		contentTable.getFlexCellFormatter().setVerticalAlignment(0, 0,
				DockPanel.ALIGN_TOP);
	}
	

	
	
	public Widget asWidget() {
	    return this;
	  }

}
