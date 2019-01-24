package servletaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import modele.Contact;
import modele.Group;
import service.ContactService;
import service.GroupService;

public class GetDummyDataAction extends Action {
	
	public ActionForward execute (final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		HttpSession session = pRequest.getSession();
		if (session.getAttribute("user")==null) {
			return pMapping.findForward("connection");
		}
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		final GroupService groupService = (GroupService) context.getBean("groupService");
		final ContactService contactService = (ContactService) context.getBean("contactService");
        
		//Création des groupes à partir des bean
		Group work = (Group) context.getBean("FamilyGroup");
        Group family = (Group) context.getBean("WorkGroup");
        Group friends = (Group) context.getBean("FriendsGroup");
        Group perso = (Group) context.getBean("Perso");

        //ajout des groupes        
        groupService.addGroup(work);
        groupService.addGroup(family);
        groupService.addGroup(friends);
        groupService.addGroup(perso);

        //Création des contacts à partir des bean
        Contact nathan = (Contact) context.getBean("addContactDummy1");
        Contact alexandre = (Contact) context.getBean("addContactDummy2");
        Contact ludwig = (Contact) context.getBean("addContactDummy3");
        Contact boiteFondateur = (Contact) context.getBean("addEntrepriseDummy");

        //Ajout des contacts à la BD
        contactService.addContact(nathan);
        contactService.addContact(alexandre);
        contactService.addContact(ludwig);
        contactService.addContact(boiteFondateur);

        
        List<Group> groups = groupService.getAllGroups();
        List<Contact> contacts = contactService.getAllContacts();
       
		pRequest.setAttribute("contacts", contacts);
        pRequest.setAttribute("listGroups", groups);
		return pMapping.findForward("listContacts");
	}

}
