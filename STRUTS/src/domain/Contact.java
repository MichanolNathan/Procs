package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contact extends Entreprise {

	public String lastName;
	public String firstName;
	public String email;
	public Adress adress;
	public Set<Group> groups;
	public Set<PhoneNumber> phoneNumbers;

	public Contact(int id, String lastName, String firstName, String email, Adress adress, String numSiret, String companyName, Set<Group> groups, Set<PhoneNumber> phoneNumbers) 
	{
		super(id, numSiret, companyName);
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.adress = adress;
		this.phoneNumbers = phoneNumbers;
		this.groups = groups;
	}
	
	public Contact(String lastName, String firstName, String email, Adress adress, String numSiret, String companyName, Set<Group> groups, Set<PhoneNumber> phoneNumbers) 
	{
		super(numSiret, companyName);
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.adress = adress;
		this.groups = groups;
		this.phoneNumbers = phoneNumbers;
	}
	
	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
	
	public void addGroups(Group group) {
		groups.add(group);
	}
	
	public void removeGroups(Group group) {
		groups.remove(group);
	}
	
	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	public void addPhoneNumber(PhoneNumber phoneNumber) {
		phoneNumbers.add(phoneNumber);
	}
	
	public void removePhoneNumber(PhoneNumber phoneNumber) {
		phoneNumbers.remove(phoneNumber);
	}
	
	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
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
