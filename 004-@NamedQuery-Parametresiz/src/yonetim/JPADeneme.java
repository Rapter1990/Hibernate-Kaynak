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
		Ogrenci ogrenci = new Ogrenci();
		ogrenci.setAdi("Miranda");
		ogrenci.setSoyadi("Kerr");
		ogrenci.setBolum("Biliþim");
		ogrenci.setFakulte("Mühendislik");
		ogrenci.setNo("3333333");
		

		// JPA
		try {
			emf = Persistence.createEntityManagerFactory("004-@NamedQuery-Parametresiz"); // persistence-unit adi
			em = emf.createEntityManager();

			EntityTransaction et = em.getTransaction();
			et.begin();

			em.persist(ogrenci);
			
			et.commit();
			
			Query query = em.createNamedQuery("tumOgrenciKayitlariniGetir");
			List<?> list = query.getResultList();
			
			
			for(Object ogr : list) {
				
				ogrenci = (Ogrenci) ogr;
				
				System.out.println("ID : " + ogrenci.getId() +"\n"
						+ "ADI : " + ogrenci.getAdi() + "\n"
								+ "SOYAD : " + ogrenci.getSoyadi() + "\n"
										+ "BOLUM : " + ogrenci.getBolum() + "\n"
												+ "FAKULTE : " + ogrenci.getFakulte() + "\n"
														+ "NO : " + ogrenci.getNo() +"\n");
				
				
			}
						
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
