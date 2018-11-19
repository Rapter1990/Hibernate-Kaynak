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
		
		try {
			
			transaction = session.beginTransaction();
			
			String hql = "SELECT U.urunAdi , SUM(U.urunFiyati) "
					   + "FROM Urun AS U "
					   + "GROUP BY U.urunAdi";
			
			/*
			 * String hql = "FROM Urun AS U WHERE U.urunId >= :parametre ORDER BY U.urunAdi ASC";
			 * String hql = "FROM Urun AS U WHERE U.urunId >= :parametre ORDER BY U.urunAdi DESC";
			 * */
			List<?> urunler = session.createQuery(hql)
					//.setParameter("parametre",  new Long(1))
					//.setParameter(1, 7)
					.list();
			
			System.out.println("Kayýt Sayýsý : " + urunler.size());
			
			Iterator iterator = urunler.iterator();
			
			while(iterator.hasNext()) {
				Object urun[] = (Object[]) iterator.next();
				System.out.println("URUN ADI : " + urun[0] + " TOPLAM FÝYATI : " + urun[1]+ "\n************************\n");
				
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
