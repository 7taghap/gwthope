package com.rb.gwthope.client.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.rb.gwthope.client.activity.ProductActivity.IProductViewDisplay;
import com.rb.gwthope.client.view.widget.MyFlexTable;
import com.rb.gwthope.shared.dto.UnitConversion;

public class CreateProductView extends Composite implements IProductViewDisplay {
	private final TextBox productId;
	private final TextBox productName;
	private final TextBox productDesc;
	private final TextBox shelf;
	private final TextBox totalQtyOnHand;
	private final ListBox defaultUnitType;
	

	private final FileUpload fileUpload;
	
	private final Label lblProductId;
	private final Label lblProductName;
	private final Label lblProductDesc;
	private final Label lblShelf;
	private final Label lblTotalQtyOnHand;
	private final Label lblDefaultUnitType;
	private final Label lblImage;
	private final Label lblProductDetails;

	private final FlexTable detailsTable;
	private final MyFlexTable productDetails;
	private final Button saveButton;
	private final Button cancelButton;
	private final Button addDetailButton;
	private final Button deleteDetailButton;
	private final List<String> detailHeader;

	public CreateProductView() {
		DecoratorPanel contentDetailsDecorator = new DecoratorPanel();
		// contentDetailsDecorator.setWidth("18em");
		initWidget(contentDetailsDecorator);

		VerticalPanel contentDetailsPanel = new VerticalPanel();
		contentDetailsPanel.setWidth("100%");
		//initialize Labels
		lblProductId =new Label("Product ID");
		lblProductName = new Label("Product Name");
		lblProductDesc =new Label("Product Desc");
		lblShelf = new Label("Shelf");
		lblTotalQtyOnHand =  new Label("Total Qty on Hand");
		lblDefaultUnitType = new Label("Default Unit");
		lblImage = new Label("Image");
		lblProductDetails = new Label("Product Details");
		
		//initialize buttons
		saveButton = new Button("Save");
		cancelButton = new Button("Cancel");
		addDetailButton = new Button("Add");
		deleteDetailButton = new Button("Delete");
		
		//initialize Textboxs
		productId = new TextBox();
		productName = new TextBox();
		productDesc = new TextBox();
		shelf = new TextBox();
		defaultUnitType = new ListBox();
		totalQtyOnHand = new TextBox();
		fileUpload = new FileUpload();
		
		// Add a list box with multiple selection enabled
		detailHeader = new ArrayList<String>();
		detailHeader.add("Unit");
		detailHeader.add("Selling Qty");
		detailHeader.add("Price");
		detailHeader.add("Qty on Hand");
		detailHeader.add("Suggested Price");
//		detailHeader.add("Status");
		
		
		// Create the contacts list
		//
		detailsTable = new FlexTable();
		productDetails = new MyFlexTable(detailHeader);
		detailsTable.setCellSpacing(0);
		detailsTable.setWidth("100%");
		detailsTable.addStyleName("contacts-ListContainer");
		detailsTable.getColumnFormatter().addStyleName(1, "add-contact-input");
		
		initDetailsTable();
		contentDetailsPanel.add(detailsTable);

		HorizontalPanel menuPanel = new HorizontalPanel();
		
		menuPanel.add(saveButton);
		menuPanel.add(cancelButton);
		contentDetailsPanel.add(menuPanel);
		contentDetailsDecorator.add(contentDetailsPanel);
	}

	private void initDetailsTable() {
		
		FlexCellFormatter cellFormatter = detailsTable.getFlexCellFormatter();
		detailsTable.setWidget(0, 0, lblProductId);
		detailsTable.setWidget(0, 1, productId);
		detailsTable.setWidget(1, 0,lblProductName);
		detailsTable.setWidget(1, 1, productName);
		detailsTable.setWidget(2, 0,lblProductDesc);
		detailsTable.setWidget(2, 1, productDesc);
		detailsTable.setWidget(3, 0, lblDefaultUnitType);
		detailsTable.setWidget(3, 1, defaultUnitType);
		// 2nd column
		detailsTable.setWidget(0, 2,lblTotalQtyOnHand);
		detailsTable.setWidget(0, 3, totalQtyOnHand);
		detailsTable.setWidget(1, 2,lblShelf);
		detailsTable.setWidget(1, 3, shelf);
		detailsTable.setWidget(2, 2,lblImage );
		detailsTable.setWidget(2, 3, fileUpload);
		detailsTable.setWidget(5, 0, lblProductDetails);
		detailsTable.setWidget(6, 0, productDetails);
		detailsTable.setWidget(5, 2, addDetailButton);
		cellFormatter.setColSpan(6, 0, 4);
		lblProductDetails.setStyleName("caption-h2", true);
		// detailsTable.a

		productName.setFocus(true);
	}

	public HasClickHandlers getSaveButton() {
		return saveButton;
	}
	
	public Widget asWidget() {
		return this;
	}

	@Override
	public HasClickHandlers getCancelButton() {
		return cancelButton;
	}

	@Override
	public HasClickHandlers getDeletProductDetailButton() {
		return deleteDetailButton;
	}

	@Override
	public void setDefaultUnit(List<String> defaultUnits) {
		for(String test: defaultUnits) {
			this.defaultUnitType.addItem(test);
		}
	}

	@Override
	public HasClickHandlers getAddProductDetailsButton() {
		return addDetailButton;
	}

	@Override
	public void addProductDetails(List<String> productDetails) {
		this.productDetails.addData(productDetails);
		
	}

	@Override
	public void removeData(int row) {
		productDetails.removeRow(row);
		
	}

	@Override
	public HasClickHandlers getProductDetailsTable() {
		return productDetails;
	}

	@Override
	public HTMLTable getProductDetailTable() {
		return productDetails;
	}

	@Override
	public void clear() {
		productId.setText("");
		productName.setText("");
		productDesc.setText("");
		shelf.setText("");
		totalQtyOnHand.setText("");
		productDetails.removeAllRows();
	}
	
	
	
	
}
