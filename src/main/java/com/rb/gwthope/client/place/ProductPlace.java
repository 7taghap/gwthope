package com.rb.gwthope.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.rb.gwthope.client.activity.ProductActivity;
import com.rb.gwthope.client.view.presenter.ActivityPlace;

public class ProductPlace extends ActivityPlace<ProductActivity> {

	@Inject
	public ProductPlace(ProductActivity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}
	
	@Prefix("product")
	public static class Tokenizer implements PlaceTokenizer<ProductPlace> {

		private final Provider<ProductPlace> placeProvider;
		
		@Inject
		public Tokenizer(Provider<ProductPlace> placeProvider) {
			this.placeProvider = placeProvider;
		}
		
		@Override
		public ProductPlace getPlace(String arg0) {
			ProductPlace place = placeProvider.get();
			place.setPlaceName(arg0);
			return place;
		}

		@Override
		public String getToken(ProductPlace arg0) {
			return arg0.getPlaceName();
		}
		
	}

}
