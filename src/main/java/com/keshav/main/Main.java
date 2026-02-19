package com.keshav.main;

import java.util.ArrayList;
import java.util.List;

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
		Address add2 = new Address();
		add2.setCity("GZB");
		add2.setState("UP");
		Address add3 = new Address();
		add3.setCity("Lucknow");
		add3.setState("UP");
		
		List<Address> listOfAdds = new ArrayList<>();
		
		listOfAdds.add(add1);
		listOfAdds.add(add2);
		listOfAdds.add(add3);

		Employee e = new Employee();
		e.setName("Vinay");
		e.setGender("Male");
		e.setSalary(444444);
		e.setAddresses(listOfAdds);
		
		add1.setEmployee(e);
		add2.setEmployee(e);
		add3.setEmployee(e);

		SessionFactory sf = HibernateConfig.getSessionFactory();

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(e);
		tx.commit();

		Employee employee = session.find(Employee.class, 1);
		System.out.println(employee);
		System.out.println(employee.getAddresses());
		
		
		Address address = session.find(Address.class, 1);
		System.out.println(address);
		System.out.println(address.getEmployee());

	}

}
