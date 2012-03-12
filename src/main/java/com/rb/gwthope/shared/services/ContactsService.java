package com.rb.gwthope.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rb.gwthope.shared.dto.Contact;
import com.rb.gwthope.shared.dto.ContactDetails;

import java.util.ArrayList;



@RemoteServiceRelativePath("springGwtServices/contactsService")
public interface ContactsService extends RemoteService {
	
  Contact addContact(Contact contact);
  Boolean deleteContact(String id); 
  ArrayList<ContactDetails> deleteContacts(ArrayList<String> ids);
  ArrayList<ContactDetails> getContactDetails();
  Contact getContact(String id);
  Contact updateContact(Contact contact);
}
