package com.rb.gwthope.server;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.rb.gwthope.shared.dto.Contact;
import com.rb.gwthope.shared.dto.ContactDetails;
import com.rb.gwthope.shared.services.ContactsService;

@Service("contactsService")
public class ContactServiceImpl implements ContactsService{

	public Contact addContact(Contact contact) {
		// TODO Auto-generated method stub

		contact.setId("1");
		contact.setEmailAddress("contact@sample.com");
		contact.setFirstName("firstname");
		contact.setLastName("Lastname");
		return contact;
	}

	public Boolean deleteContact(String id) {
		// TODO Auto-generated method stub
		return true;
	}

	public ArrayList<ContactDetails> deleteContacts(ArrayList<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ContactDetails> getContactDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public Contact getContact(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Contact updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

}
