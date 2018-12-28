package domain;
import domain.DAO;

public class AdressDAO extends DAO
{
	
	public AdressDAO()
	{
		super();
	}
	
	public String addAdresse(Adresse adress)
	{
		String res = null;
		try {
			super.doTransaction();
			super.getSession().save(adress);
			super.endTransaction();
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
		super.doTransaction();
		adresse = (Adresse) super.getSession().get(Adresse.class, id);
		super.endTransaction();
		return adresse;
	}
	
	public String removeAdresse(Adresse adress)
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
