package domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

	public class Contact implements Serializable {
		
		private static final long serialVersionUID = 1L;
		public int id;
		public String lastName;
		public String firstName;
		public String email;
		public Adresse adresse;
		public Set<Group> groups;
		public Set<PhoneNumber> phoneNumbers;
		private int version;
		
		public Contact () {};
		
		public Contact(int id, String lastName, String firstName, String email, Adresse adresse, Set<PhoneNumber> phoneNumbers,Set<Group> groups) 
		{
			this.id = id;
			this.lastName = lastName;
			this.firstName = firstName;
			this.email = email;
			this.adresse = adresse;
			this.phoneNumbers = phoneNumbers;
			this.groups = groups;
		}
		
		public Contact(String lastName, String firstName, String email, Adresse adresse, Set<PhoneNumber> phoneNumbers,Set<Group> groups) 
		{
			this.lastName = lastName;
			this.firstName = firstName;
			this.email = email;
			this.adresse = adresse;
			this.phoneNumbers = phoneNumbers;
			this.groups = groups;
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
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public Adresse getAdresse() {
			return adresse;
		}

		public void setAdresse(Adresse adress) {
			this.adresse = adress;
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
		
		public int getVersion () {
			return this.version;
		}
		
		public void setVersion (int version) {
			this.version = version;
		}
		
		@Override
		public String toString() {
			return "Contact [id=" + this.id + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email + "]";
		}
}
