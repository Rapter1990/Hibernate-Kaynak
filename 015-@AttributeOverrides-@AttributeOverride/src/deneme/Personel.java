package deneme;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CALISANLAR") // VERITABANI TABLO ADI
public class Personel implements Serializable {

	private static final long serialVersionUID = 1L;

	// GeneratedValue -> Otamatik ID verir.

	// TableGenerator -> Ek tablo olu�turmaya yarar. Id de�erini saklar.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int personelId;

	@Column(name = "PERSONEL_ADI")
	private String personelAdi;

	@Column(name = "PERSONEL_SOYADI")
	private String personelSoyadi;

	@Temporal(TemporalType.DATE) // ZAMANI BEL�RLEMEK ���N KULLANILIR -> Burada sadece DATE ald�k
	private Date personelkayitTarihi;

	// Birden fazla ki�ini de�i�ik adresleri olaca��n ayn� s�n�f yarat de�i�ken farkl�
	// ama tablodaki columlar ayn� isim olur.
	// Birden fazla isimlendirmeyi ayn� anda vereceksek AttributeOverride kullan�lacak
	
	
	//////////// Embedded /////////////////
	@Embedded // Bu s�n�fa ait bilgiler gelecek
	@AttributeOverrides({
		@AttributeOverride(name="sehir",column=@Column(name="IS_SEHIR")),
		@AttributeOverride(name="semt",column=@Column(name="IS_SEMT")),
		@AttributeOverride(name="mahalle",column=@Column(name="IS_MAHALLE")),
		@AttributeOverride(name="cadde",column=@Column(name="IS_CADDE")),
		@AttributeOverride(name="kapiNo",column=@Column(name="IS_KAPI_NO")),
		@AttributeOverride(name="daireNo",column=@Column(name="IS_DAIRE_NO")),
	    @AttributeOverride(name="kat",column=@Column(name="IS_KAT")),
	    @AttributeOverride(name="postaKodu",column=@Column(name="IS_POSTA_KODU"))
	})
	private Adres isAdres;
	
	////////////Embedded /////////////////
	@Embedded // Bu s�n�fa ait bilgiler gelecek
	@AttributeOverrides({
		@AttributeOverride(name="sehir",column=@Column(name="EV_SEHIR")),
		@AttributeOverride(name="semt",column=@Column(name="EV_SEMT")),
		@AttributeOverride(name="mahalle",column=@Column(name="EV_MAHALLE")),
		@AttributeOverride(name="cadde",column=@Column(name="EV_CADDE")),
		@AttributeOverride(name="kapiNo",column=@Column(name="EV_KAPI_NO")),
		@AttributeOverride(name="daireNo",column=@Column(name="EV_DAIRE_NO")),
	    @AttributeOverride(name="kat",column=@Column(name="EV_KAT")),
	    @AttributeOverride(name="postaKodu",column=@Column(name="EV_POSTA_KODU"))
	})
	private Adres evAdres;
	
	

	public Adres getIsAdres() {
		return isAdres;
	}

	public void setIsAdres(Adres isAdres) {
		this.isAdres = isAdres;
	}

	public Adres getEvAdres() {
		return evAdres;
	}

	public void setEvAdres(Adres evAdres) {
		this.evAdres = evAdres;
	}

	//////////////////////////////////////

	

	public int getPersonelId() {
		return personelId;
	}

	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}

	public String getPersonelAdi() {
		return personelAdi;
	}

	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}

	public String getPersonelSoyadi() {
		return personelSoyadi;
	}

	public void setPersonelSoyadi(String personelSoyadi) {
		this.personelSoyadi = personelSoyadi;
	}

	public Date getPersonelkayitTarihi() {
		return personelkayitTarihi;
	}

	public void setPersonelkayitTarihi(Date personelkayitTarihi) {
		this.personelkayitTarihi = personelkayitTarihi;
	}

	/*
	 * public String getPersonelAdresi() { return personelAdresi; }
	 * 
	 * public void setPersonelAdresi(String personelAdresi) { this.personelAdresi =
	 * personelAdresi; }
	 */

}
