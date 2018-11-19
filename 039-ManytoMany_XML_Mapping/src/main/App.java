package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modal.Ogrenci;
import modal.Ders;
import util.HibernateUtil;

public class App {
	
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			Set<Ders> dersler1 = new HashSet<Ders>();
			dersler1.add(new Ders("JSP"));
			dersler1.add(new Ders("JSF"));
			dersler1.add(new Ders("Hibernate"));
			dersler1.add(new Ders("Spring"));
			
			Set<Ders> dersler2 = new HashSet<Ders>();
			dersler2.add(new Ders("JSP"));
			dersler2.add(new Ders("Spring"));
			
			///////////////////////////////////////////////////////////////////
			
			Ogrenci ogrenci1 = new Ogrenci("Noyan", "Germiyanoðlu", dersler1);
			
			Ogrenci ogrenci2 = new Ogrenci("Tuðba Melis", "Türk", dersler2);
			
			Ogrenci ogrenci3 = new Ogrenci("Gizem", "Aytaç", dersler1);
			
			///////////////////////////////////////////////////////////////////
			
			session.save(ogrenci1);
			session.save(ogrenci2);
			session.save(ogrenci3);
			
			///////////////////////////////////////////////////////////////////
			
			
			
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
