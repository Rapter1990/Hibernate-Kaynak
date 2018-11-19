package calistirma;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import deneme.Personel;

public class HibernateDeneme {

	public static void main(String[] args) {

		Personel personel = new Personel();

		personel.setPersonelId(1);
		personel.setPersonelAdi("Noyan");
		personel.setPersonelSoyadi("Germiyano�lu");
		personel.setPersonelkayitTarihi(new Date());
		personel.setPersonelAdresi("T�rkiye Ankara");

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
		session.close();
		
		//
		
		// Seesion bilgileri console yazd�rma
		personel = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		personel = (Personel) session.get(Personel.class, 1);
		
		System.out.println("ID : " + personel.getPersonelId() +
				         "\nADI VE SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi() +
				         "\nKAYIT TAR�H� : "  + personel.getPersonelkayitTarihi() +
				         "\nADRES� : " + personel.getPersonelAdresi());
		
		
		session.close();
		

	}

}
