package com.rb.gwthope.client.view.presenter;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.rb.gwthope.client.place.ContactPlace;
import com.rb.gwthope.client.place.EditContactPlace;
import com.rb.gwthope.client.place.MenuPlace;
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
	MenuPlace.Tokenizer menuPlaceTokenizer;
	
	@Inject
	Provider<ContactPlace> contactProvider;
	@Inject
	Provider<NewContactPlace> newContactProvider;
	@Inject
	Provider<EditContactPlace> editContactProvider;
	
	@Inject
	Provider<MenuPlace> menuPlace;

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

	public MenuPlace.Tokenizer getMenuPlaceTokenizer() {
		return menuPlaceTokenizer;
	}

	public void setMenuPlaceTokenizer(MenuPlace.Tokenizer menuPlaceTokenizer) {
		this.menuPlaceTokenizer = menuPlaceTokenizer;
	}

	public MenuPlace getMenuPlace() {
		return menuPlace.get();
	}

	public void setMenuPlace(Provider<MenuPlace> menuPlace) {
		this.menuPlace = menuPlace;
	}
	
}
