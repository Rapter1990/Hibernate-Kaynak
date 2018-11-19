package modal;

import java.util.Set;

public class Departman {

	private Long departmanId;
	private String departmanAd;
	
	private Set<Calisan> calisanlar;

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

	public Set<Calisan> getCalisanlar() {
		return calisanlar;
	}

	public void setCalisanlar(Set<Calisan> calisanlar) {
		this.calisanlar = calisanlar;
	}
	
	
	
}
