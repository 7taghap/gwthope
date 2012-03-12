package com.rb.gwthope.client.place;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.rb.gwthope.client.activity.ContactActivity;
import com.rb.gwthope.client.view.presenter.ActivityPlace;

/**
 * A Contact Place that extends ActivityPlace
 * 
 * @author Mahamad El Tanahy
 *
 */
public class ContactPlace extends ActivityPlace<ContactActivity> {

    @Inject
    public ContactPlace(ContactActivity activity) {
    	super(activity);
    }
    
    @Prefix("list")
	public static class Tokenizer implements PlaceTokenizer<ContactPlace> {

		// Since the place is injectable, we'll let Gin do the construction.
		private final Provider<ContactPlace> placeProvider; 
		
		@Inject
        public Tokenizer(Provider<ContactPlace> placeProvider) {
            this.placeProvider = placeProvider;
        } 
		
		public String getToken(ContactPlace place) {
			return place.getPlaceName();
		}

		public ContactPlace getPlace(String token) {
			ContactPlace place = placeProvider.get();
			place.setPlaceName(token);
			return place;
		}

	}
}
