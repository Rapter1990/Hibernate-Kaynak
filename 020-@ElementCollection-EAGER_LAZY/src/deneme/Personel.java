package deneme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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
	@ElementCollection(fetch= FetchType.LAZY) // Child detay tablosu olu�turmas�n� sa�lar , 
	                                           //H��B�R�EY KULLANILMAZSA (EAGER) B�T�N �L��K�L� KAYITLAR, (TUM YUKLEME)
	                                           //LAZY -> SADECE SE�T���N TABLODAN �L��K�L� KAYITLAR
	                                           // ORM MEDE baz� dosyalar @lob oldu�undan EAGER dersek performans yava� olacak  
	@JoinTable(name="PERSONEL_ADRES_TABLOSU",
	joinColumns = @JoinColumn(name="PERSONEL_ID")// Child detay tablosundaki id yi de�i�tirir.
			)
	@GenericGenerator(name = "sequence-gen", strategy = "sequence")
	@CollectionId(
			columns = { @Column(name="ADRES_ID") }, 
			generator = "sequence-gen", 
			type = @Type(type = "long"))
	private Collection<Adres> adresListesi = new ArrayList<Adres>(); // Hashset tekrars�z verileri tutmak
		
	//////////////////////////////////////

	// 3 tablo olu�tu hibernate_unique de sequence-gen -> veritaban�ndaki sen sondaki de�eri verme(en sondaki de�er 5 (null say�yor))
	

	public int getPersonelId() {
		return personelId;
	}

	public Collection<Adres> getAdresListesi() {
		return adresListesi;
	}

	public void setAdresListesi(Collection<Adres> adresListesi) {
		this.adresListesi = adresListesi;
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
