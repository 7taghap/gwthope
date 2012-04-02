package com.rb.gwthope.client.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.config.TxNamespaceHandler;

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
import com.rb.gwthope.shared.dto.Product;
import com.rb.gwthope.shared.dto.ProductCategory;
import com.rb.gwthope.shared.dto.UnitConversion;
import com.rb.gwthope.shared.util.InputFormatter;

public class CreateProductView extends Composite implements IProductViewDisplay {
	private final TextBox productId;
	private final TextBox productName;
	private final TextBox productDesc;
	private final TextBox shelf;
	private final TextBox totalQtyOnHand;
	private final ListBox defaultUnitType;
	private final ListBox lstCategory;

	private final FileUpload fileUpload;
	
	private final Label lblProductId;
	private final Label lblProductName;
	private final Label lblProductDesc;
	private final Label lblShelf;
	private final Label lblTotalQtyOnHand;
	private final Label lblDefaultUnitType;
	private final Label lblImage;
	private final Label lblProductDetails;
	private final Label lblCategory;

	private final FlexTable detailsTable;
	private final MyFlexTable productDetails;
	private final Button saveButton;
	private final Button cancelButton;
	private final Button addDetailButton;
	private final Button deleteDetailButton;
	private final List<String> detailHeader;
	
	Product product;
	boolean hasErrors;

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
		lblCategory = new Label("Category");
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
		lstCategory = new ListBox();
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
		HorizontalPanel menuPanel = new HorizontalPanel();
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
		detailsTable.setWidget(0, 2,lblCategory);
		detailsTable.setWidget(0, 3, lstCategory);
		detailsTable.setWidget(1, 2,lblTotalQtyOnHand);
		detailsTable.setWidget(1, 3, totalQtyOnHand);
		detailsTable.setWidget(2, 2,lblShelf);
		detailsTable.setWidget(2, 3, shelf);
		detailsTable.setWidget(3, 2,lblImage );
		detailsTable.setWidget(3, 3, fileUpload);
		//product details
		detailsTable.setWidget(5, 0, lblProductDetails);
		detailsTable.setWidget(6, 0, productDetails);
		menuPanel.add(addDetailButton);
		menuPanel.add(deleteDetailButton);
		detailsTable.setWidget(5, 2, menuPanel);
//		detailsTable.setWidget(5,3, deleteDetailButton);
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
		if (productDetails.getRowCount() > 1) {
			for (int x = 1; x < productDetails.getRowCount(); x++) {
				productDetails.removeRow(x);
			}
		}
		
	}

	@Override
	public void validate() {
		hasErrors = false;
		if (productName.getText().trim().length() < 1) {
			productName.setStyleName("error");
			hasErrors = true;
		}
		
	}

	@Override
	public boolean hasErrors() {

		return hasErrors;
	}

	@Override
	public Product getProduct() {
		InputFormatter formatter = new InputFormatter();
		Product product = new Product();
		ProductCategory category = new ProductCategory();
		category.setProductCategoryId(formatter.toInt(lstCategory.getValue(lstCategory.getSelectedIndex())));
		category.setCategoryName(lstCategory.getItemText(lstCategory.getSelectedIndex()));
		product.setCategory(category);
		product.setProductDesc(productDesc.getText());
		product.setProductName(productName.getText());
		product.setShelf(shelf.getText());
		product.setTotalQtyOnHand(formatter.toFloat(totalQtyOnHand.getText()));
//		product.set
		return product;
	}

	@Override
	public void setCategoryList(List<ProductCategory> productCategories) {
		for(ProductCategory category : productCategories) {
			lstCategory.addItem(category.getCategoryName(), category.getProductCategoryId()+"");
		}
		
	}
	
	
	
	
}
