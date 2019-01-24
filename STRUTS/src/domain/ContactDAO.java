package domain;


import java.util.ArrayList;
import java.util.List;
import domain.DAO;
import modele.Contact;

import org.hibernate.SessionFactory;

public class ContactDAO extends DAO 
{   		
    public ContactDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    public List <Contact> getAllContacts()
    {
    	List <Contact> contacts = new ArrayList<Contact>();
    	//super.doTransaction();
    	contacts = super.getSessionFactory().getCurrentSession().createQuery("select distinct contact from Contact contact left join fetch contact.phoneNumbers phone").list();
		//super.endTransaction();
    	return contacts;
    }

	public String removeContact(Contact contact)
	{
		String res = null;
		try 
		{	
			//super.doTransaction();
			super.getSessionFactory().getCurrentSession().delete(contact);
			//super.endTransaction();
			res = "Suppression du contact réussie";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public String editContact(Contact contact)
	{
		String res = null;
		try 
		{
			//super.doTransaction();
			super.getSessionFactory().getCurrentSession().update(contact);
			//super.endTransaction();
			res = "mise à jour du contact réussie";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public String addContact(Contact contact)
	{
		String res = null;
		try {
			//super.doTransaction();
			super.getSessionFactory().getCurrentSession().save(contact);
			//super.endTransaction();
			res = "Contact add to the DataBase";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public Contact getContact(int id) 
	{
		Contact contact = null;
		//super.doTransaction();
		contact = (Contact) super.getSessionFactory().getCurrentSession().get(Contact.class, id);
		//super.endTransaction();
		return contact;
	}
}
