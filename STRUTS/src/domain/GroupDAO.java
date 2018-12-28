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
		super.doTransaction();
		groupList = super.getSession().createQuery("from Group group").list();
    	super.endTransaction();
    	return groupList;
    }
	
	public Group getGroup(int id) 
	{
		Group group = null;
		super.doTransaction();
		group = (Group) super.getSession().get(Group.class, id);
		super.endTransaction();
		return group;
	}
	
	public String addGroup(Group group)
	{
		String res = null;
		try {
			super.doTransaction();
			super.getSession().save(group);
			super.endTransaction();
			res = "Groupe added to the dataBase";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
