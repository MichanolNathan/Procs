package domain;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import com.sun.rowset.CachedRowSetImpl;

import domain.DAO;
import domain.Entreprise;

public class EntrepriseDAO extends DAO
{
	
	public EntrepriseDAO()
	{
		super();
	}
	
	public String addEntreprise(Entreprise entreprise)
	{
		String res = null;
		try {
			super.doTransaction();
			super.getSession().save(entreprise);
			super.doTransaction();
			res = "entreprise ajoutée";
		}
		catch (Exception e) {
			e.printStackTrace();;
		}

		return res;
	}
	
	public String editEntreprise(Entreprise entreprise)
	{
		String res = null;
		try 
		{
			Query query = super.getSession().createQuery("UPDATE entreprise SET numsiret:paramSiret, name:nameParam WHERE id:idParam;");
			query.setString("paramSiret", entreprise.getNumSiret());
			query.setString("nameParam", entreprise.getName());
			query.setInteger("idParam", entreprise.getId());
			res = "Update réussi";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
	public Entreprise getEntreprise(int id) 
	{
    	return (Entreprise) super.getSession().get(Entreprise.class, id);
	}

	public List<Entreprise> getAllEntreprises() 
	{
		List  results = super.getSession().createQuery("SELECT * FROM entreprise;").list();
    	List <Entreprise> entreprises = new ArrayList<Entreprise>();
    	for (Iterator iter = results.iterator();iter.hasNext();) {
    		Entreprise entr = (Entreprise) iter.next();
    		entreprises.add(entr);
    	}
    	super.endTransaction();
    	return entreprises;
	}

}
