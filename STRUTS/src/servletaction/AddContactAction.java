package servletaction;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import actionform.AddContactActionForm;
import modele.Adresse;
import modele.Contact;
import modele.Entreprise;
import modele.Group;
import modele.PhoneNumber;
import service.AdresseService;
import service.ContactService;
import service.GroupService;

public class AddContactAction extends Action {
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final ContactService contactService = (ContactService) context.getBean("contactService");
        final AdresseService adressService = (AdresseService) context.getBean("adressService");
        final GroupService groupService = (GroupService) context.getBean("groupService");
        		
		final AddContactActionForm lForm = (AddContactActionForm) pForm;
		
		/* Contact */
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();
		
		final String street = lForm.getStreet();
		final String city = lForm.getCity();
		final String zip = lForm.getZip();
		final String country = lForm.getCountry();
		
		final String phoneKind1 = lForm.getPhoneKind1();
		final String phoneNumber1 = lForm.getPhoneNumber1();
		final String phoneKind2 = lForm.getPhoneKind2();
		final String phoneNumber2 = lForm.getPhoneNumber2();
		final String phoneKind3 = lForm.getPhoneKind3();
		final String phoneNumber3 = lForm.getPhoneNumber3();
		/* Entreprise */
		final String numSiret = lForm.getNumSiret();
		final String name = lForm.getName();
		
		final String[] groups = lForm.getGroups();
		
		Set<Group> contactGroups = new HashSet<>();
		Set<PhoneNumber> phoneNumbers = new HashSet<>();
		
		if (phoneKind1 != "" && phoneNumber1 != "") {
			PhoneNumber phone1 = new PhoneNumber(phoneKind1, phoneNumber1);
			phoneNumbers.add(phone1);
		}
		
		if (phoneKind2 != "" && phoneNumber2 != "") {
			PhoneNumber phone2 = new PhoneNumber(phoneKind2, phoneNumber2);
			phoneNumbers.add(phone2);
		}
		
		if (phoneKind3 != "" && phoneNumber3 != "") {
			PhoneNumber phone3 = new PhoneNumber(phoneKind3, phoneNumber3);
			phoneNumbers.add(phone3);
		}
		
		if (groups != null) {
			for (String group : groups) {
				try {
					int id = Integer.parseInt(group);
					Group g = groupService.getGroup(id);
					contactGroups.add(g);
				} catch (Exception e) { }
			}
		}
		
		Adresse adresse = new Adresse(street, city, zip, country);
		adressService.addAdress(adresse);
		
		Contact contact = new Contact(lastName, firstName, email, adresse, phoneNumbers, contactGroups);
		if (name != "" && numSiret != "") {
			Contact company = new Entreprise(contact, numSiret, name);
			contactService.addContact(company);
		} else {
			contactService.addContact(contact);
		}
		return pMapping.findForward("success");
	}
}