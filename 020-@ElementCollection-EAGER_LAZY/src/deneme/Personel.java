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

	// TableGenerator -> Ek tablo oluþturmaya yarar. Id deðerini saklar.

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int personelId;

	@Column(name = "PERSONEL_ADI")
	private String personelAdi;

	@Column(name = "PERSONEL_SOYADI")
	private String personelSoyadi;

	@Temporal(TemporalType.DATE) // ZAMANI BELÝRLEMEK ÝÇÝN KULLANILIR -> Burada sadece DATE aldýk
	private Date personelkayitTarihi;

	// Birden fazla kiþini deðiþik adresleri olacaðýn ayný sýnýf yarat deðiþken farklý
	// ama tablodaki columlar ayný isim olur.
	// Birden fazla isimlendirmeyi ayný anda vereceksek AttributeOverride kullanýlacak
	
	
	//////////// Embedded /////////////////
	@Embedded // Bu sýnýfa ait bilgiler gelecek
	@ElementCollection(fetch= FetchType.LAZY) // Child detay tablosu oluþturmasýný saðlar , 
	                                           //HÝÇBÝRÞEY KULLANILMAZSA (EAGER) BÜTÜN ÝLÝÞKÝLÝ KAYITLAR, (TUM YUKLEME)
	                                           //LAZY -> SADECE SEÇTÝÐÝN TABLODAN ÝLÝÞKÝLÝ KAYITLAR
	                                           // ORM MEDE bazý dosyalar @lob olduðundan EAGER dersek performans yavaþ olacak  
	@JoinTable(name="PERSONEL_ADRES_TABLOSU",
	joinColumns = @JoinColumn(name="PERSONEL_ID")// Child detay tablosundaki id yi deðiþtirir.
			)
	@GenericGenerator(name = "sequence-gen", strategy = "sequence")
	@CollectionId(
			columns = { @Column(name="ADRES_ID") }, 
			generator = "sequence-gen", 
			type = @Type(type = "long"))
	private Collection<Adres> adresListesi = new ArrayList<Adres>(); // Hashset tekrarsýz verileri tutmak
		
	//////////////////////////////////////

	// 3 tablo oluþtu hibernate_unique de sequence-gen -> veritabanýndaki sen sondaki deðeri verme(en sondaki deðer 5 (null sayýyor))
	

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
