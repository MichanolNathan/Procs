package servletaction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionform.AddContactActionForm;
import domain.Adress;
import domain.AdressDAO;
import domain.Contact;
import domain.ContactDAO;
import service.*;
import domain.Entreprise;
import domain.EntrepriseDAO;
import domain.Group;
import domain.GroupDAO;
import domain.PhoneNumber;
import domain.PhoneNumberDAO;

public class AddContactAction extends Action 
{
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse)
	{
		
		PhoneNumberService phoneService = new PhoneNumberService();
		AdresseService adresseService = new AdresseService();
		EntrepriseService entrepriseService = new EntrepriseService();
		HttpSession session = pRequest.getSession();
		
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
        
		final AddContactActionForm lForm = (AddContactActionForm) pForm;
		/* Contact */
		final String firstName = lForm.getFirstName();
		final String lastName = lForm.getLastName();
		final String email = lForm.getEmail();
		
		/* PhoneNumber */
		final String phoneKind = lForm.getPhoneKind();
		final String phoneNumber = lForm.getPhoneNumber();
		PhoneNumber phone = new PhoneNumber(phoneKind, phoneNumber);

		phoneService.addPhoneNumber(phone);
		//String sIdPhoneNumber = phoneNumberDAO.addPhoneNumber(phone);
		/*int idPhoneNumber = -1;
		try
		{
			idPhoneNumber = Integer.parseInt(sIdPhoneNumber);
		}
		catch(Exception e) {}
		phone.setId(idPhoneNumber);
		*/
		/* Adress */
		final String country = lForm.getCountry();
		final String city = lForm.getCity();
		final String zip = lForm.getZip();
		final String street = lForm.getStreet();
		Adress adress = new Adress(street, city, zip, country);
		adresseService.addAdress(adress);
		//AdressDAO adressDAO = new AdressDAO();
		//String sIdAdress = adressDAO.addAdress(adress);
		/*int idAdress = -1;
		try
		{
			idAdress = Integer.parseInt(sIdAdress);
		}
		catch(Exception e) {}
		adress.setId(idAdress);*/
		
		/* Entreprise */
		final String lentreprise = lForm.getEntreprise();
		int id_entreprise = -1;
		try 
		{
			id_entreprise = Integer.parseInt(lentreprise);
		}
		catch (Exception e) {}
		
		Entreprise entreprise = new Entreprise(id_entreprise);

		/* Group */
		final String[] lgroups = lForm.getGroups();
		List<Group> listContactGroup = new ArrayList<Group>();
		
		if (lgroups != null)
		{
			for (String group : lgroups)
			{
				try 
				{
					System.out.println(group);
					int id_group = Integer.parseInt(group);
					listContactGroup.add(new Group(id_group));
				}
				catch (Exception e) {}
			}
		}
		
		Contact contact = new Contact(firstName, lastName, email, adress, phone, entreprise, listContactGroup);
		return pMapping.findForward("success");
		//final ContactDAO lContactDAO = new ContactDAO();
		//final String idContact = lContactDAO.addContact(contact);
		/*try
		{
			System.out.println(idContact);
			int r = Integer.parseInt(idContact);
			contact.setId(r);
			ContactGroupDAO cgDAO = new ContactGroupDAO();
			cgDAO.removeContactGroup(contact);
			for (Group g : contact.groups)
			{
				System.out.println(g.getId());
				String result = cgDAO.addContactGroup(contact.getId(), g.getId());
				System.out.println(result);
			}
			return pMapping.findForward("success");
		}
		catch (Exception e)
		{
			final EntrepriseDAO lEntrepriseDAO = new EntrepriseDAO();
			List<Entreprise> entreprises = lEntrepriseDAO.getAllEntreprises();
			pRequest.setAttribute("entreprises", entreprises);
			final GroupDAO lGroupDAO = new GroupDAO();
			List<Group> listGroups = lGroupDAO.getAllGroups();
			pRequest.setAttribute("listGroups", listGroups);
			return pMapping.findForward("error");
		}*/
	}
}
