package main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modal.Personel;
import modal.Telefon;
import util.HibernateUtil;

public class App {
	
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			Set<Telefon> personelTelefon = new HashSet<Telefon>();
			personelTelefon.add(new Telefon("Ev","123456789"));
			personelTelefon.add(new Telefon("Ýþ","987654321"));
			
			Personel personel = new Personel("Noyan",personelTelefon);
			session.save(personel);
			
			
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
