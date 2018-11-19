package yonetim;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.modal.Ogrenci;

public class JPADeneme {

	public static void main(String[] args) {

		EntityManagerFactory emf;
		EntityManager em;

		// Personel Objesi
		Ogrenci ogrenci1 = new Ogrenci();
		ogrenci1.setAdi("Noyan");
		ogrenci1.setSoyadi("Germiyanoðlu");
		ogrenci1.setBolum("Biliþim");
		ogrenci1.setFakulte("Mühendislik");
		ogrenci1.setNo("66666");

		Ogrenci ogrenci2 = new Ogrenci("Hasan", "Bilgisayar", "Mühendislik", "11111", "Mustan");

		Ogrenci ogrenci3 = new Ogrenci("Umit", "Youtuber", "Serbest", "22222", "Yutan");

		// JPA

		emf = Persistence.createEntityManagerFactory("005-@NamedQuery-Parametreli"); // persistence-unit adi
		em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		try {
			et.begin();

			em.persist(ogrenci1);

			kayitekle(em, "Emrecan", "Web-Tasarým", "Meslek Yüksek Okulu", "44444", "Engin");

			em.persist(ogrenci2);

			em.persist(ogrenci3);

			kayitekle(em, "Atilla", "Yazýlým", "Mühendislik", "55555", "Turan");

			et.commit();
			
		} catch (Exception e) {
			et.rollback();
			
		}finally {
			if(em != null ) {
				
				kayitlariYazHepsi(em);
				kayitlariYazSecilen(em,2);
				
				em.close();
				emf.close();
			}
		}
		
		
		

	}

	private static void kayitlariYazSecilen(EntityManager em, int i) {
		// TODO Auto-generated method stub
		int gelendeger = i;
		Query query = em.createNamedQuery("secilenOgrenciKayitlariniGetir").setParameter("p_id", gelendeger);
		List<?> list = query.getResultList();
		
		for (Object ogr : list) {

			Ogrenci ogrenci = (Ogrenci) ogr;

			System.out.println("ID : " + ogrenci.getId() + "\n" + 
			"ADI : " + ogrenci.getAdi() + "\n" + 
			"SOYAD : " + ogrenci.getSoyadi() + "\n" + 
			"BOLUM : " + ogrenci.getBolum() + "\n" + 
			"FAKULTE : " + ogrenci.getFakulte() + "\n" + 
			"NO : " + ogrenci.getNo() + "\n");

		}
		
	}

	private static void kayitlariYazHepsi(EntityManager em) {
		// TODO Auto-generated method stub
		
		Query query = em.createNamedQuery("tumOgrenciKayitlariniGetir");
		List<?> list = query.getResultList();
		
		for (Object ogr : list) {

			Ogrenci ogrenci = (Ogrenci) ogr;

			System.out.println("ID : " + ogrenci.getId() + "\n" + 
			"ADI : " + ogrenci.getAdi() + "\n" + 
			"SOYAD : " + ogrenci.getSoyadi() + "\n" + 
			"BOLUM : " + ogrenci.getBolum() + "\n" + 
			"FAKULTE : " + ogrenci.getFakulte() + "\n" + 
			"NO : " + ogrenci.getNo() + "\n");

		}
		
	}

	private static void kayitekle(EntityManager em, String adi, String bolum, String fakulte, String no,
			String soyadi) {
		// TODO Auto-generated method stub
		Ogrenci ogrenci4 = new Ogrenci(adi, bolum, fakulte, no, soyadi);

		em.persist(ogrenci4);

	}

}
