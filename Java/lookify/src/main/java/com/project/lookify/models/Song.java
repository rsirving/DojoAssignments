package com.project.lookify.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Song{
	@Id
	@GeneratedValue
	private long id;

	@Column
	@Size(min=5)
	@NotNull
	private String title;

	@Column
	@Size(min=5)
	@NotNull
	private String artist;

	@Column
	@NotNull
	private int rating;
	// Member variables and annotations go here.

	public Song(){}
	
	public Song(String title, String artist, int rating){
		this.title = title;
		this.artist = artist;
		this.rating = rating;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getArtist(){
		return artist;
	}
	public void setArtist(String artist){
		this.artist = artist;
	}
	public int getRating(){
		return rating;
	}
	public void setRating(int rating){
		this.rating = rating;
	}
	
	// Setters and Getters go here

}
