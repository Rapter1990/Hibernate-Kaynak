package modal;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ADRES")
public class Adres implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String cadde;
	private String sehir;
	private String semt;
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
