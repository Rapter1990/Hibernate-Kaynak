package modal;

import java.util.HashSet;
import java.util.Set;

public class Ogrenci {

	private Integer id;
	private String ad;
	private String soyad;
	private Set<Ders> dersler = new HashSet<Ders>(0);
	
	public Ogrenci() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ogrenci(String ad, String soyad, Set<Ders> dersler) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.dersler = dersler;
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

	public Set<Ders> getDersler() {
		return dersler;
	}

	public void setDersler(Set<Ders> dersler) {
		this.dersler = dersler;
	}

	
}
