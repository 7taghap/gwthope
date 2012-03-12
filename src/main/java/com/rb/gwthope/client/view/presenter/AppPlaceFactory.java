package com.rb.gwthope.client.view.presenter;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.rb.gwthope.client.place.ContactPlace;
import com.rb.gwthope.client.place.EditContactPlace;
import com.rb.gwthope.client.place.NewContactPlace;

/**
 * 
 * A place factory which knows about all the tokenizers in the app
 * 
 * @author moe
 *
 */
public class AppPlaceFactory {

	// A single instance of the tokenizer should work, since they don't have
	// state.
	@Inject
	ContactPlace.Tokenizer contactPlaceTokenizer;
	@Inject
	NewContactPlace.Tokenizer newContactPlaceTokenizer;
	@Inject
	EditContactPlace.Tokenizer editContactPlaceTokenizer;
	
	@Inject
	Provider<ContactPlace> contactProvider;
	@Inject
	Provider<NewContactPlace> newContactProvider;
	@Inject
	Provider<EditContactPlace> editContactProvider;

	// contact place
	public ContactPlace.Tokenizer getContactPlaceTokenizer() {
		return contactPlaceTokenizer;
	}

	public ContactPlace getContactPlace() {
		return contactProvider.get();
	}
	
	// new contact place
	
	public NewContactPlace.Tokenizer getNewContactPlaceTokenizer() {
		return newContactPlaceTokenizer;
	}

	public NewContactPlace getNewContactPlace() {
		return newContactProvider.get();
	}
	
	// edit contact place
	
	public EditContactPlace.Tokenizer getEditContactPlaceTokenizer() {
		return editContactPlaceTokenizer;
	}

	public EditContactPlace getEditContactPlace() {
		return editContactProvider.get();
	}
	
}
