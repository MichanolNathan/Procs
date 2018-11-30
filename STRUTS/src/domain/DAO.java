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
import org.hibernate.Transaction;

import com.sun.rowset.CachedRowSetImpl;

import util.HibernateUtil;

public class DAO {
	
	private Session session;
	private Transaction transac;
	

	DAO() {
		super();
		this.session = HibernateUtil.getSessionFactory().getCurrentSession();
		this.transac = null;
	}
	
	public void doTransaction() {
		try {
		this.transac = this.session.beginTransaction();
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
	
	public Session getSession() {
		return this.session;
	}
}
