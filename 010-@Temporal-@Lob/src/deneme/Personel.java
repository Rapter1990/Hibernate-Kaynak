package deneme;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name = "CALISANLAR") // VERITABANI TABLO ADI
public class Personel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private int personelId;

	@Column(name = "PERSONEL_ADI")
	@Basic // VER�TABNINDA BU ALAN MUTLAKA BULUNACAK
	private String personelAdi;

	@Column(name = "PERSONEL_SOYADI")
	@Transient // VER�TABANINDA BU ALANI G�RMEZDEN GEL
	private String personelSoyadi;

	@Column(name = "PERSONEL_KAYIT_TARIHI")
	@Temporal(TemporalType.DATE) // ZAMANI BEL�RLEMEK ���N KULLANILIR -> Burada sadece DATE ald�k
	private Date personelkayitTarihi;

	@Column(name = "PERSONEL_ADRESI")
	@Lob // VER�TABANINA BUYUK VER�LER� KAYDETMEK ���N KULLANILIR
	private String personelAdresi;

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

}
