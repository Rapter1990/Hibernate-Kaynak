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
			
			/*hql = "INSERT INTO Siparis (siparisurunId, siparisurunAdi, siparisurunFiyati) "
				 +"SELECT U.urunId, U.urunAdi, U.urunFiyati FROM Urun AS U "
				 +"WHERE U.urunId =:urun_Id ";
			
			query = session.createQuery(hql);
			query.setParameter("urun_Id",  new Long(5));
			*/
			
			hql = "INSERT INTO Siparis (siparisurunId, siparisurunAdi, siparisurunFiyati) "
					 +"SELECT U.urunId, U.urunAdi, U.urunFiyati FROM Urun AS U "
					 +"WHERE U.urunId = ? ";
				
			query = session.createQuery(hql);
			query.setParameter(0,  new Long(4));
			
			int eklenenVeri = query.executeUpdate();
			
			System.out.println("Eklenen Veri : " + eklenenVeri);
			session.flush(); // Veritabanýna en güncel verileri gönderiyor.
			
			hql = "FROM Siparis AS S";
			
			List<?> urunler = session.createQuery(hql)
					.list();
			
			System.out.println("Kayýt Sayýsý : " + urunler.size());
			
			Iterator iterator = urunler.iterator();
			
			while(iterator.hasNext()) {
				
				/*Object urun[] = (Object[]) iterator.next();
				System.out.println("URUN ADI : " + urun[0] + " TOPLAM FÝYATI : " + urun[1]+ "\n************************\n");
				*/
				
				// WHERE ÝÞLEMÝNDE
				Siparis siparis = (Siparis) iterator.next();
				System.out.println(siparis.getSiparisId() + " " + siparis.getSiparisurunAdi() + " " + siparis.getSiparisurunFiyati());
				
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
