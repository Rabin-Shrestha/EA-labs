package edu.mum.tvcritics.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Cast {

	@Id @GeneratedValue
	private int id;
	private String name;
	private String birthPlace;
	private String charcaterName;
	private String biography;
	@Lob
	@Column(columnDefinition = "mediumblob")
	private byte[] castImage;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getCharcaterName() {
		return charcaterName;
	}
	public void setCharcaterName(String charcaterName) {
		this.charcaterName = charcaterName;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	public byte[] getCastImage() {
		return castImage;
	}
	public void setCastImage(byte[] castImage) {
		this.castImage = castImage;
	}
	
	
}
