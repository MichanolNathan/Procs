package service;

import domain.Adresse;
import domain.AdressDAO;

public class AdresseService {
	
	AdressDAO addresseDao = new AdressDAO();
	
	public AdresseService() {};
	public String addAdress(Adresse adresse) {
		return this.addresseDao.addAdresse(adresse);
	}
	
	/*public String editAdresse (Adresse adresse) {
		return this.addresseDao.editAdress(adresse);
	}*/
	
	public Adresse getAdresse (int id) {
		return this.addresseDao.getAdresse(id);
	}
	
	public String removeAdresse (Adresse adresse) {
		return this.addresseDao.removeAdresse(adresse);
	}
}
