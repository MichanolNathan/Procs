package domain;
import org.hibernate.SessionFactory;

import domain.DAO;
import modele.Adresse;

public class AdressDAO extends DAO
{	
	
	public AdressDAO(SessionFactory sessionFactory)
	{
		super(sessionFactory);
	}

	
	public String addAdresse(Adresse adress)
	{
		String res = null;
		try {
			//super.doTransaction();
			super.getSessionFactory().getCurrentSession().save(adress);
			//super.endTransaction();
			res = "Adress add to the dataBase";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	public Adresse getAdresse(int id) 
	{
		Adresse adresse = null;
		//super.doTransaction();
		adresse = (Adresse) super.getSessionFactory().getCurrentSession().get(Adresse.class, id);
		//super.endTransaction();
		return adresse;
	}
	
	public String removeAdresse(Adresse adress)
	{
		String res = null;
		try 
		{	
			super.getSessionFactory().getCurrentSession().delete(adress);
			res = "Suppression de l'adresse réussie";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	

	

}
