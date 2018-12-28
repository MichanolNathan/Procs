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

import domain.Contact;
import domain.Group;
import service.ContactService;
import service.GroupService;

public class GetDummyDataAction extends Action {
	
	public ActionForward execute (final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse) {
		HttpSession session = pRequest.getSession();
		if (session.getAttribute("user")==null) {
			return pMapping.findForward("connection");
		}
		ApplicationContext context = new ClassPathXmlApplicationContext("applicatonContext.xml");
		final GroupService groupeService = (GroupService) context.getBean("groupeService");
		final ContactService contactService = (ContactService) context.getBean("contactService");
        
		Group work = (Group) context.getBean("FamilyGroup");
        Group family = (Group) context.getBean("WorkGroup");
        Group friends = (Group) context.getBean("FriendsGroup");
        
        groupeService.addGroup(work);
        groupeService.addGroup(family);
        groupeService.addGroup(friends);
        
        List<Group> groups = groupeService.getAllGroups();
        List<Contact> contacts = contactService.getAllContacts();
       
		pRequest.setAttribute("contacts", contacts);
        pRequest.setAttribute("listGroups", groups);
		return pMapping.findForward("listContacts");
	}

}
