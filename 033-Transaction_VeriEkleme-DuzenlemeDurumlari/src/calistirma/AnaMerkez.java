package calistirma;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import deneme.Personel;
import util.HibernateUtil;

public class AnaMerkez {
	
public static void main(String[] args) {
		
		/////////////////////////////////////////////////
			
		Personel personel = new Personel();
		personel.setPersonelAdi("Noyan");
		personel.setPersonelSoyadi("Germiyano�lu");
		
		///////////////////////////////////////////////////
		
		
		// Hibernate
		//SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();	
		
		//Session session = sessionFactory.openSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		try {
			
			personel.setPersonelAdi("Salih");
			personel.setPersonelSoyadi("Nezir");
			session.save(personel); // INSERT
			
			// gizli update var.  // UPDATE
			/*
			 * personel.setPersonelAdi("Nida");
			 * personel.setPersonelSoyadi("�etinkaya");
			 * */
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.getTransaction().commit();
		session.close();
		
		//
		
		System.out.println("Sonu� : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi());
		
		
	}

}
