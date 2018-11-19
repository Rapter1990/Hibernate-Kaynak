package app;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import magaza.Urun;
import util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		Query query = null;
		String hql = null;
		try {
			
			transaction = session.beginTransaction();
			/*
			hql = "DELETE FROM Urun AS U WHERE U.urunId =:urun_Id";
			

			query = session.createQuery(hql);
			query.setParameter("urun_Id",  new Long(8));
			*/
			
			hql = "DELETE FROM Urun AS U WHERE U.urunId = ?";
			
			query = session.createQuery(hql);
			query.setParameter(0,  new Long(8));
			
			int silinenVeri = query.executeUpdate();
			
			System.out.println("Silinen Veri sayýsý : " + silinenVeri);
			session.flush(); // Veritabanýna en güncel verileri gönderiyor.
			
			hql = "FROM Urun AS U";
			
			List<?> urunler = session.createQuery(hql)
					.list();
			
			System.out.println("Kayýt Sayýsý : " + urunler.size());
			
			Iterator iterator = urunler.iterator();
			
			while(iterator.hasNext()) {
				
				/*Object urun[] = (Object[]) iterator.next();
				System.out.println("URUN ADI : " + urun[0] + " TOPLAM FÝYATI : " + urun[1]+ "\n************************\n");
				*/
				
				// WHERE ÝÞLEMÝNDE
				Urun urun = (Urun) iterator.next();
				System.out.println(urun.getUrunId() + " " +urun.getUrunAdi() + " " + urun.getUrunFiyati());
				
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
