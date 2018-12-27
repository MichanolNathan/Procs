package domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.sun.rowset.CachedRowSetImpl;

import domain.Group;

public class GroupDAO extends DAO
{

	public GroupDAO() 
	{
        super();
    }
	
	public List<Group> getAllGroups()
    {
		List <Group> groupList = new ArrayList<Group>();
		StringBuffer request = new StringBuffer();
		request.append("select group from Group group");
    	super.doTransaction();
		for (final Object o : super.getSession().createCriteria(Group.class).list()) {
			groupList.add((Group)(o));
		}
    	super.endTransaction();
    	return groupList;
    }
	
	public Group getGroup(int id) 
	{
		return (Group) super.getSession().get(Group.class, id);
	}
	
	public String addGroup(Group group)
	{
		String res = null;
		try {
			super.doTransaction();
			super.getSession().save(group);
			super.doTransaction();
			res = "Groupe added to the dataBase";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
