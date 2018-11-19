package deneme;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	@Column(name = "PERSONEL_ID")
	private int personelId;

	@Column(name = "PERSONEL_ADI")
	private String personelAdi;

	@Column(name = "PERSONEL_SOYADI")
	private String personelSoyadi;

	@Temporal(TemporalType.DATE) // ZAMANI BELÝRLEMEK ÝÇÝN KULLANILIR -> Burada sadece DATE aldýk
	private Date personelkayitTarihi;
	
	// PERSIST -> VERÝYÝ GÝRERKEN KULLANILIR.
	@OneToMany(cascade = CascadeType.ALL) // ALL -> veri üzerinde yaptýðýmýz her iþlemler  
	private Collection<Meslek> meslekListesi = new ArrayList<Meslek>();

	public Personel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personel(String personelAdi, String personelSoyadi, Date personelkayitTarihi) {
		super();
		this.personelAdi = personelAdi;
		this.personelSoyadi = personelSoyadi;
		this.personelkayitTarihi = personelkayitTarihi;
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

	public Collection<Meslek> getMeslekListesi() {
		return meslekListesi;
	}

	public void setMeslekListesi(Collection<Meslek> meslekListesi) {
		this.meslekListesi = meslekListesi;
	}

	
	

}
