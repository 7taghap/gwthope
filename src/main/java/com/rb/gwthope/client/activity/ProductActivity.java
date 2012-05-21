package com.rb.gwthope.client.activity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.scheduling.annotation.AsyncAnnotationAdvisor;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTMLTable;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.rb.gwthope.client.event.ProductEvent;
import com.rb.gwthope.client.event.ProductEventHandler;
import com.rb.gwthope.client.place.ProductPlace;
import com.rb.gwthope.client.view.DenialPopup;
import com.rb.gwthope.client.view.Display;
import com.rb.gwthope.shared.dto.Product;
import com.rb.gwthope.shared.dto.ProductCategory;
import com.rb.gwthope.shared.dto.ProductDtl;
import com.rb.gwthope.shared.dto.UnitConversion;
import com.rb.gwthope.shared.services.AuthServiceAsync;
import com.rb.gwthope.shared.services.ProductServiceAsync;


public class ProductActivity extends AbstractActivity {

	public interface IProductViewDisplay  extends Display{
		HasClickHandlers getSaveButton();
		HasClickHandlers getCancelButton();			
		HasClickHandlers getAddProductDetailsButton();
		HasClickHandlers getDeletProductDetailButton();
		HasClickHandlers getProductDetailsTable();
		HTMLTable getProductDetailTable();
		void removeData(int row);
		//each row represents column
		void addProductDetails(List<String> productDetails);
		void setDefaultUnit(List<String> defaultUnits);
		void setCategoryList(List<ProductCategory> productCategories);
		Product getProduct();
		void setContent(String content);
		
	}
	
	//interface for product details popup
	public interface IProductDetailViewDisplay  extends Display{
		HasClickHandlers getSaveButton();
		HasClickHandlers getCancelButton();
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
	private AuthServiceAsync authService;
	
	 Product product; 
	 List<ProductDtl> dtlsForSubmit;
	 List<String> selectedRows;
	 int selectedRow =-1;
	 boolean inSession = false;
	 String loginPage = "";

	@Inject
	public ProductActivity(PlaceController placeController,
			IProductViewDisplay display, EventBus eventBus,
			ProductServiceAsync rpc,IProductDetailViewDisplay popup,
			AuthServiceAsync authService) {
		super();
		this.placeController = placeController;
		this.display = display;
		this.eventBus = eventBus;
		this.productRpc = rpc;
		this.popup = popup;
		this.authService = authService;
		dtlsForSubmit = new ArrayList<ProductDtl>();
	}

	public void init(ProductPlace place) {
		this.productPlace = place;
	}

	@Override
	public void start(AcceptsOneWidget container, EventBus arg1) {
		checkSession();
		if(inSession) {
			bind();
			container.setWidget(this.display.asWidget());
			fetchDefaultUnits();
			fetchCategories();
		}
		else {
			this.display.setContent(loginPage);
			container.setWidget(this.display.asWidget());
		}
		
	}
	
	/**
	 * bind events
	 */
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
		//delete product detail button
		display.getDeletProductDetailButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {
				if(selectedRow > 0) { // o is header
					dtlsForSubmit.remove(selectedRow -1);
					display.removeData(selectedRow);

				}
				
			}
		});
		
		//save button
		display.getSaveButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {
				display.validate();
				if (!display.hasErrors()) {
					saveProduct();
				}
				
			}
		});
		
		//table click handler 
		display.getProductDetailsTable().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent arg0) {
				int row = display.getProductDetailTable().getCellForEvent(arg0).getRowIndex();	
				selectedRow=row;
				display.getProductDetailTable().getRowFormatter().addStyleName(selectedRow, "selected");
				Window.alert("selected row :" + selectedRow);
			}
		});
		
		// popup events 
		
		
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
				popup.validate();
				if (!popup.hasErrors()) {
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
//				eventBus.fireEvent(new ProductEvent());
				
			}
		});
	}
	
	/**
	 * fetch the default units 
	 */
	private void fetchDefaultUnits() {
		productRpc.getDefaultUnits(new AsyncCallback<ArrayList<UnitConversion>>() {

			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(ArrayList result) {
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
	
	
	/**
	 * fetch all categories
	 */
	private void fetchCategories() {
		productRpc.getCategories(new AsyncCallback<ArrayList<ProductCategory>>() {

			@Override
			public void onFailure(Throwable arg0) {
				Window.alert(arg0.getMessage());
				DenialPopup popup = new DenialPopup(arg0.getMessage());
				popup.show();
			}

			@Override
			public void onSuccess(ArrayList arg0) {
				display.setCategoryList(arg0);
			}
		});
	}
	
	//save product 
	private void saveProduct() {
		product = display.getProduct();
		
		product.setProductDtls(new HashSet<ProductDtl>(dtlsForSubmit));
		
		productRpc.saveProduct(product, new AsyncCallback<Product>() {

			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Product arg0) {
				product = arg0;
//				Window.alert(product.getProductId()+"");
				
			}
		});
	}
	
	private void checkSession() {
		
		authService.retrieveUsername(new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable arg0) {
				// TODO Auto-generated method stub
				Window.alert(arg0.getMessage());
				loginPage = arg0.getMessage();
			}

			@Override
			public void onSuccess(String arg0) {
				// TODO Auto-generated method stub
				Window.alert(arg0);
				inSession = true;
			}
		});
		
	}
	
}
