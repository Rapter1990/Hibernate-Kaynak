package modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="OGRENCI",catalog = "HIBERNATECALISMAORTAMI")
public class Ogrenci implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OGRENCI_SEQ")
	@SequenceGenerator(name="OGRENCI_SEQ", sequenceName="OGRENCI_SEQ", allocationSize=1)
	@Column(name="OGRENCI_ID")
	private Integer id;
	
	@Column(name="OGRENCI_AD")
	private String ad;
	
	@Column(name="OGRENCI_SOYAD")
	private String soyad;
	
	@Embedded
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
