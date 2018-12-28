package service;

import java.util.List;
import java.util.Set;

import domain.AdressDAO;
import domain.Contact;
import domain.ContactDAO;
import domain.EntrepriseDAO;
import domain.PhoneNumberDAO;

public class ContactService {
	
	ContactDAO contactDAO = new ContactDAO();

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
