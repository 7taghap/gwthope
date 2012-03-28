package com.rb.gwthope.client.place;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.rb.gwthope.client.activity.EditContactActivity;
import com.rb.gwthope.client.view.presenter.ActivityPlace;

/**
 * A New Contact Place that extends ActivityPlace
 * 
 * @author Mahamad El Tanahy
 *
 */
public class NewContactPlace extends ActivityPlace<EditContactActivity> {

    @Inject
    public NewContactPlace(EditContactActivity activity) {
    	super(activity);
    }
    
    @Override
    public EditContactActivity getActivity() {
    	activity.init(this);
    	return activity;
    }
    
    @Prefix("new")
	public static class Tokenizer implements PlaceTokenizer<NewContactPlace> {

		// Since the place is injectable, we'll let Gin do the construction.
		private final Provider<NewContactPlace> placeProvider; 
		
		@Inject
        public Tokenizer(Provider<NewContactPlace> placeProvider) {
            this.placeProvider = placeProvider;
            GWT.log("NewContactPlace.Tokenizer.PlaceProvider: " + placeProvider);
        }
		
		public String getToken(NewContactPlace place) {
			return place.getPlaceName();
		}

		public NewContactPlace getPlace(String token) {
			NewContactPlace place = placeProvider.get();
			place.setPlaceName(token);
			return place;
		}

	}
}
