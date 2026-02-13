package com.keshav.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.keshav.configuration.HibernateConfig;
import com.keshav.entity.Employee;

public class Main {

	public static void main(String[] args) {
		Employee e = new  Employee( "Kunal", "male", 22200);
		
		SessionFactory sf = HibernateConfig.getSessionFactory();
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(e);
		tx.commit();
	}

}
