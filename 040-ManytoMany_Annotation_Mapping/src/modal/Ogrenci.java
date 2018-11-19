package modal;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="OGRENCI")
public class Ogrenci implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OGRENCI_SEQ")
	@SequenceGenerator(name="OGRENCI_SEQ", sequenceName="OGRENCI_SEQ", allocationSize=1)
	@Column(name="OGRENCI_ID")
	private Integer id;
	
	@Column(name="OGRENCI_AD")
	private String ad;
	
	@Column(name="OGRENCI_SOYAD")
	private String soyad;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="OGRENCI_DERS",
			   joinColumns= {@JoinColumn(name="OGRENCI_ID")},
			   inverseJoinColumns = {@JoinColumn(name="DERS_ID")}
			)
	private Set<Ders> dersler = new HashSet<Ders>(0);
	
	public Ogrenci() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ogrenci(String ad, String soyad, Set<Ders> dersler) {
		super();
		this.ad = ad;
		this.soyad = soyad;
		this.dersler = dersler;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public Set<Ders> getDersler() {
		return dersler;
	}

	public void setDersler(Set<Ders> dersler) {
		this.dersler = dersler;
	}

	
}
