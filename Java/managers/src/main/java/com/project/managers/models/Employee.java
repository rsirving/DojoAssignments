package com.project.managers.models;

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
public class Employee{
	@Id
	@GeneratedValue
	private long id;

	private String firstName;
	private String lastName;

	@ManyToOne(fetch=FetchType.LAZY)
	private Employee manager;

	@OneToMany(mappedBy="manager", fetch=FetchType.LAZY)
	private List<Employee> employees;

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
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public Employee getManager(){
		return manager;
	}
	public void setManager(Employee manager){
		this.manager = manager;
	}
	public List<Employee> getEmployees(){
		return employees;
	}
	public void setEmployees(List<Employee> employees){
		this.employees = employees;
	}
	
	// Setters and Getters go here

	public Employee(){}
	
	public Employee(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
}
