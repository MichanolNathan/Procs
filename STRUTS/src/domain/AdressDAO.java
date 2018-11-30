package domain;

import domain.DAO;
import domain.Adress;


public class AdressDAO extends DAO
{
	
	public AdressDAO()
	{
		super();
	}
	
	public String addAdress(Adress adress)
	{
		String res = null;
		try {
			super.doTransaction();
			super.getSession().save(adress);
			super.doTransaction();
			res = "Adress add to the dataBase";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public String editAdress(Adress adress)
	{
		String res = null;
		try 
		{
			super.getSession().update(adress);
			super.doTransaction();
			res = "mise à jour de l'adresse réussie";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public Adress getAdress(int id) 
	{
		return (Adress) super.getSession().get(Adress.class, id);
	}
	
	public String removeAdress(Adress adress)
	{
		String res = null;
		try 
		{	
			super.getSession().delete(adress);
			res = "Suppression de l'adresse réussie";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return res;
	}

}
