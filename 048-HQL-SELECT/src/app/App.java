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
			
			String hql = "SELECT U.urunId,U.urunAdi FROM Urun AS U";
			/*
			 * String hql = "SELECT U.UrunId FROM Urun AS U";
			 * String hql = "SELECT U.UrunAdi FROM Urun AS U";
			 * String hql = "SELECT U.UrunFiyati FROM Urun AS U";
			 * String hql = "SELECT U.UrunAdi,U.UrunFiyati FROM Urun AS U";
			 * 
			 * */
			
			List<?> urunler = session.createQuery(hql).list();
			
			System.out.println("Kayýt Sayýsý : " + urunler.size());
			
			Iterator iterator = urunler.iterator();
			
			while(iterator.hasNext()) {
				// SELECT ÝÞLEMÝNDE OBJECT KULLANILACAK
				Object o[] = (Object[]) iterator.next();
				System.out.println(o[0] + " " + o[1] + "\n*************************\n");
				/*
				 * Urun urun = (Urun) iterator.next();
				 * System.out.println(urun.getUrunAdi() + " " + urun.getUrunFiyati());
				 */
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
