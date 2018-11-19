package yonetim;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.modal.Ogrenci;

public class JPADeneme {

	public static void main(String[] args) {

		EntityManagerFactory emf;
		EntityManager em;

		// Personel Objesi
		Ogrenci ogrenci = new Ogrenci();
		ogrenci.setAdi("Noyan");
		ogrenci.setSoyadi("Germiyanoglu");
		ogrenci.setBolum("Biliþim");
		ogrenci.setFakulte("Mühendislik Fakültesi");
		ogrenci.setNo("123456789");
		

		// JPA
		try {
			emf = Persistence.createEntityManagerFactory("003-TablodanJavaSiniflariniOluþturma"); // persistence-unit adi
			em = emf.createEntityManager();

			EntityTransaction et = em.getTransaction();
			et.begin();

			em.persist(ogrenci);
			
			et.commit();
			
			System.out.println("ID : " + ogrenci.getId() +"\n"
					+ "ADI : " + ogrenci.getAdi() + "\n"
							+ "SOYAD : " + ogrenci.getSoyadi() + "\n"
									+ "BOLUM : " + ogrenci.getBolum() + "\n"
											+ "FAKULTE : " + ogrenci.getFakulte() + "\n"
													+ "NO : " + ogrenci.getNo());
			
			
			em.close();
			emf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
