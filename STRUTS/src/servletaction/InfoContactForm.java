package servletaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import domain.Entreprise;
import domain.EntrepriseDAO;
import domain.Group;
import domain.GroupDAO;
import service.GroupService;

public class InfoContactForm extends Action 
{
	public ActionForward execute(final ActionMapping pMapping, ActionForm pForm, final HttpServletRequest pRequest, final HttpServletResponse pResponse)
	{
		
		HttpSession session = pRequest.getSession();
        if(session.getAttribute("user") == null) {
            return pMapping.findForward("connection");
        }
		GroupService groupeService = new GroupService();
		List<Group> groups = groupeService.getAllGroups();
		pRequest.setAttribute("listGroups", groups);
		
		return pMapping.findForward("addContact");
	}
}
