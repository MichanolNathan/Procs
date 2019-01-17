package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import com.sun.rowset.CachedRowSetImpl;

import domain.DAO;
import domain.Contact;

import org.hibernate.stat.Statistics;
import util.HibernateUtil;

public class ContactDAO extends DAO 
{   
    public ContactDAO() {
        super();
    }
    
    public List <Contact> getAllContacts()
    {
    	List <Contact> contacts = new ArrayList<Contact>();
    	super.doTransaction();
    	contacts = super.getSession().createQuery("select distinct contact from Contact contact left join fetch contact.phoneNumbers phone").list();
		super.endTransaction();
    	return contacts;
    }

	public String removeContact(Contact contact)
	{
		String res = null;
		try 
		{	
			super.doTransaction();
			super.getSession().delete(contact);
			super.endTransaction();
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
			super.doTransaction();
			super.getSession().update(contact);
			super.endTransaction();
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
			super.doTransaction();
			super.getSession().save(contact);
			super.endTransaction();
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
		super.doTransaction();
		contact = (Contact) super.getSession().get(Contact.class, id);
		super.endTransaction();
		return contact;
	}

}
