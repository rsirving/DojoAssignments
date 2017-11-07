package com.project.languages.models;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.*;

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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Language{

	@Size(min=2, max=20)
	@NotEmpty
	private String name;

	@Size(min=2, max=20)
	@NotEmpty
	private String creator;

	@NotEmpty
	private String version;
	
	// Setters and Getters go here	
	public Language(){

	}
	public Language(String name, String creator, String version){
		this.name = name;
		this.creator = creator;
		this.version = version;		
	}

	public String getName(){
		return name;
	}
	public String getCreator(){
		return creator;
	}
	public String getVersion(){
		return version;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setCreator(String creator){
		this.creator = creator;
	}
	public void setVersion(String version){
		this.version = version;
	}
}
