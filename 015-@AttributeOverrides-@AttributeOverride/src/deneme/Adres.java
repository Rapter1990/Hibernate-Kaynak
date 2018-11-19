package deneme;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable // Bu sýnýf baþka bir varlýk sýnýflarý tarafýndan çaðýrýlýr bir alan gibi kullanýlýr.
public class Adres {
	
	//@Column(name="SEHIR")
	private String sehir;
	
	//@Column(name="SEMT")
	private String semt;
	
	//@Column(name="MAHALLE")
	private String mahalle;
	
	//@Column(name="CADDE")
	private String cadde;
	
	//@Column(name="KAPI_NO")
	private String kapiNo;
	
	//@Column(name="KAT")
	private String kat;
	
	//@Column(name="DAIRE_NO")
	private String daireNo;
	
	//@Column(name="POSTA_KODU")
	private String postaKodu;
	
	public Adres() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adres(String sehir, String semt, String mahalle, String cadde, String kapiNo, String kat, String daireNo,
			String postaKodu) {
		super();
		this.sehir = sehir;
		this.semt = semt;
		this.mahalle = mahalle;
		this.cadde = cadde;
		this.kapiNo = kapiNo;
		this.kat = kat;
		this.daireNo = daireNo;
		this.postaKodu = postaKodu;
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

	public String getMahalle() {
		return mahalle;
	}

	public void setMahalle(String mahalle) {
		this.mahalle = mahalle;
	}

	public String getCadde() {
		return cadde;
	}

	public void setCadde(String cadde) {
		this.cadde = cadde;
	}

	public String getKapiNo() {
		return kapiNo;
	}

	public void setKapiNo(String kapiNo) {
		this.kapiNo = kapiNo;
	}

	public String getKat() {
		return kat;
	}

	public void setKat(String kat) {
		this.kat = kat;
	}

	public String getDaireNo() {
		return daireNo;
	}

	public void setDaireNo(String daireNo) {
		this.daireNo = daireNo;
	}

	public String getPostaKodu() {
		return postaKodu;
	}

	public void setPostaKodu(String postaKodu) {
		this.postaKodu = postaKodu;
	}
	

}
