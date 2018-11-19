package modal;

import java.util.HashSet;
import java.util.Set;

public class Ogrenci {

	private Integer id;
	private String ad;
	private String soyad;
	private Adres adres;
	
	public Ogrenci() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Ogrenci(String ad, String soyad, Adres adres) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.adres = adres;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}


}
