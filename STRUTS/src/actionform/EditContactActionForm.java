package actionform;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import domain.Adresse;
import domain.Contact;
import domain.Entreprise;
import domain.EntrepriseDAO;
import domain.Group;
import domain.GroupDAO;
import domain.PhoneNumber;
import service.GroupService;

public class EditContactActionForm extends ActionForm
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* Contact */
	private String id = null;
	private String lastName = null;
	private String firstName = null;
	private String email = null;
	
	/* PhoneNumber */
	private String[] phoneKind = null;
	private String[] phoneNumber = null;
	private String[] phoneId = null;
	
	/* Entreprise */
	private String entreprise = null;
	private List entreprises; 
	
	/* Adress */
	private String street = null;
	private String city = null;
	private String zip = null;
	private String country = null;
	
	/* Group */
	private List<Group> listGroups;
	private String[] groups;
	
	private String[] idPhone = null;
	private String idAdress = null;
	
	private GroupService groupeService;

	public EditContactActionForm() 
	{
		super();
		EntrepriseDAO entrepriseDAO = new EntrepriseDAO();
		this.entreprises = entrepriseDAO.getAllEntreprises();
		
		GroupDAO lGroupDAO = new GroupDAO();
		this.listGroups = lGroupDAO.getAllGroups();
	}
	
	public String getIdAdress() {
		return idAdress;
	}

	public void setIdAdress(String idAdress) {
		this.idAdress = idAdress;
	}

	public String[] getIdPhone() {
		return idPhone;
	}

	public void setIdPhone(String[] idPhone) {
		this.idPhone = idPhone;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String[] getGroups() {
		return groups;
	}

	public void setGroups(String[] groups) {
		this.groups = groups;
	}

	public String[] getPhoneKind() {
		return phoneKind;
	}
	
	public void setPhoneKind(String[] phoneKind) {
		this.phoneKind = phoneKind;
	}

	public String[] getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String[] phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEntreprise() {
		return entreprise;
	}
	
	public void setEntreprise(String entreprise) 
	{
		this.entreprise = entreprise;
	}

	public void setName(String entreprise) {
		this.entreprise = entreprise;
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

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLastName() 
	{
		return lastName;
	}
	
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getEmail() 
	{
		return email;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
		/* Contact */
		if (this.lastName == null || this.lastName.length() < 1 || this.lastName.length() > 45)
		{
			errors.add("lastName", new ActionMessage("form.contact.lastName.error"));
		}
		if (this.firstName == null || this.firstName.length() < 1 || this.firstName.length() > 45)
		{
			errors.add("firstName", new ActionMessage("form.contact.firstName.error"));
		}
		if (this.email == null || this.email.length() < 5 || this.email.length() > 75)
		{
			errors.add("email", new ActionMessage("form.contact.email.error"));
		}		
		/* Adress */
		if ((this.street != "" && this.street.length() < 1) || this.street.length() > 100)
		{
			errors.add("street", new ActionMessage("form.contact.street.error.size"));
		}
		if ((this.city != "" && this.city.length() < 1) || this.city.length() > 50)
		{
			errors.add("city", new ActionMessage("form.contact.city.error.size"));
		}
		if ((this.zip != "" && this.zip.length() < 5) || this.zip.length() > 10)
		{
			errors.add("zip", new ActionMessage("form.contact.zip.error.size"));
		}
		if ((this.country != "" && this.country.length() < 3) || this.country.length() > 50)
		{
			errors.add("country", new ActionMessage("form.contact.country.error.size"));
		}
		
		if(!errors.isEmpty()) 
		{
			Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>();
			for(int i=0;i<this.phoneKind.length;i++) {
				phoneNumbers.add(new PhoneNumber(this.phoneKind[i],this.phoneNumber[i]));
			}
			Adresse adress = new Adresse(Integer.parseInt(this.idAdress), this.street, this.city, this.zip, this.country);
			Set<Group> contactGroup = new HashSet<Group>();
			for (String idGroup : this.groups)
			{
				contactGroup.add(new Group(Integer.parseInt(idGroup)));
			}
			Contact contact = new Contact(Integer.parseInt(this.id), this.lastName, this.firstName, this.email, adress, phoneNumbers, contactGroup);
        }
		return errors;
	}
}
