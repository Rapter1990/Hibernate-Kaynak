package calistirma;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import deneme.Personel;
import util.HibernateUtil;

public class AnaMerkez {
	
public static void main(String[] args) {
		
		/////////////////////////////////////////////////
			
		Personel personel = null;
		
		///////////////////////////////////////////////////
		


		///////////////////////////////////////////////////
		

		///////////////////////////////////////////////////
		
		// Hibernate
		//SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();	
		
		//Session session = sessionFactory.openSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		try {
			
			// CREATE 
			/*
			for(int i=0;i<6;i++) {
				personel = new Personel();
				personel.setPersonelAdi("ADI " + i);
				personel.setPersonelSoyadi("SOYADI " + i);
				session.save(personel); // 
				
			}
			*/
			
			// READ
			/*
			personel = session.get(Personel.class, 2);
			System.out.println("Çekilen Veri :\n"
					+ "Personel Ad :" + personel.getPersonelAdi() + 
					"\nPersonel Soyad :" + personel.getPersonelSoyadi() + 
					"\n");
			*/
			
			// DELETE 
			/*
			personel = session.get(Personel.class, 3);
			session.delete(personel);
			System.out.println("SÝLÝNDÝ");
			*/
			
			//UPDATE
			personel = session.get(Personel.class, 4);
			personel.setPersonelAdi("S");
			personel.setPersonelSoyadi("S");
			session.update(personel);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.getTransaction().commit();
		session.close();
		
		//
		
		
	}

}
