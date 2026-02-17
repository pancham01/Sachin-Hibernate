package com.keshav.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.keshav.configuration.HibernateConfig;
import com.keshav.entity.Address;
import com.keshav.entity.Employee;

public class Main {

	public static void main(String[] args) {
		Address add1 = new Address();
		add1.setCity("Noida");
		add1.setState("UP");

		Employee e = new Employee();
		e.setName("Vinay");
		e.setGender("Male");
		e.setSalary(444444);
//		e.setAddress(add1);

		SessionFactory sf = HibernateConfig.getSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(e);
		session.persist(add1);
		tx.commit();

		Employee employee = session.find(Employee.class, 1);

		System.out.println(employee);

	}

}
