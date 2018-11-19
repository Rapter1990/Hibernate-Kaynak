package modal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PERSONEL",catalog = "HIBERNATECALISMAORTAMI")
public class Personel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long personelId;
	private String personelAd;
	private String personelSoyad;
	
	public Personel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personel(String personelAd, String personelSoyad) {
		super();
		this.personelAd = personelAd;
		this.personelSoyad = personelSoyad;
	}

	public long getPersonelId() {
		return personelId;
	}

	public void setPersonelId(long personelId) {
		this.personelId = personelId;
	}

	public String getPersonelAd() {
		return personelAd;
	}

	public void setPersonelAd(String personelAd) {
		this.personelAd = personelAd;
	}

	public String getPersonelSoyad() {
		return personelSoyad;
	}

	public void setPersonelSoyad(String personelSoyad) {
		this.personelSoyad = personelSoyad;
	}
	
}
