package domain;

import java.util.ArrayList;
import java.util.List;

public class Adresse {

	public int idAdress;
	public String street;
	public String city;
	public String zip;
	public String country;
	private int version;
	
	
	public Adresse(int id)
	{
		this.idAdress = id;
		this.street = "NULL";
		this.city = "NULL";
		this.zip = "NULL";
		this.country = "NULL";
	}
	
	public Adresse(int id, String street, String city, String zip, String country)
	{
		this.idAdress = id;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}
	
	public Adresse(String street, String city, String zip, String country)
	{
		this.idAdress = -1;
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.country = country;
	}
	
	public int getIdAdress() {
		return idAdress;
	}
	
	public void setIdAdress(int id) {
		this.idAdress = id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getZip() {
		return zip;
	}
	
	public int getVersion () {
		return this.version;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
