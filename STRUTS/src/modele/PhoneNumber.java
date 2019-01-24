package modele;

public class PhoneNumber 
{

	public int id;
	public String phoneKind;
	public String phoneNumber;
	public Contact contact;
	private int version;
	
	public PhoneNumber(String phoneKind, String phoneNumber)
	{
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}
	
	public PhoneNumber(String phoneKind,String phoneNumber,Contact contact) {
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
		this.contact = contact;
	}
	public PhoneNumber() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneKind() {
		return phoneKind;
	}

	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public int getVersion () {
		return this.version;
	}
	
	public void setVersion (int version) {
		this.version = version;
	}
	
	public Contact getContact() {
		return this.contact;
	}
	
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
}
