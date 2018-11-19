package main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modal.Calisan;
import modal.Departman;
import util.HibernateUtil;

public class App {
	
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			Departman departman1 = new Departman();
			departman1.setDepartmanAd("Donaným");
			session.save(departman1);
			
			Departman departman2 = new Departman();
			departman2.setDepartmanAd("Yazýlým");
			session.save(departman2);
			
			//////////////////////////////////////////////////////////////////////////
			
			Calisan calisan1 = new Calisan();
			calisan1.setAd("Noyan");
			calisan1.setSoyad("Germiyanoglu");
			calisan1.setTelefonNo("12345678");
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
			Date birthdate1 = dateFormat.parse("1990-04-28");
			calisan1.setDogumTarih(birthdate1);
			
			Calisan calisan2 = new Calisan();
			calisan2.setAd("Tuðba Melis");
			calisan2.setSoyad("Türk");
			calisan2.setTelefonNo("2345612");
			
			Date birthdate2 = dateFormat.parse("1990-04-28");
			calisan2.setDogumTarih(birthdate2);
			
			Calisan calisan3 = new Calisan();
			calisan3.setAd("Tuvana");
			calisan3.setSoyad("Türkay");
			calisan3.setTelefonNo("87654321");
			
			Date birthdate3 = dateFormat.parse("1990-04-28");
			calisan3.setDogumTarih(birthdate3);
			
			/////////////////////////////////////////////////////////////////////////
			
			calisan1.setDepartman(departman1);
			calisan2.setDepartman(departman1);
			calisan3.setDepartman(departman2);
			
			/////////////////////////////////////////////////////////////////////////
			
			session.save(calisan1);
			session.save(calisan2);
			session.save(calisan3);
			
			/////////////////////////////////////////////////////////////////////////
			
			
			transaction.commit();
						
			System.out.println("BAÞARILI BÝR ÞEKÝLDE KAYIT OLDU");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}finally {
			if(transaction != null) {
				//session.close();
				HibernateUtil.closeSessionFactory();
			}
		}
		
		
	}

}
