package com.supplyplatform.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * DAO∏∏¿‡
 * @author bxy
 *
 */
public class HiberateDAO {

	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
