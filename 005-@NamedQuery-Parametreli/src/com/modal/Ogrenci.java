package com.modal;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Ogrenci database table.
 * 
 */
@Entity
@NamedQueries({
		
	@NamedQuery(name = "secilenOgrenciKayitlariniGetir", query = "Select ogr From Ogrenci ogr WHERE ogr.id = :p_id"),
	
	@NamedQuery(name = "ogrenciAdiVeSoyadi", query = "Select ogr From Ogrenci ogr WHERE ogr.adi = :p_adi AND ogr.soyadi =:p_soyad"),
		
	@NamedQuery(name = "tumOgrenciKayitlariniGetir", query = "Select ogr FROM Ogrenci ogr") 
})
public class Ogrenci implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int id;

	@Column(name="Adi")
	private String adi;

	@Column(name="Bolum")
	private String bolum;

	@Column(name="Fakulte")
	private String fakulte;

	@Column(name="No")
	private String no;

	@Column(name="Soyadi")
	private String soyadi;

	public Ogrenci() {
	}
	
	

	public Ogrenci(String adi, String bolum, String fakulte, String no, String soyadi) {
		super();
		this.adi = adi;
		this.bolum = bolum;
		this.fakulte = fakulte;
		this.no = no;
		this.soyadi = soyadi;
	}



	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdi() {
		return this.adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getBolum() {
		return this.bolum;
	}

	public void setBolum(String bolum) {
		this.bolum = bolum;
	}

	public String getFakulte() {
		return this.fakulte;
	}

	public void setFakulte(String fakulte) {
		this.fakulte = fakulte;
	}

	public String getNo() {
		return this.no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getSoyadi() {
		return this.soyadi;
	}

	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}

}