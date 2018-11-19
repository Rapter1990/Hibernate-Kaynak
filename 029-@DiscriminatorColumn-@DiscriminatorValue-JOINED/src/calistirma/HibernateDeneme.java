package calistirma;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import deneme.Meslek;
import deneme.Sektor;
import deneme.Tecrube;

public class HibernateDeneme {

	public static void main(String[] args) {
		
		/////////////////////////////////////////////////
			
		Meslek meslek = new Meslek();
		meslek.setMeslekAdi("Organizatör");
		
		
		///////////////////////////////////////////////////
		
		Sektor sektor = new Sektor();
		sektor.setMeslekAdi("Bilgisayar Mühendisliði");
		sektor.setCalismaAlani("Java");

		///////////////////////////////////////////////////
		
		Tecrube tecrube = new Tecrube();
		tecrube.setMeslekAdi("Proje Yöneticisi");
		tecrube.setDeneyimYili(5);

		///////////////////////////////////////////////////
		
		// Hibernate
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try {
			session.save(meslek);
			session.save(sektor);
			session.save(tecrube);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.getTransaction().commit();
		session.close();
		
		//
		
		
	}

}
