package modal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="OGRENCI",catalog = "HIBERNATECALISMAORTAMI")
public class Ogrenci {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OGRENCI_SEQ")
	@SequenceGenerator(name="OGRENCI_SEQ", sequenceName="OGRENCI_SEQ", allocationSize=1)
	@Column(name="ID", unique=true , nullable = false)
	private Integer id;
	
	@Column(name="AD",length=50)
	private String ad;
	
	@Column(name="SOYAD",length=50)
	private String soyad;
	
	@OneToOne(mappedBy ="ogrenci",cascade = CascadeType.ALL)
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
