package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.sun.rowset.CachedRowSetImpl;
import util.HibernateUtil;

import org.hibernate.stat.Statistics;
import util.HibernateUtil;

public class DAO {
	
	private Transaction transac;
	private SessionFactory sessionFactory;
	

	DAO(SessionFactory sessionFactory) {
		super();
		this.transac = null;
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	public void setSessionFactory (SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void doTransaction() {
		try {
		this.transac = this.getSession().beginTransaction();
		//Cache de second niveau
		Statistics stats=HibernateUtil.getSessionFactory().getStatistics();
		stats.setStatisticsEnabled(true);
		System.out.println("Second Level Hit Count=" + stats.getSecondLevelCacheHitCount());
        System.out.println("Second Level Miss Count="+ stats.getSecondLevelCacheMissCount());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void endTransaction() {
		try {
		this.transac.commit();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		this.transac = null;
	}
	
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}
	
	
}
