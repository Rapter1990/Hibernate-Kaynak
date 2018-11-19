package deneme;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity 
@Table(name="CALISANLAR")// VERITABANI TABLO ADI
@SecondaryTable(name="PersonelDetay") // Ýkinci tablo
public class Personel implements Serializable {

	private static final long serialVersionUID = 1L;

	// GeneratedValue -> Otamatik ID verir.
	
	// TableGenerator -> Ek tablo oluþturmaya yarar. Id deðerini saklar.
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private int personelId;

	@Column(name = "PERSONEL_ADI")
	private String personelAdi;

	@Column(name = "PERSONEL_SOYADI")
	private String personelSoyadi;

	@Column(name = "TARIH",table="PersonelDetay")
	@Temporal(TemporalType.DATE) // ZAMANI BELÝRLEMEK ÝÇÝN KULLANILIR -> Burada sadece DATE aldýk
	private Date personelkayitTarihi;

	@Column(name = "ADRES",table="PersonelDetay" )
	@Lob // VERÝTABANINA BUYUK VERÝLERÝ KAYDETMEK ÝÇÝN KULLANILIR
	private String personelAdresi;
	
	@Column(table="PersonelDetay")
	private String personelmaasi;
	
	@Column(table="PersonelDetay")
	private String personelTelefonu;
	

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

	public String getPersonelAdresi() {
		return personelAdresi;
	}

	public void setPersonelAdresi(String personelAdresi) {
		this.personelAdresi = personelAdresi;
	}

	public String getPersonelmaasi() {
		return personelmaasi;
	}

	public void setPersonelmaasi(String personelmaasi) {
		this.personelmaasi = personelmaasi;
	}

	public String getPersonelTelefonu() {
		return personelTelefonu;
	}

	public void setPersonelTelefonu(String personelTelefonu) {
		this.personelTelefonu = personelTelefonu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
