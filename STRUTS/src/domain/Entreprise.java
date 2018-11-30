package domain;

public class Entreprise 
{
	public int id;
	public String numSiret;
	public String name;
	private int version;
	
	public Entreprise(int id)
	{
		this.id = id;
		this.numSiret = "";
		this.name = "";
	}
	
	public Entreprise(int id, String numsiret, String name)
	{
		this.id = id;
		this.numSiret = numSiret;
		this.name = name;
	}
	
	public Entreprise(String numSiret, String name)
	{
		this.id = -1;
		this.numSiret = numSiret;
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
