package domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import modele.Group;

public class GroupDAO extends DAO
{

	public GroupDAO(SessionFactory sessionFactory) 
	{
        super(sessionFactory);
    }
	
	public List<Group> getAllGroups()
    {
		List <Group> groupList = new ArrayList<Group>();
		//super.doTransaction();
		groupList = super.getSessionFactory().getCurrentSession().createQuery("from Group group").list();
    	//super.endTransaction();
    	return groupList;
    }
	
	public Group getGroup(int id) 
	{
		Group group = null;
		//super.doTransaction();
		group = (Group) super.getSessionFactory().getCurrentSession().get(Group.class, id);
		//super.endTransaction();
		return group;
	}
	
	public String addGroup(Group group)
	{
		String res = null;
		try {
			//super.doTransaction();
			super.getSessionFactory().getCurrentSession().save(group);
			//super.endTransaction();
			res = "Groupe added to the dataBase";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
