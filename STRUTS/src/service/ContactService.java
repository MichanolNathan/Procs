package service;

import java.util.List;
import java.util.Set;

import domain.AdressDAO;
import domain.Contact;
import domain.ContactDAO;
import domain.EntrepriseDAO;
import domain.PhoneNumberDAO;

public class ContactService {
	
	PhoneNumberDAO daoPhone = new PhoneNumberDAO();
	ContactDAO contactDao = new ContactDAO();
	EntrepriseDAO entrepriseDAO = new EntrepriseDAO();
	AdressDAO addresseDao = new AdressDAO();
	
	public ContactService() {};
	public String addContact (Contact contact) {
		return this.contactDao.addContact(contact);
	}
	
	public String editContact (Contact contact) {
		return this.contactDao.editContact(contact);
	}
	
	public Contact getContact(int id) {
		return this.contactDao.getContact(id);
	}
    public List<Contact> getAllContacts() {
    	return this.contactDao.getAllContacts();
    }
    
    public String removeContact(Contact contact) {
    	return this.contactDao.removeContact(contact);
    }

	
}
