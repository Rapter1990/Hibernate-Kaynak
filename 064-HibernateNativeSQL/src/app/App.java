package app;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import magaza.Urun;
import util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		Query query = null;
		try {
			
			transaction = session.beginTransaction();
			//String sql = "SELECT * FROM Urun U WHERE U.urunFiyati < ?";
			// String sql = "SELECT * FROM Urun U WHERE U.urunFiyati <:pUrunFiyati";
			 String sql = "SELECT U.urunId, U.urunAdi , U.urunFiyati FROM Urun U WHERE U.urunFiyati <:pUrunFiyati";
			
			//Query<Urun> query = session.createNativeQuery(sql, Urun.class).setFirstResult(1).setMaxResults(4);
			query = session.createNativeQuery(sql, Urun.class).setParameter("pUrunFiyati", 6.0);
			//query = session.createNativeQuery(sql, Urun.class).setParameter(1, 6.0);
		    List<Urun> list = query.getResultList();
		    for(Urun o : list){
		         System.out.println(o.getUrunId() + " " + o.getUrunAdi() + " " + o.getUrunFiyati());
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
