package deneme;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERSONEL")
public class Personel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="PERSONEL_ID")
	private int personelId;
	
	@Column(name = "PERSONEL_ADI")
	private String personelAdi;
	
	@Column(name = "PERSONEL_SOYADI")
	private String personelSoyadi;

	public Personel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personel(String personelAdi, String personelSoyadi) {
		super();
		this.personelAdi = personelAdi;
		this.personelSoyadi = personelSoyadi;
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
	
}
