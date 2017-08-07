package edu.mum.tvcritics.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class TVSeries {

	@Id @GeneratedValue
	private int id;
	private String description;
	private String director;
	private String genre;
	private String studio;
	@OneToMany
	@JoinTable(name="tvseries_season")
	private List<Season> seasonList = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	public List<Season> getSeasonList() {
		return seasonList;
	}
	public void setSeasonList(List<Season> seasonList) {
		this.seasonList = seasonList;
	}
	
	
}
