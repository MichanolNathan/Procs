package actionform;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import modele.Group;
import service.GroupService;

public class AddContactActionForm extends ActionForm
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* Contact */
	private String lastName = null;
	private String firstName = null;
	private String email = null;
	
	/* PhoneNumber */
	private String[] phoneKind = null;
	private String[] phoneNumber = null;
	private String[] idPhone = null;
	
	/* Adress */
	private String street = null;
	private String city = null;
	private String zip = null;
	private String country = null;
	
	private String phoneKind1 = null;
	private String phoneNumber1 = null;
	
	private String phoneKind2 = null;
	private String phoneNumber2 = null;
	
	private String phoneKind3 = null;
	private String phoneNumber3 = null;
	
	/* Group */
	private List<Group> listGroups;
	private String[] groups;
	private GroupService groupService;
	
	/* Entreprise */
	private String name = null;
	private String numSiret = null;
	
	public AddContactActionForm() 
	{
		super();
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		groupService = (GroupService) context.getBean("groupService");
		this.listGroups = groupService.getAllGroups();
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

	public String getPhoneKind1() {
		return phoneKind1;
	}

	public void setPhoneKind1(String phoneKind1) {
		this.phoneKind1 = phoneKind1;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneKind2() {
		return phoneKind2;
	}

	public void setPhoneKind2(String phoneKind2) {
		this.phoneKind2 = phoneKind2;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getPhoneKind3() {
		return phoneKind3;
	}

	public void setPhoneKind3(String phoneKind3) {
		this.phoneKind3 = phoneKind3;
	}

	public String getPhoneNumber3() {
		return phoneNumber3;
	}

	public void setPhoneNumber3(String phoneNumber3) {
		this.phoneNumber3 = phoneNumber3;
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
	
		
		/* PhoneNumber */
		if ((this.phoneKind1 != "" && this.phoneKind1.length() < 3) || this.phoneKind1.length() > 10)
		{
			errors.add("phoneKind1", new ActionMessage("form.contact.phoneKind.error.size"));
		}
		if ((this.phoneNumber1 != "" && this.phoneNumber1.length() < 10) || this.phoneNumber1.length() > 15)
		{
			errors.add("phoneNumber1", new ActionMessage("form.contact.phoneNumber.error.size"));
		}
		
		if ((this.phoneKind2 != "" && this.phoneKind2.length() < 3) || this.phoneKind2.length() > 10)
		{
			errors.add("phoneKind2", new ActionMessage("form.contact.phoneKind.error.size"));
		}
		if ((this.phoneNumber2 != "" && this.phoneNumber2.length() < 10) || this.phoneNumber2.length() > 15)
		{
			errors.add("phoneNumber2", new ActionMessage("form.contact.phoneNumber.error.size"));
		}
		
		if ((this.phoneKind3 != "" && this.phoneKind3.length() < 3) || this.phoneKind3.length() > 10)
		{
			errors.add("phoneKind3", new ActionMessage("form.contact.phoneKind.error.size"));
		}
		if ((this.phoneNumber3 != "" && this.phoneNumber3.length() < 10) || this.phoneNumber3.length() > 15)
		{
			errors.add("phoneNumber3", new ActionMessage("form.contact.phoneNumber.error.size"));
		}
		
		if(!errors.isEmpty()) 
		{
            request.setAttribute("listGroups", this.listGroups);
        }
		
		/* Entreprise */
		if (this.numSiret != "" && this.name != "" && this.numSiret.length() != 14) {
			errors.add("numSiret", new ActionMessage("form.contact.numSiret.error.size"));
		}
		if (this.name != "" && this.numSiret != "" && (this.name.length() < 1 || this.name.length() > 45)) {
			errors.add("companyName", new ActionMessage("form.contact.companyName.error.size"));
		}
		
		if (!errors.isEmpty()) {
			request.setAttribute("listGroups", this.listGroups);
		}
		
		return errors;
	}
}
