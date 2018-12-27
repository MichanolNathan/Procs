package service;

import java.util.List;

import domain.Group;
import domain.GroupDAO;

public class GroupService {
	
	public GroupService() {};
	
	private GroupDAO groupDao = new GroupDAO();
	
	public List<Group> getAllGroups () {
		return this.groupDao.getAllGroups();
	}
	
	public Group getGroup (int id) {
		return this.groupDao.getGroup(id);
	}
	
	public String addGroup (Group group) {
		return this.groupDao.addGroup(group);
	}
	
	/*public String editGroup (Group group) {
		return this.groupDao.editGroup(group);
	}*/
}
