package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contact {

	public int id;
	public String lastName;
	public String firstName;
	public String email;
	public Adress adress;
	public PhoneNumber phoneNumber;
	public Entreprise entreprise;
	public HashSet<Group> groups;
	String numsiret;
	String name;
	Set<PhoneNumber> phoneNumbers;

	public Contact(int id, String lastName, String firstName, String email, Adress adress, PhoneNumber phoneNumber, Entreprise entreprise, HashSet<Group> groups,HashSet<PhoneNumber> phoneNumbers) 
	{
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.adress = adress;
		this.phoneNumbers = phoneNumbers;
		this.entreprise = entreprise;
		this.groups = groups;
	}
	
	public Contact(String lastName, String firstName, String email, Adress adress, PhoneNumber phoneNumber, Entreprise entreprise, HashSet<Group> groups,HashSet<PhoneNumber> phoneNumbers) 
	{
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.entreprise = entreprise;
		this.groups = groups;
		this.phoneNumbers = phoneNumbers;
	}
	
	public Contact(String lastName, String firstName, String email) {
		super();
		this.id = -1;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
	}
	
	public Contact(int id) {
		super();
		this.id = id;
		this.lastName = "";
		this.firstName = "";
		this.email = "";
	}
	
	public Contact(int id, String lastName, String firstName, String email) 
	{
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
	}
	
	public HashSet<Group> getGroups() {
		return groups;
	}

	public void setGroups(HashSet<Group> groups) {
		this.groups = groups;
	}
	
	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Contact [id=" + this.id + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email + "]";
	}
}
