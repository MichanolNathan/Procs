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
    		Query query = super.getSession().createQuery(request.toString());
    		for (final Object o : query.list()) {
    			groupList.add((Group)(o));
    		}
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
			super.commitTransaction();
			res = "Groupe added to the dataBase";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public String editGroup(Group group)
	{
		String res = null;
		try 
		{
			super.getSession().update(group);
			super.commitTransaction();
			res = "mise à jour de l'adresse réussie";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return res;
	}
	
}
