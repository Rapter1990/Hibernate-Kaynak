package modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ADRES",catalog = "HIBERNATECALISMAORTAMI")
public class Adres implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADRES_SEQ")
	@SequenceGenerator(name="ADRES_SEQ", sequenceName="ADRES_SEQ", allocationSize=1)
	@Column(name="ADRES_ID")
	private Long adresId;
	
	@Column(name="CADDE")
	private String cadde;
	
	@Column(name="SEHIR")
	private String sehir;
	
	@Column(name="SEMT")
	private String semt;
	
	@Column(name="POSTAKODU")
	private String postakodu;
	
	public Adres() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adres(String cadde, String sehir, String semt, String postakodu) {
		super();
		this.cadde = cadde;
		this.sehir = sehir;
		this.semt = semt;
		this.postakodu = postakodu;
	}

	public Long getAdresId() {
		return adresId;
	}

	public void setAdresId(Long adresId) {
		this.adresId = adresId;
	}

	public String getCadde() {
		return cadde;
	}

	public void setCadde(String cadde) {
		this.cadde = cadde;
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	public String getSemt() {
		return semt;
	}

	public void setSemt(String semt) {
		this.semt = semt;
	}

	public String getPostakodu() {
		return postakodu;
	}

	public void setPostakodu(String postakodu) {
		this.postakodu = postakodu;
	}
	
	
}
