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
			
			String hql = "FROM Urun AS U";
			
			List<Urun> urunler = session.createQuery(hql).list();
			/*
			 * List<Urun> urunler = session.createQuery("from Urun").list();
			 * List<Urun> urunler = session.createQuery("FROM Urun").list();
			 * List<Urun> urunler = session.createQuery("from Urun as u").list();
			 * List<Urun> urunler = session.createQuery("FROM Urun AS u").list();
			 */
			
			System.out.println("Kayýt Sayýsý : " + urunler.size());
			
			for (Iterator iterator = urunler.iterator(); iterator.hasNext();) {
				Urun urun = (Urun) iterator.next();
				System.out.println(urun.getUrunAdi() + " " + urun.getUrunFiyati());
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
}
