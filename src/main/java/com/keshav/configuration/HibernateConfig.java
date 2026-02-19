package com.keshav.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

public class HibernateConfig {
	
	
	public static SessionFactory getSessionFactory()
	{
		
		Properties prop = new Properties();
		prop.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
		prop.put(Environment.JAKARTA_JDBC_URL,"jdbc:mysql://localhost:3306/testdb");
		prop.put(Environment.JAKARTA_JDBC_USER,"root");
		prop.put(Environment.JAKARTA_JDBC_PASSWORD,"root");
		prop.put(Environment.HBM2DDL_AUTO,"create");
		prop.put(Environment.SHOW_SQL,"true");
		prop.put(Environment.FORMAT_SQL,"true");
		
		
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(prop).build();
//		Metadata metaData = new MetadataSources(ssr).
//				addAnnotatedClass(com.keshav.entity.Employee.class).getMetadataBuilder().build();
//		SessionFactory sf = metaData.buildSessionFactory();

		return  new MetadataSources(new StandardServiceRegistryBuilder().applySettings(prop).build()).addAnnotatedClasses(com.keshav.entity.Employee.class, com.keshav.entity.Address.class).getMetadataBuilder().build().buildSessionFactory();
	}

}
