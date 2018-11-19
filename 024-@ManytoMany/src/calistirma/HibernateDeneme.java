package calistirma;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import deneme.Meslek;
import deneme.Personel;

public class HibernateDeneme {

	public static void main(String[] args) {
		
		/////////////////////////////////////////////////
		Personel personel = new Personel();
		personel.setPersonelAdi("Noyan");
		personel.setPersonelSoyadi("Germiyanoðlu");
		personel.setPersonelkayitTarihi(new Date());

		
		Meslek meslek1 = new Meslek();
		meslek1.setMeslekAdi("Organizatör");
		
		Meslek meslek2 = new Meslek();
		meslek2.setMeslekAdi("Ekonomist");
		
		///////////////////////////////////////////////////
		
		personel.getMeslekListesi().add(meslek1);
		personel.getMeslekListesi().add(meslek2);

		///////////////////////////////////////////////////
		
		meslek1.getPersonelListesi().add(personel);
		meslek2.getPersonelListesi().add(personel);

		///////////////////////////////////////////////////
		
		// Hibernate
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try {
			session.save(personel);
			session.save(meslek1);
			session.save(meslek2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.getTransaction().commit();
		session.close();
		
		//
		
		
	}

}
