package modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="OGRENCIBILGISI",catalog = "HIBERNATECALISMAORTAMI")
public class OgrenciBilgisi {
	
	@Id
	@GeneratedValue
	@Column(name="ID", unique=true , nullable = false)
	private Integer id;
	
	@Column(name="ADRES",length=50)
	private String adres;
	
	@Column(name="KAYIT_NO",length=50)
	private String kayitNo;
	
	@Column(name="TELEFON_NO",length=50)
	private String telefonNo;
	
	@Column(name="EMAIL",length=50)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DOGUM_TARIHI",length=50)
	private Date dogumTarihi;
	
	@Temporal(TemporalType.DATE)
	@Column(name="KAYIT_TARIHI",length=50)
	private Date kayitTarihi;
	
	@OneToOne(fetch = FetchType.LAZY)
	//@PrimaryKeyJoinColumn -> tek bir tablo hailne getirir.
	private Ogrenci ogrenci;
	// lazy ihtiyaç oldukça onetoone iliþkiyi saðlar.
	// eager -> tüm tabloyu one-to-one olarak alýp hepsini getirme
	
	//////////////////////////////////////////////////////////
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getKayitNo() {
		return kayitNo;
	}
	public void setKayitNo(String kayitNo) {
		this.kayitNo = kayitNo;
	}
	public String getTelefonNo() {
		return telefonNo;
	}
	public void setTelefonNo(String telefonNo) {
		this.telefonNo = telefonNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDogumTarihi() {
		return dogumTarihi;
	}
	public void setDogumTarihi(Date dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}
	public Date getKayitTarihi() {
		return kayitTarihi;
	}
	public void setKayitTarihi(Date kayitTarihi) {
		this.kayitTarihi = kayitTarihi;
	}
	public Ogrenci getOgrenci() {
		return ogrenci;
	}
	public void setOgrenci(Ogrenci ogrenci) {
		this.ogrenci = ogrenci;
	}
	


	
}
