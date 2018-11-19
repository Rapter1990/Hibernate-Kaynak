package app;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
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
			
			Criteria criteria = session.createCriteria(Urun.class);
					
			Criterion fiyati = Restrictions.gt("urunFiyati", 8.0);	
			Criterion adi = Restrictions.ilike("urunAdi", "M%");	
			
			LogicalExpression sartlar = Restrictions.or(fiyati, adi);
			// LogicalExpression sartlar = Restrictions.and(fiyati, adi);
			criteria.add(sartlar);
			
			
			
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
