package service;

import domain.Adresse;
import domain.ContactDAO;
import domain.AdressDAO;

public class AdresseService {
	
	private AdressDAO adressDAO = new AdressDAO();
	
	public AdresseService() {};
	
	public void setAdressDAO(AdressDAO adressDAO) {
		this.adressDAO = adressDAO;
	}
	public String addAdress(Adresse adresse) {
		return this.adressDAO.addAdresse(adresse);
	}
	
	public Adresse getAdresse (int id) {
		return this.adressDAO.getAdresse(id);
	}
	
	public String removeAdresse (Adresse adresse) {
		return this.adressDAO.removeAdresse(adresse);
	}
}
