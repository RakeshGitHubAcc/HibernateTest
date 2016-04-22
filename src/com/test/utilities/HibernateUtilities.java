package com.test.utilities;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilities {
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	static {
		try {
			/* Hibernate 4.3.5
			 * Configuration configuration = new Configuration().configure();
			serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);*/
			// Hibernate : 5 ; configures settings from hibernate.cfg.xml
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException hie) {
			System.out.println("***Exception in creating Session factory****"
					+ hie.getStackTrace());
		}
	}
	//create public class that returns object
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
