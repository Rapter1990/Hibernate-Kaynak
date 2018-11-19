package modal;

public class Ogrenci {

	private Integer id;
	private String ad;
	private String soyad;
	private OgrenciBilgisi ogrenciBilgisi;
	
	////////////////////////////////////////
	
	public Ogrenci() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ogrenci(String ad, String soyad, OgrenciBilgisi ogrenciBilgisi) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.ogrenciBilgisi = ogrenciBilgisi;
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
	public OgrenciBilgisi getOgrenciBilgisi() {
		return ogrenciBilgisi;
	}
	public void setOgrenciBilgisi(OgrenciBilgisi ogrenciBilgisi) {
		this.ogrenciBilgisi = ogrenciBilgisi;
	}
	
}
