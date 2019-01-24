package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.sun.rowset.CachedRowSetImpl;

import domain.DAO;
import modele.PhoneNumber;

public class PhoneNumberDAO extends DAO
{
	private SessionFactory sessionFactory;
	

	
	public PhoneNumberDAO(SessionFactory sessionFactory)
	{
		super(sessionFactory);
	}
		
	public String addPhoneNumber (PhoneNumber phoneNumber)
	{
		String res = null;
		try {
			//super.doTransaction();
			this.sessionFactory.getCurrentSession().save(phoneNumber);
			//super.doTransaction();
			res = "Adress add to the dataBase";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public PhoneNumber getPhoneNumber(int id) 
	{
		PhoneNumber phone = null;
		//super.doTransaction();
		phone = (PhoneNumber)super.getSessionFactory().getCurrentSession().get(PhoneNumber.class, id);
		//super.endTransaction();
		return phone;
	}
	
	public String removePhoneNumber(PhoneNumber phoneNumber)
	{
		String res = null;
		try 
		{	
			this.sessionFactory.getCurrentSession().delete(phoneNumber);
			res = "Suppression du numéro de téléphone réussie";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

}
