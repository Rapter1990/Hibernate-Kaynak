package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modal.Ogrenci;
import modal.Adres;
import util.HibernateUtil;

public class App {
	
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			Adres adres = new Adres("cadde", "sehir", "semt", "postakodu");
			
			///////////////////////////////////////////////////////////////////
			
			Ogrenci ogrenci1 = new Ogrenci("Noyan", "Germiyano�lu", adres);
			
			Ogrenci ogrenci2 = new Ogrenci("Tu�ba Melis", "T�rk", adres);
			
			Ogrenci ogrenci3 = new Ogrenci("Gizem", "Ayta�", adres);
			
			///////////////////////////////////////////////////////////////////
			
			session.save(ogrenci1);
			session.save(ogrenci2);
			session.save(ogrenci3);
			
			///////////////////////////////////////////////////////////////////
			
			
			
			transaction.commit();
						
			System.out.println("BA�ARILI B�R �EK�LDE KAYIT OLDU");
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
