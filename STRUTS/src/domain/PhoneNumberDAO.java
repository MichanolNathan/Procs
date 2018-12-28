package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.rowset.CachedRowSetImpl;

import domain.DAO;
import domain.PhoneNumber;

public class PhoneNumberDAO extends DAO
{
	
	public PhoneNumberDAO()
	{
		super();
	}
		
	public String addPhoneNumber (PhoneNumber phoneNumber)
	{
		String res = null;
		try {
			super.doTransaction();
			super.getSession().save(phoneNumber);
			super.doTransaction();
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
		super.doTransaction();
		phone = (PhoneNumber) super.getSession().get(PhoneNumber.class, id);
		super.endTransaction();
		return phone;
	}
	
	public String removePhoneNumber(PhoneNumber phoneNumber)
	{
		String res = null;
		try 
		{	
			super.getSession().delete(phoneNumber);
			res = "Suppression du numéro de téléphone réussie";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return res;
	}


}
