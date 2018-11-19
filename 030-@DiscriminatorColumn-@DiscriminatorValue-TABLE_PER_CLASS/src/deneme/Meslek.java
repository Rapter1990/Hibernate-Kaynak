package deneme;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.JOINED) // Sýngle -> varsayýlan -> JOIN -> birleþik -> Table_per_class tum tablolarý bir sýnýfa haritalama
@DiscriminatorColumn( // DTYPE tipini ve adýný belirleme
		name="MESLEK_TIPI", discriminatorType= DiscriminatorType.STRING
		)
@DiscriminatorValue(value="MESLEK")
@Table(name="MESLEK")
public class Meslek {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // deðerleri TABLOYA GÖRE DAÐITIR.
	@Column(name="MESLEK_ID")
	private int meslekId;
	
	@Column(name="MESLEK_ADI")
	private String meslekAdi;


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


}
