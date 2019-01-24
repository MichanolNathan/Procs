package actionform;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modele.Adresse;
import modele.Contact;
import modele.Entreprise;
import modele.Group;
import modele.PhoneNumber;
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
	
	/* Adress */
	private String street = null;
	private String city = null;
	private String zip = null;
	private String country = null;
	
	/* Entreprise */
	private String name = null;
	private String numSiret = null;
	
	/* Group */
	private List<Group> listGroups;
	private String[] groups;
	
	private String[] idPhone = null;
	private String idAdress = null;
	
	private GroupService groupService;

	public EditContactActionForm() 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		groupService = (GroupService) context.getBean("groupService");
		this.listGroups = groupService.getAllGroups();
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
	
	public String getNumSiret() {
		return numSiret;
	}

	public void setNumSiret(String numSiret) {
		this.numSiret = numSiret;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		
		/* Entreprise */
		/*if (this.numSiret != null && this.numSiret != null) {
			if (this.numSiret != "" && this.name != "" || this.numSiret.length() != 14) {
				errors.add("numSiret", new ActionMessage("form.contact.numSiret.error.size"));
			}
			if (this.name != "" && this.numSiret != "" || (this.name.length() < 1 || this.name.length() > 45)) {
				errors.add("name", new ActionMessage("form.contact.companyName.error.size"));
			}
		}*/
		
		if(!errors.isEmpty()) 
		{
			Set<PhoneNumber> phoneNumbers = new HashSet<PhoneNumber>();
			for(int i=0;i<this.phoneKind.length;i++) {
				System.out.println("Contenu de phoneNumbers : " + phoneNumbers.toString());
				phoneNumbers.add(new PhoneNumber(this.phoneKind[i],this.phoneNumber[i]));
			}
			
			Set<Group> contactGroup = new HashSet<Group>();
			if (groups != null) {
				for (String idGroup : this.groups)
					{
						contactGroup.add(new Group(Integer.parseInt(idGroup)));
					}
			}
			
			Adresse adress = new Adresse(Integer.parseInt(this.idAdress), this.street, this.city, this.zip, this.country);
			Contact contact = new Contact(Integer.parseInt(this.id), this.lastName, this.firstName, this.email, adress, phoneNumbers, contactGroup);
			request.setAttribute("listGroups", this.listGroups);
			//Si les champs name et numSiret sont remplis alors il s'agit d'une entreprise
			request.setAttribute("phoneNumbers", phoneNumbers);
			if (this.name != null && this.numSiret != null) {
				Entreprise entreprise = new Entreprise(contact, numSiret, name);
				request.setAttribute("contact", entreprise);
			} else {
				//Autrement un contact classique est créé
				request.setAttribute("contact", contact);
			}
        }
		return errors;
	}
}
