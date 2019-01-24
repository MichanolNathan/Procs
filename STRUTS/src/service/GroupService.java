package service;

import java.util.List;

import domain.GroupDAO;
import modele.Group;

public class GroupService {
	
	public GroupService() {};
	
	private GroupDAO groupDAO;
	
	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}
	
	public List<Group> getAllGroups () {
		return this.groupDAO.getAllGroups();
	}
	
	public Group getGroup (int id) {
		return this.groupDAO.getGroup(id);
	}
	
	public String addGroup (Group group) {
		return this.groupDAO.addGroup(group);
	}
}
