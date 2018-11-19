package main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modal.Personel;
import util.HibernateUtil;

public class App {
	
	
	public static void main(String[] args) {
		
		App app = new App();
		
		Long personelId1 = app.personelKaydet("Noyan","Germiyanoðlu"); // INSERT - CREATE
		Long personelId2 = app.personelKaydet("Ali","Koç"); 
		Long personelId3 = app.personelKaydet("Murat","Kaya"); 
		Long personelId4 = app.personelKaydet("Pelin","Pehlivan"); 
		Long personelId5 = app.personelKaydet("Aslý","Erdoðan"); 
		Long personelId6 = app.personelKaydet("Gamze","Gürsoy"); 
		Long personelId7 = app.personelKaydet("Gözde","Sarý"); 
		
		app.personelListe(); // READ
		
		app.personelGuncelle(personelId1,"Sercan Noyan","Germiyanoðlu"); // UPDATE
		
		app.personelSil(personelId5); // DELETE
		app.personelSil(personelId6); // DELETE
		
		app.personelGuncelle(personelId3,"Barýþ","Doðan"); 
		app.personelGuncelle(personelId4,"Osman","Þahin");
		
		app.personelListe();
		
	}

	private void personelSil(Long personelId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			Personel personel = session.get(Personel.class, personelId);
			
			session.delete(personel);
			
			transaction.commit();
			System.out.println("BAÞARILI BÝR ÞEKÝLDE SÝLÝNDÝ...");			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}finally {
			if(transaction != null) {
				session.close();
				//HibernateUtil.closeSessionFactory();
			}
		}
		
	}

	private void personelGuncelle(Long personelId, String ad, String soyad) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			Personel personel = session.get(Personel.class, personelId);
			personel.setPersonelAd(ad);
			personel.setPersonelSoyad(soyad);
			session.update(personel);
			
			transaction.commit();
			System.out.println("BAÞARILI BÝR ÞEKÝLDE GÜNCELLENDÝ...");				
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}finally {
			if(transaction != null) {
				session.close();
				//HibernateUtil.closeSessionFactory();
			}
		}
		
	}

	private void personelListe() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			List<Personel> personeller = session.createQuery("FROM Personel").list();
			
			for (Iterator iterator = personeller.iterator(); iterator.hasNext();) {
				Personel personel = (Personel) iterator.next();
				System.out.println(personel.getPersonelAd() + " " + personel.getPersonelSoyad());
			}
			
			transaction.commit();
			System.out.println("BAÞARILI BÝR ÞEKÝLDE LÝSTELENDÝ...");			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}finally {
			if(transaction != null) {
				session.close();
				//HibernateUtil.closeSessionFactory();
			}
		}
		
		
	}

	private Long personelKaydet(String ad, String soyad) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		Long personelId = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			Personel personel = new Personel();
			personel.setPersonelAd(ad);
			personel.setPersonelSoyad(soyad);
			
			personelId = (Long) session.save(personel);
			
			
			transaction.commit();
			System.out.println("BAÞARILI BÝR ÞEKÝLDE KAYDEDÝLDÝ...");					
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}finally {
			if(transaction != null) {
				session.close();
				//HibernateUtil.closeSessionFactory();
			}
		}
		
		return personelId;
	}

}
