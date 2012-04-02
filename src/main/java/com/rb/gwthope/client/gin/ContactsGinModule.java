package com.rb.gwthope.client.gin;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;

import com.google.inject.Singleton;
import com.rb.gwthope.client.activity.ContactActivity.IContactsViewDisplay;
import com.rb.gwthope.client.activity.EditContactActivity.IEditDisplay;
import com.rb.gwthope.client.activity.ProductActivity.IProductDetailViewDisplay;
import com.rb.gwthope.client.activity.ProductActivity.IProductViewDisplay;
import com.rb.gwthope.client.view.CreateProductView;
import com.rb.gwthope.client.view.ProductDetailBox;
import com.rb.gwthope.client.view.ProductForm;
import com.rb.gwthope.client.view.ProductView;
import com.rb.gwthope.client.view.SideMenuView;
import com.rb.gwthope.client.view.presenter.AppActivityMapper;
import com.rb.gwthope.client.view.presenter.AppPlaceFactory;
import com.rb.gwthope.client.view.presenter.SimpleGreetingPresenter;
import com.rb.gwthope.client.view.widget.ContactsView;
import com.rb.gwthope.client.view.widget.EditContactView;

public class ContactsGinModule extends AbstractGinModule {

	@Override
	protected void configure() {

		// bind the EventBus
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		bind(PlaceController.class).to(InjectablePlaceController.class).in(Singleton.class);
		
		bind(AppPlaceFactory.class).in(Singleton.class);
		
		// bind the mapper
		bind(ActivityMapper.class).to(AppActivityMapper.class).in(Singleton.class);
		
		// bind the views
		bind(IContactsViewDisplay.class).to(ContactsView.class);
		bind(IEditDisplay.class).to(EditContactView.class);
		
			
		// if you want to make the places singletons.
//		bind(EditContactPlace.class).in(Singleton.class);
//		bind(NewContactPlace.class).in(Singleton.class);
//		bind(ContactPlace.class).in(Singleton.class);
		
		//my added code
//		bind(IMenuViewDisplay.class).to(SideMenuView.class);
		bind(IProductViewDisplay.class).to(CreateProductView.class);
		bind(IProductDetailViewDisplay.class).to(ProductDetailBox.class).in(Singleton.class);
//		bind(ProductDetailActivity.class).in(IProductDetailViewDisplay.class);
//		bind(ProductDetailBox.class).in(ProductDetailActivity.class);
	}
	
	/**
	 * 
	 * This ensures that only one event bus is ever created and is easily
	 * accessible
	 * 
	 * @return	The singleton event bus
	 */
//	@Provides
//	EventBus provideEventBus() {
//	   return MainEventBus.get();
//	}
	
}
