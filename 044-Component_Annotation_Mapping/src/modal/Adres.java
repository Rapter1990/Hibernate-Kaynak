package modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adres implements Serializable{

	private static final long serialVersionUID = 1L;
	
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
