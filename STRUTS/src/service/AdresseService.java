package service;

import domain.Adresse;
import domain.AdressDAO;

public class AdresseService {
	
	AdressDAO addresseDao = new AdressDAO();
	
	public AdresseService() {};
	public String addAdress(Adresse adresse) {
		return this.addresseDao.addAdress(adresse);
	}
	
	/*public String editAdresse (Adresse adresse) {
		return this.addresseDao.editAdress(adresse);
	}*/
	
	public Adresse getAdresse (int id) {
		return this.addresseDao.getAdress(id);
	}
	
	public String removeAdresse (Adresse adresse) {
		return this.addresseDao.removeAdress(adresse);
	}
}
