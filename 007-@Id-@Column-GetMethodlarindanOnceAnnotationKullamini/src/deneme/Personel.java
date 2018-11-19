package deneme;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="PERSONEL_TABLOSU") // VERITABANI TABLO ADI
public class Personel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private int personelId;
	
	
	private String personelAdi;
	
	private String personelSoyadi;
	
	@Id
	@Column(name="ID")
	public int getPersonelId() {
		return personelId;
	}
	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}
	
	@Column(name="PERSONEL_ADI")
	public String getPersonelAdi() {
		return personelAdi;
	}
	public void setPersonelAdi(String personelAdi) {
		this.personelAdi = personelAdi;
	}
	
	@Column(name="PERSONEL_SOYADI")
	public String getPersonelSoyadi() {
		return personelSoyadi;
	}
	public void setPersonelSoyadi(String personelSoyadi) {
		this.personelSoyadi = personelSoyadi;
	}
	
	

}
