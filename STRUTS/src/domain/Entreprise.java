package domain;

import java.util.List;
import java.util.Set;

public class Entreprise extends Contact
{
	public String numSiret;
	public String name;
	
	public Entreprise(int id,String lastName,String firstName,String email,Adresse address, Set<PhoneNumber> phoneNumbers,List<Group> groups,String numsiret,String name)
	{
		//super (id,lastName,firstName,email,address,phoneNumbers,groups);
		this.numSiret = numsiret;
		this.name = name;
	}
	
	public Entreprise(String lastName,String firstName,String email,Adresse address, Set<PhoneNumber> phoneNumbers,List<Group> groups,String numsiret,String name)
	{
		//super (lastName,firstName,email,address,phoneNumbers,groups);
		this.numSiret = numsiret;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(String numsiret) {
		this.numSiret = numsiret;
	}
	
}
