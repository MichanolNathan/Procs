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
	
	public void doTransaction() {
		org.hibernate.Transaction tx = this.session.beginTransaction();
	}
	
	public void commitTransaction() {
		this.transac = this.session.beginTransaction();
		this.transac.commit();
	}
	
	public Session getSession() {
		return this.session;
	}
	
	DAO() {
		super();
		this.session = HibernateUtil.getSessionFactory().getCurrentSession();
		this.transac = null;
	}
}
