package com.rb.gwthope.client.activity;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.rb.gwthope.client.place.ProductPlace;
import com.rb.gwthope.client.view.Display;
import com.rb.gwthope.shared.dto.ProductDtl;
import com.rb.gwthope.shared.dto.UnitConversion;
import com.rb.gwthope.shared.services.ProductServiceAsync;

public class ProductActivity extends AbstractActivity {

	public interface IProductViewDisplay  extends Display{
			
		HasClickHandlers getAddProductDetailsButton();
		HasClickHandlers getDeletProductDetailButton();
		HasClickHandlers getProductDetailsTable();
		HTMLTable getProductDetailTable();
		void removeData(int row);
		//each row represents column
		void addProductDetails(List<String> productDetails);
		void setDefaultUnit(List<String> defaultUnits);
		
	}
	
	//interface for product details popup
	public interface IProductDetailViewDisplay  extends Display{
	
		void setDefaultUnit(List<UnitConversion> units);
		ProductDtl getProductDetail();
		void close();
		void open();
	}

	private ProductPlace productPlace;
	private List<UnitConversion> unitConversions;
	private PlaceController placeController;
	private IProductViewDisplay display;
	private final EventBus eventBus;
	private ProductServiceAsync productRpc;
	private IProductDetailViewDisplay popup;
	
	 List<ProductDtl> dtlsForSubmit;

	@Inject
	public ProductActivity(PlaceController placeController,
			IProductViewDisplay display, EventBus eventBus,
			ProductServiceAsync rpc,IProductDetailViewDisplay popup) {
		super();
		this.placeController = placeController;
		this.display = display;
		this.eventBus = eventBus;
		this.productRpc = rpc;
		this.popup = popup;
		dtlsForSubmit = new ArrayList<ProductDtl>();
	}

	public void init(ProductPlace place) {
		this.productPlace = place;
	}

	@Override
	public void start(AcceptsOneWidget container, EventBus arg1) {
		// TODO Auto-generated method stub
		bind();
		container.setWidget(this.display.asWidget());
		fetchDefaultUnits();
		
	}
	
	public void bind() {
		
		//add product button
		display.getAddProductDetailsButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {
				popup.open();
			}
		});
		//clear button 
		display.getCancelButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {
				display.clear();
				dtlsForSubmit = new ArrayList<ProductDtl>();
				
			}
		});
		//table click handler 
		display.getProductDetailsTable().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {
				int row = display.getProductDetailTable().getCellForEvent(arg0).getRowIndex();	
//				display.getProductDetailTable().get
			}
		});
		
		//popup events 
		popup.getCancelButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				popup.close();
				
			}
		});
		
		popup.getSaveButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {
				List<String> productDtlRow = new ArrayList<String>();
				ProductDtl dtl = popup.getProductDetail();
				productDtlRow.add(dtl.getUnitConversion().getName());
				productDtlRow.add(dtl.getSellingQty()+"");
				productDtlRow.add(dtl.getPrice()+"");
				productDtlRow.add(dtl.getQtyOnHand()+"");
				productDtlRow.add(dtl.getSugPrice()+"");
				dtlsForSubmit.add(dtl);
				display.addProductDetails(productDtlRow);
				popup.close();
				
			}
		});
	}

	private void fetchDefaultUnits() {
		productRpc
				.getDefaultUnits(new AsyncCallback<ArrayList<UnitConversion>>() {

					@Override
					public void onFailure(Throwable arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(ArrayList<UnitConversion> result) {
						unitConversions = result;
						List<String> units = new ArrayList<String>();
						for(UnitConversion unit : unitConversions) {
							units.add(unit.getName());
						}
						display.setDefaultUnit(units);
						popup.setDefaultUnit(result);
					}
				});
	}

}
