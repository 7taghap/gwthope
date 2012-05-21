package com.rb.gwthope.client.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.rb.gwthope.client.activity.ProductActivity.IProductViewDisplay;
import com.rb.gwthope.shared.dto.Product;
import com.rb.gwthope.shared.dto.ProductCategory;
import com.rb.gwthope.shared.util.MyXmlParser;

public class ProductForm extends Composite implements IProductViewDisplay{
	
	MyXmlParser xmlParser;
	private final FlexTable contentTable;
	VerticalPanel contentDetailsPanel = new VerticalPanel();
	List<Button> buttons;
	public ProductForm () {
		xmlParser = new MyXmlParser("product-frm.xml");
		contentTable = new FlexTable();
		buttons = new ArrayList<Button>();
		initWidget();
	}
	
	private void initWidget() {
//		contentDetailsPanel = new VerticalPanel();
		contentDetailsPanel.setWidth("100%");
		initContentTable();
		contentDetailsPanel.add(contentTable);
	}
	
	private void initContentTable() {
		int x = 0;
		for(String labelName : xmlParser.getLabels()) {
			Label label = new Label(labelName);
			contentTable.setWidget(x, 0, label);
			x++;
		}
		x = 0;
		for (String text : xmlParser.getTextboxs()) {
			TextBox textBox = new TextBox();
			contentTable.setWidget(x,1,textBox);
			x++;
		}
		HorizontalPanel menuPanel = new HorizontalPanel();
		for (String text : xmlParser.getButtons()) {
			Button btn = new Button(text);
			buttons.add(btn);
			menuPanel.add(btn);
			
//			contentTable.setWidget(x, 0, btn);
		}
		contentDetailsPanel.add(menuPanel);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HasClickHandlers getSaveButton() {
		// TODO Auto-generated method stub

		return buttons.get(this.getButtonIndex("save"));
	}

	@Override
	public HasClickHandlers getCancelButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasClickHandlers getAddProductDetailsButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasClickHandlers getDeletProductDetailButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasClickHandlers getProductDetailsTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HTMLTable getProductDetailTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeData(int row) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addProductDetails(List<String> productDetails) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDefaultUnit(List<String> defaultUnits) {
		// TODO Auto-generated method stub
		
	}
	
	private int getButtonIndex(String name){ 
		int i = -1;
		int x = 0;
		for(Button btn  :buttons ) {
			if (btn.getText().equalsIgnoreCase(name)) {
				i = x;
				
			}
			x++;
		}
		return i;
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

	@Override
	public void setCategoryList(List<ProductCategory> productCategories) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContent(String content) {
		// TODO Auto-generated method stub
		
	}

}
