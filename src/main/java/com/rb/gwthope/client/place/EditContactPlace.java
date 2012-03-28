package com.rb.gwthope.client.place;

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
public class EditContactPlace extends ActivityPlace<EditContactActivity> {

	@Inject
    public EditContactPlace(EditContactActivity activity) {
		super(activity);
    }
    
	@Override
    public EditContactActivity getActivity() {
    	activity.init(this);
    	return activity;
    }
	
    @Prefix("edit")
	public static class Tokenizer implements PlaceTokenizer<EditContactPlace> {

		// Since the place is injectable, we'll let Gin do the construction.
		private final Provider<EditContactPlace> placeProvider; 
		
		@Inject
        public Tokenizer(Provider<EditContactPlace> placeProvider) {
            this.placeProvider = placeProvider;
        } 
		
		public String getToken(EditContactPlace place) {
			return place.getPlaceName();
		}

		public EditContactPlace getPlace(String token) {
			EditContactPlace place = placeProvider.get();
			place.setPlaceName(token);
			return place;
		}

	}
}
