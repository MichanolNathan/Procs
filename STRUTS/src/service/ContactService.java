package service;

import java.util.List;
import domain.ContactDAO;
import modele.Contact;

public class ContactService {
	
	public ContactDAO contactDAO;

	public ContactService() {};
	
	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
	}
	
	public String addContact (Contact contact) {
		return this.contactDAO.addContact(contact);
	}
	
	public String editContact (Contact contact) {
		return this.contactDAO.editContact(contact);
	}
	
	public Contact getContact(int id) {
		return this.contactDAO.getContact(id);
	}
    public List<Contact> getAllContacts() {
    	return this.contactDAO.getAllContacts();
    }
    
    public String removeContact(Contact contact) {
    	return this.contactDAO.removeContact(contact);
    }

	
}
