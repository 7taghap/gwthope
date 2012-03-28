package com.rb.gwthope.client.gin;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;

/**
 * The injectable PlaceController to be able to inject the eventbus into
 * 
 * @author Mahamad El Tanahy (Bright Creations)
 *
 */
public class InjectablePlaceController extends PlaceController {

	@Inject
	public InjectablePlaceController(EventBus eventBus) {
		super(eventBus);
	}

}
