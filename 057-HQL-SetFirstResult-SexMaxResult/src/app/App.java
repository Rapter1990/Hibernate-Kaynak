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
			
			// 1 den sonraki 3 kayýtý göster. (2 den baþlar 2,3,4)
			query.setFirstResult(2);
			query.setMaxResults(3);
			
			//session.flush(); // Veritabanýna en güncel verileri gönderiyor.
			
			List<Urun> urunler = (List<Urun>) ((org.hibernate.query.Query) query).list();
			
			/*for(Urun urun : urunler) {
				System.out.println(urun.getUrunId() + " " + urun.getUrunAdi() + " " + urun.getUrunFiyati()
				                  +"\n---------------------------\n");
			}*/
			
			for(Object urun : urunler) {
				System.out.println(urun +"\n---------------------------\n");
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
