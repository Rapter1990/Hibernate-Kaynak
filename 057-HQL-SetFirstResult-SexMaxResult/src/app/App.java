package app;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import magaza.Siparis;
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
			
			hql = "SELECT U.urunAdi FROM Urun AS U";
				
			query = session.createQuery(hql);
			
			// 1 den sonraki 3 kay�t� g�ster. (2 den ba�lar 2,3,4)
			query.setFirstResult(2);
			query.setMaxResults(3);
			
			//session.flush(); // Veritaban�na en g�ncel verileri g�nderiyor.
			
			List<Urun> urunler = (List<Urun>) ((org.hibernate.query.Query) query).list();
			
			/*for(Urun urun : urunler) {
				System.out.println(urun.getUrunId() + " " + urun.getUrunAdi() + " " + urun.getUrunFiyati()
				                  +"\n---------------------------\n");
			}*/
			
			for(Object urun : urunler) {
				System.out.println(urun +"\n---------------------------\n");
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
