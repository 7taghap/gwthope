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

	private final FlexTable detailsTable;
	private final MyFlexTable productDetails;
	private final Button saveButton;
	private final Button cancelButton;
	private final List<String> detailHeader;

	public CreateProductView() {
		DecoratorPanel contentDetailsDecorator = new DecoratorPanel();
		// contentDetailsDecorator.setWidth("18em");
		initWidget(contentDetailsDecorator);

		VerticalPanel contentDetailsPanel = new VerticalPanel();
		contentDetailsPanel.setWidth("100%");

		// Add a list box with multiple selection enabled

		detailHeader = new ArrayList<String>();
		detailHeader.add("ID");
		detailHeader.add("Name");
		detailHeader.add("Qty");
		detailHeader.add("Amount");
		detailHeader.add("Unit");
		// Create the contacts list
		//
		detailsTable = new FlexTable();
		productDetails = new MyFlexTable(detailHeader);
		detailsTable.setCellSpacing(0);
		detailsTable.setWidth("100%");
		detailsTable.addStyleName("contacts-ListContainer");
		detailsTable.getColumnFormatter().addStyleName(1, "add-contact-input");
		productId = new TextBox();
		productName = new TextBox();
		productDesc = new TextBox();
		shelf = new TextBox();
		defaultUnitType = new ListBox();
		totalQtyOnHand = new TextBox();
		fileUpload = new FileUpload();
		initDetailsTable();
		contentDetailsPanel.add(detailsTable);

		HorizontalPanel menuPanel = new HorizontalPanel();
		saveButton = new Button("Save");
		cancelButton = new Button("Cancel");
		menuPanel.add(saveButton);
		menuPanel.add(cancelButton);
		contentDetailsPanel.add(menuPanel);
		contentDetailsDecorator.add(contentDetailsPanel);
	}

	private void initDetailsTable() {
		FlexCellFormatter cellFormatter = detailsTable.getFlexCellFormatter();
		detailsTable.setWidget(0, 0, new Label("Product ID"));
		detailsTable.setWidget(0, 1, productId);
		detailsTable.setWidget(1, 0, new Label("Product Name"));
		detailsTable.setWidget(1, 1, productName);
		detailsTable.setWidget(2, 0, new Label("Product Desc"));
		detailsTable.setWidget(2, 1, productDesc);
		detailsTable.setWidget(3, 0, new Label("Default Unit"));
		detailsTable.setWidget(3, 1, defaultUnitType);
		// 2nd column
		detailsTable.setWidget(0, 2, new Label("Total Qty on Hand"));
		detailsTable.setWidget(0, 3, totalQtyOnHand);
		detailsTable.setWidget(1, 2, new Label("Shelf"));
		detailsTable.setWidget(1, 3, shelf);
		detailsTable.setWidget(2, 2, new Label("Image"));
		detailsTable.setWidget(2, 3, fileUpload);
		detailsTable.setWidget(5, 0, new Label("Product Details"));
		detailsTable.setWidget(6, 0, productDetails);
		cellFormatter.setColSpan(4, 0, 2);
		cellFormatter.setStyleName(3, 0, "caption-h2");
		// detailsTable.a

		productName.setFocus(true);
	}

	private void initProductDetailsTable() {
		productDetails.setWidget(0, 0, new Label("ID"));
	}

	public HasClickHandlers getSaveButton() {
		return saveButton;
	}
	
	public Widget asWidget() {
		return this;
	}

	@Override
	public HasClickHandlers getClearButton() {
		// TODO Auto-generated method stub
		return cancelButton;
	}

	@Override
	public void setDefaultUnit(List<String> defaultUnits) {
		defaultUnits.removeAll(defaultUnits);
		defaultUnits.addAll(defaultUnits);

	}
}
