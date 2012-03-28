package com.rb.gwthope.client.view;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ls.LSException;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.dom.client.HasFocusHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.rb.gwthope.client.activity.ProductActivity.IProductDetailViewDisplay;
import com.rb.gwthope.client.activity.ProductActivity.IProductViewDisplay;

import com.rb.gwthope.shared.dto.ProductDtl;
import com.rb.gwthope.shared.dto.UnitConversion;

public class ProductDetailBox extends DialogBox implements IProductDetailViewDisplay {
//	 final DialogBox dialogBox;
	 final FlexTable content;
	 //textbox
	 final TextBox txtProductDtlId;
	 final TextBox txtSellingQty;
	 final TextBox txtQtyOnHand;
	 final TextBox txtSugPrice;
	 final TextBox txtPrice;
	 //label
	 final Label lblProductId;
	 final Label lblSellingQty;
	 final Label lblQtyOnHand;
	 final Label lblSugPrice;
	 final Label lblPrice;
	 final Label lblPriceType;
	 final Label lblUnitType;
	 //listbox
	 final ListBox lstPriceType;
	 final ListBox lstUnit;

	//button
	 final Button btnSave;
	 final Button btnCancel;

	public ProductDetailBox() {
		super();
		this.content = new FlexTable();
		this.txtProductDtlId = new TextBox();
		this.txtSellingQty = new TextBox();
		this.txtQtyOnHand = new TextBox();
		this.txtSugPrice = new TextBox();
		this.txtPrice = new TextBox();
		
		this.lblProductId = new Label("Product Id");
		this.lblSellingQty = new Label("Selling Qty");
		this.lblQtyOnHand = new Label("Qty on Hand");
		this.lblSugPrice = new Label("Suggested Price");
		this.lblPrice = new Label("Price");
		this.lblPriceType = new Label("Price Type");
		this.lblUnitType = new Label("Unit Type");
		this.lstPriceType = new ListBox();
		
		this.lstUnit = new ListBox();
		
		btnSave = new Button("Save");
		btnCancel = new Button("Cancel");
		
		initContentTable();
		setPriceTypeItem();
		
//		dtlsForSubmit = new ArrayList<ProductDtl>();

		
	}
	
	private void initContentTable() {
		ensureDebugId("cwDialogBox");
		VerticalPanel dialogContents = new VerticalPanel();
		  
		setText("Product Detail");
	    dialogContents.setWidth("100%");
	    dialogContents.setSpacing(4);
	    dialogContents.add(content);
	    HorizontalPanel buttonPanel = new HorizontalPanel();
	    buttonPanel.add(btnSave);
	    
	    buttonPanel.add(btnCancel);
		content.setWidget(0,0, lblProductId);
		content.setWidget(0,1,txtProductDtlId);
		content.setWidget(1,0,txtProductDtlId);
		content.setWidget(2,0,lblUnitType);
		content.setWidget(2,1,lstUnit);
		content.setWidget(3,0,lblSellingQty);
		content.setWidget(3,1,txtSellingQty);
		content.setWidget(4,0,lblPrice);
		content.setWidget(4,1,txtPrice);
		content.setWidget(5,0,lblQtyOnHand);
		content.setWidget(5,1,txtQtyOnHand);
		content.setWidget(6,0,lblPriceType);
		content.setWidget(6,1,lstPriceType);
		
		content.setWidget(7,0,buttonPanel);
		
	    
	    setWidget(dialogContents);
	}
	
	private void setPriceTypeItem() {
		lstPriceType.addItem("Retail");
		lstPriceType.addItem("Wholesale");
	}

	public DialogBox asWidget() {
		return this;
	}

	public HasClickHandlers getSaveButton() {
		// TODO Auto-generated method stub
		return btnSave;
	}


	public void setDefaultUnit(List<UnitConversion> units) {
		for(UnitConversion unit : units) {
			lstUnit.addItem(unit.getName(), unit.getId()+"");
		}
		
	}


	public HasClickHandlers getCancelButton() {
		return btnCancel;
	}

	@Override
	public ProductDtl getProductDetail() {
		ProductDtl dtl = addProductDtl();
		clear();
		this.hide();
		return dtl;
	}
	
	/**
	 * add product dtl to a list for submission to server
	 * @return
	 */
	private ProductDtl addProductDtl() {
		ProductDtl dtl = new ProductDtl();
		UnitConversion unit = new UnitConversion();
		unit.setId(Integer.parseInt(lstUnit.getValue(lstUnit.getSelectedIndex())));
		unit.setName(lstUnit.getItemText(lstUnit.getSelectedIndex()));
		dtl.setUnitConversion(unit);
		dtl.setSellingQty(Float.parseFloat(txtSellingQty.getText()));
		dtl.setPrice(Double.parseDouble(txtPrice.getText()));
		dtl.setQtyOnHand(Float.parseFloat(txtQtyOnHand.getText()));
//		dtl.setSugPrice(Double.parseDouble(txtSugPrice.getText()));
//		dtlsForSubmit.add(dtl);
		return dtl;
		
	}

	/**
	 * clear textbox
	 */
	public void clear() {
		txtPrice.setText("");
		txtProductDtlId.setText("");
		txtQtyOnHand.setText("");
		txtSugPrice.setText("");
	}

	@Override
	public void close() {
		if (this.isShowing())
			this.hide();
	}

	@Override
	public void open() {
		this.show();
		this.center();
		
	}

	public HasClickHandlers getCloseButton() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
