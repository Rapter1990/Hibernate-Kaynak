package yonetim;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.modal.Personel;

public class JPADeneme {

	public static void main(String[] args) {

		EntityManagerFactory emf;
		EntityManager em;

		// Personel Objesi
		Personel personel = new Personel();
		personel.setPersonelAdi("Noyan");
		personel.setPersonelSoyadi("Germiyanoðlu");

		// JPA
		try {
			emf = Persistence.createEntityManagerFactory("002-SelamJPA"); // persistence-unit adi
			em = emf.createEntityManager();

			EntityTransaction et = em.getTransaction();
			et.begin();

			em.persist(personel);
			
			et.commit();
			
			System.out.println("ID : " + personel.getPersonelId() +"\n"
					+ "ADI : " + personel.getPersonelAdi() + "\n"
							+ "SOYAD : " + personel.getPersonelSoyadi());
			
			
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
