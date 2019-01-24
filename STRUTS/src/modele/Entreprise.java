package modele;

import java.util.Set;

public class Entreprise extends Contact {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numSiret;
	private String name;
	
	public Entreprise () {}
	
	public Entreprise(Contact contact,String numSiret,String name) {
		super(contact.id,contact.lastName,contact.firstName,contact.email,contact.adresse,contact.phoneNumbers,contact.groups);
		this.numSiret = numSiret;
		this.name = name;
	}
	
	public Entreprise (String lastName,String firstName,String email,Adresse adresse,Set<PhoneNumber> phoneNumbers,Set<Group> groups,String numSiret,String name) {
		super(lastName,firstName,email,adresse,phoneNumbers,groups);
		this.numSiret = numSiret;
		this.name = name;
	}
	
	public Entreprise (int id,String lastName,String firstName,String email,Adresse adresse,Set<PhoneNumber> phoneNumbers,Set<Group> groups,String numSiret,String name) {
		super(id,lastName,firstName,email,adresse,phoneNumbers,groups);
		this.numSiret = numSiret;
		this.name = name;
	}
	
	public String getNumSiret() {
		return this.numSiret;
	}

	public void setNumSiret (String numSiret) {
		this.numSiret = numSiret;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Entreprise [numSiret=" + this.numSiret + ", name=" + this.name + "]";
	}
}
