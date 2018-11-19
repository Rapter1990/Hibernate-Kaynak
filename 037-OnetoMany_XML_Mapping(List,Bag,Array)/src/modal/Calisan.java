package modal;

import java.util.Date;

public class Calisan {

	private Integer id;
	private String ad;
	private String soyad;
	private Date dogumTarih;
	private String telefonNo;
	private Departman departman;
	
	public Calisan() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Calisan(String ad, String soyad, Date dogumTarih, String telefonNo, Departman departman) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.dogumTarih = dogumTarih;
		this.telefonNo = telefonNo;
		this.departman = departman;
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

	

	public Departman getDepartman() {
		return departman;
	}



	public void setDepartman(Departman departman) {
		this.departman = departman;
	}



	public Date getDogumTarih() {
		return dogumTarih;
	}

	public void setDogumTarih(Date dogumTarih) {
		this.dogumTarih = dogumTarih;
	}

	public String getTelefonNo() {
		return telefonNo;
	}

	public void setTelefonNo(String telefonNo) {
		this.telefonNo = telefonNo;
	}
	
	
	
}
