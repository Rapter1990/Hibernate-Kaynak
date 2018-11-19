package app;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import magaza.Urun;
import util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			List<Urun> urunler = session.createQuery("FROM Urun").list();
			
			System.out.println("Kay�t Say�s� : " + urunler.size());
			
			for (Iterator iterator = urunler.iterator(); iterator.hasNext();) {
				Urun urun = (Urun) iterator.next();
				System.out.println(urun.getUrunAdi() + " " + urun.getUrunFiyati());
			}
			
			transaction.commit();
			System.out.println("BA�ARILI B�R �EK�LDE L�STELEND�...");			
			
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
}
