package com.rb.gwthope.client.view.presenter;


import com.google.inject.Inject;
import com.google.inject.Provider;
import com.rb.gwthope.client.AppController;
import com.rb.gwthope.client.place.ContactPlace;
import com.rb.gwthope.client.place.EditContactPlace;
import com.rb.gwthope.client.place.MainPlace;
import com.rb.gwthope.client.place.NewContactPlace;
import com.rb.gwthope.client.place.ProductPlace;

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
	ProductPlace.Tokenizer productPlaceTokenizer;
//	MenuPlace.Tokenizer menuPlaceTokenizer;
	
//	@Inject
//	MainPlace.Tokenizer mainPlaceTokinizer;
//	@Inject
//	Provider<MainPlace> mainProvider;
	
	@Inject
	Provider<ContactPlace> contactProvider;
	@Inject
	Provider<NewContactPlace> newContactProvider;
	@Inject
	Provider<EditContactPlace> editContactProvider;
	
	@Inject
	Provider<ProductPlace> productPlace;
	
	
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

	public ProductPlace.Tokenizer getProductPlaceTokenizer() {
		return productPlaceTokenizer;
	}

	public void setProductPlaceTokenizer(
			ProductPlace.Tokenizer productPlaceTokenizer) {
		this.productPlaceTokenizer = productPlaceTokenizer;
	}

	public Provider<ProductPlace> getProductPlace() {
		return productPlace;
	}

	public void setProductPlace(Provider<ProductPlace> productPlace) {
		this.productPlace = productPlace;
	}

	
	

//	public MainPlace.Tokenizer getMainPlaceTokinizer() {
//		return mainPlaceTokinizer;
//	}
//
//	public void setMainPlaceTokinizer(MainPlace.Tokenizer mainPlaceTokinizer) {
//		this.mainPlaceTokinizer = mainPlaceTokinizer;
//	}
//
//	public MainPlace getMainProvider() {
//		return mainProvider.get();
//	}
//
//	public void setMainProvider(Provider<MainPlace> mainProvider) {
//		this.mainProvider = mainProvider;
//	}
//	
	
}
