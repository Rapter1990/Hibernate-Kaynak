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
		personel1.setPersonelSoyadi("Germiyanolu");
		personel1.setPersonelkayitTarihi(new Date());

		Adres personeleVAdres1 = new Adres();
		personeleVAdres1.setSehir("Ankara");
		personeleVAdres1.setSemt("«ankaya");
		personeleVAdres1.setMahalle("Ayranci");
		personeleVAdres1.setCadde("Cadde 1");
		personeleVAdres1.setKat("Kat 1");
		personeleVAdres1.setDaireNo("Daire 1");
		personeleVAdres1.setKapiNo("Kap˝ 1");
		personeleVAdres1.setPostaKodu("Posta Kodu 1");
		
		personel1.setEvAdres(personeleVAdres1);
		
		Adres personel›sAdres1 = new Adres();
		personel›sAdres1.setSehir("Ankara");
		personel›sAdres1.setSemt("KeÁiˆren");
		personel›sAdres1.setMahalle("Uzunyol");
		personel›sAdres1.setCadde("Cadde 2");
		personel›sAdres1.setKat("Kat 2");
		personel›sAdres1.setDaireNo("Daire 2");
		personel›sAdres1.setKapiNo("Kap˝ 2");
		personel›sAdres1.setPostaKodu("Posta Kodu 2");
		
		personel1.setIsAdres(personel›sAdres1);
		
		///////////////////////////////////////////////////
		
		
		/////////////////////////////////////////////////
		Personel personel2 = new Personel();
		personel2.setPersonelAdi("Tuvana");
		personel2.setPersonelSoyadi("T¸rkay");
		personel2.setPersonelkayitTarihi(new Date());
		
		Adres personeleVAdres2 = new Adres();
		personeleVAdres2.setSehir("›stanbul");
		personeleVAdres2.setSemt("Kad˝koy");
		personeleVAdres2.setMahalle("Moda");
		personeleVAdres2.setCadde("Cadde 2");
		personeleVAdres2.setKat("Kat 2");
		personeleVAdres2.setDaireNo("Daire 2");
		personeleVAdres2.setKapiNo("Kap˝ 2");
		personeleVAdres2.setPostaKodu("Posta Kodu 2");
		
		personel2.setEvAdres(personeleVAdres2);
		
		Adres personel›sAdres2 = new Adres();
		personel›sAdres2.setSehir("›stanbul");
		personel›sAdres2.setSemt("Etiler");
		personel›sAdres2.setMahalle("A˛a˝ Yol");
		personel›sAdres2.setCadde("Nispetiye");
		personel›sAdres2.setKat("Kat 1");
		personel›sAdres2.setDaireNo("Daire 1");
		personel›sAdres2.setKapiNo("Kap˝ 1");
		personel›sAdres2.setPostaKodu("Posta Kodu 1");
		
		personel2.setIsAdres(personel›sAdres2);
		
		
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

		// Seesion bilgileri console yazd˝rma
		Personel personel = new Personel();
		//session = sessionFactory.openSession();
		session.beginTransaction();
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////
		personel = (Personel) session.get(Personel.class, 1);
		
		System.out.println("ID : " + personel.getPersonelId() +
		         "\nADI VE SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi() +
		         "\nKAYIT TAR›H› : "  + personel.getPersonelkayitTarihi() + 
		         "\n›ﬁ ﬁEH›R : " + personel.getIsAdres().getSehir() + 
		         "\n›ﬁ SEMT : " + personel.getIsAdres().getSemt() +
		         "\n›ﬁ MAHALLE : " + personel.getIsAdres().getMahalle() +
		         "\n›ﬁ CADDE : " + personel.getIsAdres().getCadde() + 
		         "\n›ﬁ KAT : " + personel.getIsAdres().getKat() +
		         "\n›ﬁ DA›RE NO : " + personel.getIsAdres().getDaireNo() +
		         "\n›ﬁ KAPI NO :" + personel.getIsAdres().getKapiNo() + 
		         "\n›ﬁ POSTA NO :" + personel.getIsAdres().getPostaKodu() + 
		         "\nEV ﬁEH›R : " + personel.getEvAdres().getSehir() + 
		         "\nEV SEMT : " + personel.getEvAdres().getSemt() +
		         "\nEV MAHALLE : " + personel.getEvAdres().getMahalle() +
		         "\nEV CADDE : " + personel.getEvAdres().getCadde() + 
		         "\nEV KAT : " + personel.getEvAdres().getKat() +
		         "\nEV DA›RE NO : " + personel.getEvAdres().getDaireNo() +
		         "\nEV KAPI NO :" + personel.getEvAdres().getKapiNo() + 
		         "\nEV POSTA NO :" + personel.getEvAdres().getPostaKodu());
		///////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println();
		
		///////////////////////////////////////////////////////////////////////////////////////////////////////////
		personel = (Personel) session.get(Personel.class, 2);
		
		System.out.println("ID : " + personel.getPersonelId() +
		         "\nADI VE SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi() +
		         "\nKAYIT TAR›H› : "  + personel.getPersonelkayitTarihi() + 
		         "\n›ﬁ ﬁEH›R : " + personel.getIsAdres().getSehir() + 
		         "\n›ﬁ SEMT : " + personel.getIsAdres().getSemt() +
		         "\n›ﬁ MAHALLE : " + personel.getIsAdres().getMahalle() +
		         "\n›ﬁ CADDE : " + personel.getIsAdres().getCadde() + 
		         "\n›ﬁ KAT : " + personel.getIsAdres().getKat() +
		         "\n›ﬁ DA›RE NO : " + personel.getIsAdres().getDaireNo() +
		         "\n›ﬁ KAPI NO :" + personel.getIsAdres().getKapiNo() + 
		         "\n›ﬁ POSTA NO :" + personel.getIsAdres().getPostaKodu() + 
		         "\nEV ﬁEH›R : " + personel.getEvAdres().getSehir() + 
		         "\nEV SEMT : " + personel.getEvAdres().getSemt() +
		         "\nEV MAHALLE : " + personel.getEvAdres().getMahalle() +
		         "\nEV CADDE : " + personel.getEvAdres().getCadde() + 
		         "\nEV KAT : " + personel.getEvAdres().getKat() +
		         "\nEV DA›RE NO : " + personel.getEvAdres().getDaireNo() +
		         "\nEV KAPI NO :" + personel.getEvAdres().getKapiNo() + 
		         "\nEV POSTA NO :" + personel.getEvAdres().getPostaKodu());
		///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		session.getTransaction().commit();
		session.close();
		
	}

}
