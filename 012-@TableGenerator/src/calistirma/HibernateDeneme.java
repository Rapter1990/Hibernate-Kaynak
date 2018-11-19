package calistirma;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import deneme.Personel;

public class HibernateDeneme {

	public static void main(String[] args) {
		
		Personel personel = new Personel();

		Personel personel1 = new Personel();
		personel1.setPersonelAdi("Noyan");
		personel1.setPersonelSoyadi("Germiyanoðlu");
		personel1.setPersonelkayitTarihi(new Date());
		personel1.setPersonelAdresi("Türkiye Ankara");
		
		Personel personel2 = new Personel();
		personel2.setPersonelAdi("Tuðba Melis");
		personel2.setPersonelSoyadi("Türk");
		personel2.setPersonelkayitTarihi(new Date());
		personel2.setPersonelAdresi("Türkiye Ýstanbul");

		// Hibernate
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		try {
			session.save(personel1);
			session.save(personel2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.getTransaction().commit();
		//session.close();
		
		//

		// Seesion bilgileri console yazdýrma
		//personel = null;
		//session = sessionFactory.openSession();
		session.beginTransaction();
		personel = (Personel) session.get(Personel.class, 1);
		
		System.out.println("ID : " + personel.getPersonelId() +
				         "\nADI VE SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi() +
				         "\nKAYIT TARÝHÝ : "  + personel.getPersonelkayitTarihi() +
				         "\nADRESÝ : " + personel.getPersonelAdresi());
		
		
		System.out.println("-----------------------------------------------------------------------------------");
		
		personel = (Personel) session.get(Personel.class, 2);
		
		System.out.println("ID : " + personel.getPersonelId() +
				         "\nADI VE SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi() +
				         "\nKAYIT TARÝHÝ : "  + personel.getPersonelkayitTarihi() +
				         "\nADRESÝ : " + personel.getPersonelAdresi());
		
		
		session.getTransaction().commit();
		session.close();
		
	}

}
