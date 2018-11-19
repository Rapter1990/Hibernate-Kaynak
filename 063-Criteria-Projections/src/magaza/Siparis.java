package magaza;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SIPARIS",catalog="HIBERNATECALISMAORTAMI")
public class Siparis {

	private Long siparisId;
	private long siparisurunId;
	private String siparisurunAdi;
	private double siparisurunFiyati;
	
	public Siparis() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Siparis(long siparisurunId, String siparisurunAdi, double siparisurunFiyati) {
		super();
		this.siparisurunId = siparisurunId;
		this.siparisurunAdi = siparisurunAdi;
		this.siparisurunFiyati = siparisurunFiyati;
	}

	public Long getSiparisId() {
		return siparisId;
	}

	public void setSiparisId(Long siparisId) {
		this.siparisId = siparisId;
	}

	public long getSiparisurunId() {
		return siparisurunId;
	}

	public void setSiparisurunId(long siparisurunId) {
		this.siparisurunId = siparisurunId;
	}

	public String getSiparisurunAdi() {
		return siparisurunAdi;
	}

	public void setSiparisurunAdi(String siparisurunAdi) {
		this.siparisurunAdi = siparisurunAdi;
	}

	public double getSiparisurunFiyati() {
		return siparisurunFiyati;
	}

	public void setSiparisurunFiyati(double siparisurunFiyati) {
		this.siparisurunFiyati = siparisurunFiyati;
	}
	
	
}
