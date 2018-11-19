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
			//		.add(Restrictions.eqOrIsNull("urunFiyati", 10.0));  // eqOrIsNull -> e�it veya bo� olan
			
			//Criteria criteria = session.createCriteria(Urun.class)
			//		.add(Restrictions.ne("urunFiyati", 10.0));  // ne -> e�it de�il
			
			//Criteria criteria = session.createCriteria(Urun.class)
			//		.add(Restrictions.lt("urunFiyati", 10.0));  // ld -> lower than
			
			//Criteria criteria = session.createCriteria(Urun.class)
			//		.add(Restrictions.gt("urunFiyati", 8.0));  // ld -> greather than
			
			//Criteria criteria = session.createCriteria(Urun.class)
			//		.add(Restrictions.le("urunFiyati", 8.0));  // le -> less than or equal
			
			//Criteria criteria = session.createCriteria(Urun.class)
			//		.add(Restrictions.ge("urunFiyati", 8.0));  // ge -> less than or equal
			
			//Criteria criteria = session.createCriteria(Urun.class)
			//		.add(Restrictions.like("urunAdi", "�%"));  //  // � ile ba�layan
			
			//Criteria criteria = session.createCriteria(Urun.class)
			//		.add(Restrictions.like("urunAdi", "_a%"));  //  // ikinci harfi a olan
			
			Criteria criteria = session.createCriteria(Urun.class)
					.add(Restrictions.like("urunAdi", "_a%"))  //  // ikinci harfi a olan
					.add(Restrictions.between("urunFiyati", 1.0, 100.0)); // Urun Fiyat� 1 ile 100 aras�nda olanlar
			
			
			
			
			List<Urun> urunler = criteria.list();
			
			for(Object urun : urunler) {
				System.out.println(((Urun) urun).getUrunId() + " " + ((Urun) urun).getUrunAdi() + " " + ((Urun) urun).getUrunFiyati()
				                  +"\n-----------------------------------\n");
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
