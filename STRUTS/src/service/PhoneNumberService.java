package service;

import domain.PhoneNumberDAO;
import modele.PhoneNumber;

public class PhoneNumberService {
	
	public PhoneNumberService() {};
	
	PhoneNumberDAO phoneDAO;
	
	public void setPhoneDAO(PhoneNumberDAO phoneNumberDAO) {
		this.phoneDAO = phoneNumberDAO;
	}
	
	public String addPhoneNumber (PhoneNumber phoneNumber) {
		return this.phoneDAO.addPhoneNumber(phoneNumber);
	}
	
	/*public String editPhoneNumber (PhoneNumber phoneNumber) {
		return this.phoneDao.editPhoneNumber(phoneNumber);
	}*/
	
	public PhoneNumber getPhoneNumber(int id) {
		return this.phoneDAO.getPhoneNumber(id);
	}
	
	public String removePhoneNumber (PhoneNumber phoneNumber) {
		return this.phoneDAO.removePhoneNumber(phoneNumber);
	}

}
