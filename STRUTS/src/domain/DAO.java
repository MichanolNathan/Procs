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
	
	private Transaction transac;
	

	DAO() {
		super();
		this.transac = null;
	}
	
	public Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
	
	public void doTransaction() {
		try {
		this.transac = this.getSession().beginTransaction();
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
	
}
