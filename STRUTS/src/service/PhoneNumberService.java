package service;

import domain.PhoneNumber;
import domain.PhoneNumberDAO;

public class PhoneNumberService {
	
	public PhoneNumberService() {};
	
	PhoneNumberDAO phoneDao = new PhoneNumberDAO();
	
	public String addPhoneNumber (PhoneNumber phoneNumber) {
		return this.phoneDao.addPhoneNumber(phoneNumber);
	}
	
	/*public String editPhoneNumber (PhoneNumber phoneNumber) {
		return this.phoneDao.editPhoneNumber(phoneNumber);
	}*/
	
	public PhoneNumber getPhoneNumber(int id) {
		return this.phoneDao.getPhoneNumber(id);
	}
	
	public String removePhoneNumber (PhoneNumber phoneNumber) {
		return this.phoneDao.removePhoneNumber(phoneNumber);
	}

}
