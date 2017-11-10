package com.project.countries.models;

import java.util.Date;
import java.util.List;

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

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Countries{
	@Id
	@GeneratedValue
	private long id;

	private String code;
	private String name;
	private String continent;
	private String region;
	private float surface_area;
	private int indep_year;
	private int population;
	private float life_expectancy;
	private float gnp;
	private float gnp_old;
	private String local_name;
	private String government_form;
	private String head_of_state;
	private int capital;
	private String code2;

	// Member variables and annotations go here.
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	// Setters and Getters go here
	
	public Countries(){

		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public float getSurface_area() {
		return surface_area;
	}
	public void setSurface_area(float surface_area) {
		this.surface_area = surface_area;
	}
	public int getIndep_year() {
		return indep_year;
	}
	public void setIndep_year(int indep_year) {
		this.indep_year = indep_year;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public float getLife_expectancy() {
		return life_expectancy;
	}
	public void setLife_expectancy(float life_expectancy) {
		this.life_expectancy = life_expectancy;
	}
	public float getGnp() {
		return gnp;
	}
	public void setGnp(float gnp) {
		this.gnp = gnp;
	}
	public float getGnp_old() {
		return gnp_old;
	}
	public void setGnp_old(float gnp_old) {
		this.gnp_old = gnp_old;
	}
	public String getLocal_name() {
		return local_name;
	}
	public void setLocal_name(String local_name) {
		this.local_name = local_name;
	}
	public String getGovernment_form() {
		return government_form;
	}
	public void setGovernment_form(String government_form) {
		this.government_form = government_form;
	}
	public String getHead_of_state() {
		return head_of_state;
	}
	public void setHead_of_state(String head_of_state) {
		this.head_of_state = head_of_state;
	}
	public int getCapital() {
		return capital;
	}
	public void setCapital(int capital) {
		this.capital = capital;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}
}
