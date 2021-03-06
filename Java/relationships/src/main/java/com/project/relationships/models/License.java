package com.project.relationships.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licenses")
public class License {
    
    @Id
    @GeneratedValue
	private Long id;
	
	private String number;
    private String expirationDate;
    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;

	public License() { }
	public License(String number, String expirationDate, String state){
		this.expirationDate = expirationDate;
		this.state = state;
	}
	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getExpirationDate(){
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate){
		this.expirationDate = expirationDate;
	}
	public String getState(){
		return state;
	}
	public void setState(String state){
		this.state = state;
	}
	public Person getPerson(){
		return person;
	}
	public void setPerson(Person person){
		this.person = person;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	// Setters and Getters go here

}
