package app;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import magaza.Siparis;
import magaza.Urun;
import util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			//Criteria criteria = session.createCriteria(Urun.class)
			//		.add(Restrictions.eqOrIsNull("urunFiyati", 10.0));  // eqOrIsNull -> eþit veya boþ olan
			
			//Criteria criteria = session.createCriteria(Urun.class)
			//		.add(Restrictions.ne("urunFiyati", 10.0));  // ne -> eþit deðil
			
			//Criteria criteria = session.createCriteria(Urun.class)
			//		.add(Restrictions.lt("urunFiyati", 10.0));  // ld -> lower than
			
			//Criteria criteria = session.createCriteria(Urun.class)
			//		.add(Restrictions.gt("urunFiyati", 8.0));  // ld -> greather than
			
			//Criteria criteria = session.createCriteria(Urun.class)
			//		.add(Restrictions.le("urunFiyati", 8.0));  // le -> less than or equal
			
			//Criteria criteria = session.createCriteria(Urun.class)
			//		.add(Restrictions.ge("urunFiyati", 8.0));  // ge -> less than or equal
			
			//Criteria criteria = session.createCriteria(Urun.class)
			//		.add(Restrictions.like("urunAdi", "Ç%"));  //  // Ç ile baþlayan
			
			//Criteria criteria = session.createCriteria(Urun.class)
			//		.add(Restrictions.like("urunAdi", "_a%"));  //  // ikinci harfi a olan
			
			Criteria criteria = session.createCriteria(Urun.class)
					.add(Restrictions.like("urunAdi", "_a%"))  //  // ikinci harfi a olan
					.add(Restrictions.between("urunFiyati", 1.0, 100.0)); // Urun Fiyatý 1 ile 100 arasýnda olanlar
			
			
			
			
			List<Urun> urunler = criteria.list();
			
			for(Object urun : urunler) {
				System.out.println(((Urun) urun).getUrunId() + " " + ((Urun) urun).getUrunAdi() + " " + ((Urun) urun).getUrunFiyati()
				                  +"\n-----------------------------------\n");
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
