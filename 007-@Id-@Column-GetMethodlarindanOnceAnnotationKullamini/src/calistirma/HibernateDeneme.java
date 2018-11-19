package calistirma;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import deneme.Personel;

public class HibernateDeneme {

	public static void main(String[] args) {

		Personel personel = new Personel();

		personel.setPersonelId(3);
		personel.setPersonelAdi("Tuðba Melis");
		personel.setPersonelSoyadi("Türk");

		// Hibernate
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try {
			session.save(personel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.getTransaction().commit();

	}

}
