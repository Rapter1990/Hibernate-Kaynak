package main;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import modal.Ogrenci;
import modal.OgrenciBilgisi;
import util.HibernateUtil;

public class App {
	
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.openSessionFactory();
		Transaction transaction = null;
		
		try {
			
			transaction = session.beginTransaction();
			
			Ogrenci ogrenci = new Ogrenci();
			ogrenci.setAd("Noyan");
			ogrenci.setSoyad("Germiyanoglu");
			
			OgrenciBilgisi ogrenciBilgisi = new OgrenciBilgisi();
			ogrenciBilgisi.setAdres("Ankara");
			ogrenciBilgisi.setKayitNo("12345678");
			ogrenciBilgisi.setTelefonNo("03214571199");
			ogrenciBilgisi.setEmail("aaa@bbb.com");
			ogrenciBilgisi.setKayitTarihi(new Date());
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
			Date birthdate = dateFormat.parse("1990-04-28");
			ogrenciBilgisi.setDogumTarihi(birthdate);
			
			ogrenciBilgisi.setOgrenci(ogrenci);
			ogrenci.setOgrenciBilgisi(ogrenciBilgisi);
			
			session.save(ogrenci);
			
			transaction.commit();
						
			System.out.println("BAÞARILI BÝR ÞEKÝLDE KAYIT OLDU");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}finally {
			if(transaction != null) {
				//session.close();
				HibernateUtil.closeSessionFactory();
			}
		}
		
		
	}

}
