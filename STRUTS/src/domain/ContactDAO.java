package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.hibernate.Query;

import com.sun.rowset.CachedRowSetImpl;

import domain.DAO;
import domain.Contact;


public class ContactDAO extends DAO 
{   
    public ContactDAO() {
        super();
    }
    
    public HashSet<Contact> getAllContacts()
    {
    	HashSet<Contact> contacts = new HashSet<Contact>();
		StringBuffer request = new StringBuffer();
		request.append("select contact from Contact contact");
		Query query = super.getSession().createQuery(request.toString());
		for (final Object o : query.list()) {
			contacts.add((Contact)(o));
		}
    	return contacts;
    }

	public String removeContact(Contact contact)
	{
		String res = null;
		try 
		{	
			super.getSession().delete(contact);
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
			super.getSession().update(contact);
			super.commitTransaction();
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
			super.commitTransaction();
			res = "Adress add to the dataBase";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	/*public String searchContact(String search)
	{
		return "Je suis la méthode searchContact, vous avez cherchez : " + search;
	}*/

	public Contact getContact(int id) 
	{
		return (Contact) super.getSession().get(Contact.class, id);
	}

}
