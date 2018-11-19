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
@Inheritance(strategy=InheritanceType.JOINED) // S�ngle -> varsay�lan -> JOIN -> birle�ik -> Table_per_class tum tablolar� bir s�n�fa haritalama
@DiscriminatorColumn( // DTYPE tipini ve ad�n� belirleme
		name="MESLEK_TIPI", discriminatorType= DiscriminatorType.STRING
		)
@DiscriminatorValue(value="MESLEK")
@Table(name="MESLEK")
public class Meslek {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // de�erleri TABLOYA G�RE DA�ITIR.
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
