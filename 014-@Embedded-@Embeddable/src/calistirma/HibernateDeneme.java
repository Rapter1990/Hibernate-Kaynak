package calistirma;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import deneme.Adres;
import deneme.Personel;

public class HibernateDeneme {

	public static void main(String[] args) {
		
		/////////////////////////////////////////////////
		Personel personel1 = new Personel();
		personel1.setPersonelAdi("Noyan");
		personel1.setPersonelSoyadi("Germiyanoðlu");
		personel1.setPersonelkayitTarihi(new Date());

		Adres personelAdres1 = new Adres();
		personelAdres1.setSehir("Ankara");
		personelAdres1.setSemt("Çankaya");
		personelAdres1.setMahalle("Ayranci");
		personelAdres1.setCadde("Cadde 1");
		personelAdres1.setKat("Kat 1");
		personelAdres1.setDaireNo("Daire 1");
		personelAdres1.setKapiNo("Kapý 1");
		personelAdres1.setPostaKodu("Posta Kodu 1");
		
		personel1.setAdres(personelAdres1);
		///////////////////////////////////////////////////
		
		
		/////////////////////////////////////////////////
		Personel personel2 = new Personel();
		personel2.setPersonelAdi("Tuvana");
		personel2.setPersonelSoyadi("Türkay");
		personel2.setPersonelkayitTarihi(new Date());
		
		Adres personelAdres2 = new Adres();
		personelAdres2.setSehir("Ýstanbul");
		personelAdres2.setSemt("Kadýkoy");
		personelAdres2.setMahalle("Moda");
		personelAdres2.setCadde("Cadde 2");
		personelAdres2.setKat("Kat 2");
		personelAdres2.setDaireNo("Daire 2");
		personelAdres2.setKapiNo("Kapý 2");
		personelAdres2.setPostaKodu("Posta Kodu 2");
		
		personel2.setAdres(personelAdres2);
		///////////////////////////////////////////////////
		
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
		Personel personel = new Personel();
		//session = sessionFactory.openSession();
		session.beginTransaction();
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////
		personel = (Personel) session.get(Personel.class, 1);
		
		System.out.println("ID : " + personel.getPersonelId() +
				         "\nADI VE SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi() +
				         "\nKAYIT TARÝHÝ : "  + personel.getPersonelkayitTarihi() + 
				         "\nÞEHÝR : " + personel.getAdres().getSehir() + 
				         "\nSEMT : " + personel.getAdres().getSemt() +
				         "\nMAHALLE : " + personel.getAdres().getMahalle() +
				         "\nCADDE : " + personel.getAdres().getCadde() + 
				         "\nKAT : " + personel.getAdres().getKat() +
				         "\nDAÝRE NO : " + personel.getAdres().getDaireNo() +
				         "\nKAPI NO :" + personel.getAdres().getKapiNo() + 
				         "\nPOSTA NO :" + personel.getAdres().getPostaKodu());
		///////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println();
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////
		personel = (Personel) session.get(Personel.class, 2);
		
		System.out.println("ID : " + personel.getPersonelId() +
				         "\nADI VE SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi() +
				         "\nKAYIT TARÝHÝ : "  + personel.getPersonelkayitTarihi() + 
				         "\nÞEHÝR : " + personel.getAdres().getSehir() + 
				         "\nSEMT : " + personel.getAdres().getSemt() +
				         "\nMAHALLE : " + personel.getAdres().getMahalle() +
				         "\nCADDE : " + personel.getAdres().getCadde() + 
				         "\nKAT : " + personel.getAdres().getKat() +
				         "\nDAÝRE NO : " + personel.getAdres().getDaireNo() +
				         "\nKAPI NO :" + personel.getAdres().getKapiNo() + 
				         "\nPOSTA NO :" + personel.getAdres().getPostaKodu());
		///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		session.getTransaction().commit();
		session.close();
		
	}

}
