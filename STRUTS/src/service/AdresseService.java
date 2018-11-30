package service;

import domain.Adress;
import domain.AdressDAO;

public class AdresseService {
	
	AdressDAO addresseDao = new AdressDAO();
	
	public String addAdress(Adress adresse) {
		return this.addresseDao.addAdress(adresse);
	}
	
	public String editAdresse (Adress adresse) {
		return this.addresseDao.editAdress(adresse);
	}
	
	public Adress getAdresse (int id) {
		return this.addresseDao.getAdress(id);
	}
	
	public String removeAdresse (Adress adresse) {
		return this.addresseDao.removeAdress(adresse);
	}
}
