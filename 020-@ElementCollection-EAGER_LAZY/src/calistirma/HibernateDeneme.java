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
		personel1.setPersonelSoyadi("Germiyano�lu");
		personel1.setPersonelkayitTarihi(new Date());

		Adres adres1 = new Adres();
		adres1.setSehir("Ankara");
		adres1.setSemt("�ankaya");
		adres1.setMahalle("Ayranci");
		adres1.setCadde("Cadde 1");
		adres1.setKat("Kat 1");
		adres1.setDaireNo("Daire 1");
		adres1.setKapiNo("Kap� 1");
		adres1.setPostaKodu("Posta Kodu 1");
		
		personel1.getAdresListesi().add(adres1);
		
		Adres adres2 = new Adres();
		adres2.setSehir("Ankara");
		adres2.setSemt("Ke�i�ren");
		adres2.setMahalle("Uzunyol");
		adres2.setCadde("Cadde 2");
		adres2.setKat("Kat 2");
		adres2.setDaireNo("Daire 2");
		adres2.setKapiNo("Kap� 2");
		adres2.setPostaKodu("Posta Kodu 2");
		
		personel1.getAdresListesi().add(adres2);
		
		///////////////////////////////////////////////////
		
		
		/////////////////////////////////////////////////
		Personel personel2 = new Personel();
		personel2.setPersonelAdi("Tuvana");
		personel2.setPersonelSoyadi("T�rkay");
		personel2.setPersonelkayitTarihi(new Date());
		
		Adres adres3 = new Adres();
		adres3.setSehir("�stanbul");
		adres3.setSemt("Kad�koy");
		adres3.setMahalle("Moda");
		adres3.setCadde("Cadde 2");
		adres3.setKat("Kat 2");
		adres3.setDaireNo("Daire 2");
		adres3.setKapiNo("Kap� 2");
		adres3.setPostaKodu("Posta Kodu 2");
		
		personel2.getAdresListesi().add(adres3);
		
		Adres adres4 = new Adres();
		adres4.setSehir("�stanbul");
		adres4.setSemt("Etiler");
		adres4.setMahalle("A�a�� Yol");
		adres4.setCadde("Nispetiye");
		adres4.setKat("Kat 1");
		adres4.setDaireNo("Daire 1");
		adres4.setKapiNo("Kap� 1");
		adres4.setPostaKodu("Posta Kodu 1");
		
		personel2.getAdresListesi().add(adres4);
		
		
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
		session.close();
		
		//
		
		
	}

}
