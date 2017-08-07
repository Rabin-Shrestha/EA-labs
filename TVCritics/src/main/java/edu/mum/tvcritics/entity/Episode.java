package edu.mum.tvcritics.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Episode {
	
	@Id @GeneratedValue
	private int id;
	private Date airedDate;
	private String comment;
	private float rating;
	private String description;
	@OneToMany
	@JoinTable(name="edisode_cast")
	private List<Cast> castList = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getAiredDate() {
		return airedDate;
	}
	public void setAiredDate(Date airedDate) {
		this.airedDate = airedDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Cast> getCastList() {
		return castList;
	}
	public void setCastList(List<Cast> castList) {
		this.castList = castList;
	}
}
