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
		personel1.setPersonelSoyadi("Germiyano�lu");
		personel1.setPersonelkayitTarihi(new Date());
		personel1.setPersonelAdresi("T�rkiye Ankara");
		
		Personel personel2 = new Personel();
		personel2.setPersonelAdi("Tu�ba Melis");
		personel2.setPersonelSoyadi("T�rk");
		personel2.setPersonelkayitTarihi(new Date());
		personel2.setPersonelAdresi("T�rkiye �stanbul");

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

		// Seesion bilgileri console yazd�rma
		//personel = null;
		//session = sessionFactory.openSession();
		session.beginTransaction();
		personel = (Personel) session.get(Personel.class, 1);
		
		System.out.println("ID : " + personel.getPersonelId() +
				         "\nADI VE SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi() +
				         "\nKAYIT TAR�H� : "  + personel.getPersonelkayitTarihi() +
				         "\nADRES� : " + personel.getPersonelAdresi());
		
		
		System.out.println("-----------------------------------------------------------------------------------");
		
		personel = (Personel) session.get(Personel.class, 2);
		
		System.out.println("ID : " + personel.getPersonelId() +
				         "\nADI VE SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi() +
				         "\nKAYIT TAR�H� : "  + personel.getPersonelkayitTarihi() +
				         "\nADRES� : " + personel.getPersonelAdresi());
		
		
		session.getTransaction().commit();
		session.close();
		
	}

}
