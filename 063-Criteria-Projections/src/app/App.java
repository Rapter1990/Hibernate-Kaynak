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
import org.hibernate.criterion.Projections;
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
			//////////////////////////////////////////////////////////////////////
			Criteria criteria1 = session.createCriteria(Urun.class)
					.setProjection(Projections.max("urunFiyati"));
			
			Double maxDeger = (Double) criteria1.uniqueResult();
			
			System.out.println("En pahali ürünün fiyatý : " + maxDeger);
			/////////////////////////////////////////////////////////////////////
			Criteria criteria2 = session.createCriteria(Urun.class)
					.setProjection(Projections.max("urunFiyati"));
			
			Double minDeger = (Double) criteria2.uniqueResult();
			
			System.out.println("En ucuz ürünün fiyatý : " + minDeger);
			/////////////////////////////////////////////////////////////////////
			Criteria criteria3 = session.createCriteria(Urun.class)
					.setProjection(Projections.avg("urunFiyati"));
			
			Double avgDeger = (Double) criteria2.uniqueResult();
			
			System.out.println("Ortalama ürünün fiyatý : " + avgDeger);
			/////////////////////////////////////////////////////////////////////
			Criteria criteria4 = session.createCriteria(Urun.class)
					.setProjection(Projections.avg("urunFiyati"));
			
			Double sumDeger = (Double) criteria2.uniqueResult();
			
			System.out.println("Ürünlerin toplam fiyatý : " + sumDeger);
			/////////////////////////////////////////////////////////////////////
			Criteria criteria5 = session.createCriteria(Urun.class)
					.setProjection(Projections.rowCount());
			
			Double countDeger = (Double) criteria2.uniqueResult();
			int countUrunDeger = countDeger.intValue();
			System.out.println("Ürünlerin sayýsý : " + countUrunDeger);
			/////////////////////////////////////////////////////////////////////
			
			
			/*List<Urun> urunler = criteria.list();
			
			for(Object urun : urunler) {
				System.out.println(((Urun) urun).getUrunId() + " " + ((Urun) urun).getUrunAdi() + " " + ((Urun) urun).getUrunFiyati()
				                  +"\n-----------------------------------\n");
			}*/
			
			
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
