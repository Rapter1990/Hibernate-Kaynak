package modal;


public class Ders {

	private Long dersId;
	private String dersAd;
	
	///////////////////////////////////////////
	
	
	
	public Ders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Ders(String dersAd) {
		super();
		this.dersAd = dersAd;
	}



	public Long getDersId() {
		return dersId;
	}

	public void setDersId(Long dersId) {
		this.dersId = dersId;
	}

	public String getDersAd() {
		return dersAd;
	}

	public void setDersAd(String dersAd) {
		this.dersAd = dersAd;
	}
	
	
	
	
}
