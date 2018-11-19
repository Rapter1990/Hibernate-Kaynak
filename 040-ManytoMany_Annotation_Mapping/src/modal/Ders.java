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
@Table(name="DERS")
public class Ders implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DERS_SEQ")
	@SequenceGenerator(name="DERS_SEQ", sequenceName="DERS_SEQ", allocationSize=1)
	@Column(name="DERS_ID")
	private Long dersId;
	
	@Column(name="DERS_AD",nullable = false)
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
