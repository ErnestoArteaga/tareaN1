package com.tarea;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import com.entidades.Person;
import com.entidades.Ranking;
import com.entidades.Skin;

public class Main {
	final static StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	
	static SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

	public static void main(String[] args) {
		
		
		Person per1 = new Person(0,"Ernesto","Arteaga");
		Person per2 = new Person(0,"Rosa","Mariam");
		Person per3 = new Person(0,"Loor","Sanchez");
		
		ingresarperson(per1);
		ingresarperson(per2);
		ingresarperson(per3);
		
		Ranking rac1 = new Ranking(1);
		Ranking rac2 = new Ranking(2);
		
		ingresaRaking(rac1);
		ingresaRaking(rac2);
		
		Skin skil= new Skin("Manualidades");
		Skin ski2= new Skin("Emprendimiento");
		
		ingresarSkin(skil);
		ingresarSkin(ski2);

	}
	
	
	 
		
		static void ingresarperson(Person persona){
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(persona);
			
			session.getTransaction().commit();
			session.close();
		
	
		}	
		static void ingresaRaking(Ranking ranking){
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(ranking);
			
			session.getTransaction().commit();
			session.close();
		}
		
	
		static void ingresarSkin(Skin skil) {
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				session.save(skil);
				session.getTransaction().commit();
				session.close();
		}	
}
