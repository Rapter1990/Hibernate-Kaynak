package deneme;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MESLEK")
public class Meslek {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MESLEK_ID")
	private int meslekId;
	
	@Column(name="MESLEK_ADI")
	private String meslekAdi;

	//@ManyToMany(mappedBy="meslekListesi") // M - M ÝLÝÞKÝ  -> TEK YONLU
	@ManyToMany //-> ÇÝFT YÖNLÜ
	private Collection<Personel> personelListesi = new ArrayList<Personel>();
	
	public Meslek() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Meslek(String meslekAdi) {
		super();
		this.meslekAdi = meslekAdi;
	}

	public int getMeslekId() {
		return meslekId;
	}

	public void setMeslekId(int meslekId) {
		this.meslekId = meslekId;
	}

	public String getMeslekAdi() {
		return meslekAdi;
	}

	public void setMeslekAdi(String meslekAdi) {
		this.meslekAdi = meslekAdi;
	}

	public Collection<Personel> getPersonelListesi() {
		return personelListesi;
	}

	public void setPersonelListesi(Collection<Personel> personelListesi) {
		this.personelListesi = personelListesi;
	}

	
}
