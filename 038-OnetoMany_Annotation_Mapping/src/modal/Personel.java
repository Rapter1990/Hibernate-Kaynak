package modal;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PERSONEL",catalog = "HIBERNATECALISMAORTAMI")
public class Personel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long personelId;
	private String personelAd;
	private Set<Telefon> personelTelefonlari = new HashSet<Telefon>();
	
	
	public Personel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Personel(String personelAd, Set<Telefon> personelTelefonlari) {
		super();
		this.personelAd = personelAd;
		this.personelTelefonlari = personelTelefonlari;
	}

	@Id
	@GeneratedValue
	@Column(name="PERSONEL_ID")
	public long getPersonelId() {
		return personelId;
	}

	public void setPersonelId(long personelId) {
		this.personelId = personelId;
	}

	@Column(name="PERSONEL_AD", nullable=false, length = 25)
	public String getPersonelAd() {
		return personelAd;
	}

	public void setPersonelAd(String personelAd) {
		this.personelAd = personelAd;
	}

	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PERSONEL_TELEFON", // EK TABLO
			   joinColumns = {@JoinColumn(name="PERSONEL_ID")}, // HAKIM TARAF 
			   inverseJoinColumns = {@JoinColumn(name="TELEFON_ID")} //HAKIM OLMAYAN TARAF TABLONUN KOLUNU
			)
	public Set<Telefon> getPersonelTelefonlari() {
		return personelTelefonlari;
	}

	
	public void setPersonelTelefonlari(Set<Telefon> personelTelefonlari) {
		this.personelTelefonlari = personelTelefonlari;
	}
	
}
