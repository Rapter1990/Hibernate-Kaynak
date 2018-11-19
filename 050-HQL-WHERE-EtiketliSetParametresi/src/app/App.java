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
			
			String hql = "FROM Urun AS U WHERE U.urunId = :parametre";
			
			/*
			 * String hql = "FROM Urun AS U WHERE U.urunId <= :parametre";
			 * String hql = "FROM Urun AS U WHERE U.urunId => :parametre";
			 * String hql = "FROM Urun AS U WHERE U.urunId => :parametre AND U.urunfiyat� <= :parametre;
			 * String hql = "FROM Urun AS U WHERE U.urunId => :parametre OR U.urunfiyat� <= :parametre;
			 * */
			List<?> urunler = session.createQuery(hql)
					.setParameter("parametre",  new Long(3))
					.list();
			
			System.out.println("Kay�t Say�s� : " + urunler.size());
			
			Iterator iterator = urunler.iterator();
			
			while(iterator.hasNext()) {
				// WHERE ��LEM�NDE
				Urun urun = (Urun) iterator.next();
				System.out.println(urun.getUrunId() + " " +urun.getUrunAdi() + " " + urun.getUrunFiyati());
				
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
