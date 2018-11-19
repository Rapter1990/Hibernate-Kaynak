package magaza;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="URUN",catalog="HIBERNATECALISMAORTAMI")
public class Urun {
	
	private Long urunId;
	private String urunAdi;
	private Integer urunFiyati;
	
	public Urun() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Urun(String urunAdi, Integer urunFiyati) {
		super();
		this.urunAdi = urunAdi;
		this.urunFiyati = urunFiyati;
	}

	public Long getUrunId() {
		return urunId;
	}

	public void setUrunId(Long urunId) {
		this.urunId = urunId;
	}

	public String getUrunAdi() {
		return urunAdi;
	}

	public void setUrunAdi(String urunAdi) {
		this.urunAdi = urunAdi;
	}

	public Integer getUrunFiyati() {
		return urunFiyati;
	}

	public void setUrunFiyati(Integer urunFiyati) {
		this.urunFiyati = urunFiyati;
	}

	
	
}
