package modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TELEFON",catalog = "HIBERNATECALISMAORTAMI")
public class Telefon implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long telefonId;
	private String telefonTipi;
	private String telefonNo;
	
	public Telefon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Telefon(String telefonTipi, String telefonNo) {
		super();
		this.telefonTipi = telefonTipi;
		this.telefonNo = telefonNo;
	}

	@Id
	@GeneratedValue
	@Column(name="TELEFON_ID")
	public long getTelefonId() {
		return telefonId;
	}

	public void setTelefonId(long telefonId) {
		this.telefonId = telefonId;
	}

	@Column(name="TELEFON_TIPI", nullable=false, length = 25)
	public String getTelefonTipi() {
		return telefonTipi;
	}

	public void setTelefonTipi(String telefonTipi) {
		this.telefonTipi = telefonTipi;
	}

	@Column(name="TELEFON_NO", nullable=false, length = 25)
	public String getTelefonNo() {
		return telefonNo;
	}

	public void setTelefonNo(String telefonNo) {
		this.telefonNo = telefonNo;
	}
	
}
