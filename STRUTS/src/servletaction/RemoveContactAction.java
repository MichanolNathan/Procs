package servletaction;

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
import service.ContactService;

public class RemoveContactAction extends Action 
{
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse)
	{		
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
   
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ContactService contactService = (ContactService) context.getBean("contactService");
		

		int id = -1;
		try
		{
			id = Integer.parseInt(pRequest.getParameter("id"));
			Contact contact = contactService.getContact(id);
			contactService.removeContact(contact);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return pMapping.findForward("end");
	}
}
