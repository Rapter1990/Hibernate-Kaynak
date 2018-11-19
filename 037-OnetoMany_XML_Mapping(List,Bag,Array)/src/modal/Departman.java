package modal;

import java.util.List;

public class Departman {

	private Long departmanId;
	private String departmanAd;
	
	//private List<Calisan> calisanlar;
	private Calisan[] calisanlar;

	public Long getDepartmanId() {
		return departmanId;
	}

	public void setDepartmanId(Long departmanId) {
		this.departmanId = departmanId;
	}

	public String getDepartmanAd() {
		return departmanAd;
	}

	public void setDepartmanAd(String departmanAd) {
		this.departmanAd = departmanAd;
	}

	public Calisan[] getCalisanlar() {
		return calisanlar;
	}

	public void setCalisanlar(Calisan[] calisanlar) {
		this.calisanlar = calisanlar;
	}

	/*
	public List<Calisan> getCalisanlar() {
		return calisanlar;
	}

	public void setCalisanlar(List<Calisan> calisanlar) {
		this.calisanlar = calisanlar;
	}
	*/

	
	
}
