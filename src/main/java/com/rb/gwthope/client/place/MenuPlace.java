package com.rb.gwthope.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.rb.gwthope.client.activity.MenuActivity;
import com.rb.gwthope.client.view.presenter.ActivityPlace;

public class MenuPlace extends ActivityPlace<MenuActivity>{

	@Inject
	public MenuPlace(MenuActivity activity) {
		super(activity);
		// TODO Auto-generated constructor stub
	}
	
	@Prefix("home")
	public static class Tokenizer implements PlaceTokenizer<MenuPlace> {

		private final Provider<MenuPlace> placeProvider;
		@Inject
        public Tokenizer(Provider<MenuPlace> placeProvider) {
            this.placeProvider = placeProvider;
        } 
		public MenuPlace getPlace(String arg0) {
			MenuPlace place =placeProvider.get();
			place.setPlaceName(arg0);
			return place;
		}

		public String getToken(MenuPlace place) {
			return place.getPlaceName();
		}
	
	}
	
	


}
