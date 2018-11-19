package deneme;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
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
	@ElementCollection // Child detay tablosu olu�turmas�n� sa�lar
	@JoinTable(name="PERSONEL_ADRES_TABLOSU")
	private Set<Adres> adresListesi = new HashSet<>() ; // Hashset tekrars�z verileri tutmak
		
	//////////////////////////////////////

	
	public Set<Adres> getAdresListesi() {
		return adresListesi;
	}

	public void setAdresListesi(Set<Adres> adresListesi) {
		this.adresListesi = adresListesi;
	}

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
