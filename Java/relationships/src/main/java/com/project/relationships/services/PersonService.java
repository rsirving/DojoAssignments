package com.project.relationships.services;
import com.project.relationships.models.*;
import com.project.relationships.repositories.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
	// Member variables / service initializations go here
	private PersonRepo personRepo;
	public PersonService(PersonRepo personRepo){
		this.personRepo = personRepo;
	}
	public List<Person> allPersons(){
		return personRepo.findAll();
	}
	public Person onePerson(Long id){
		return personRepo.findOne(id);
	}
	public void newPerson(Person person){
		personRepo.save(person);
	} 
	// Crud methods to act on services go here.
}
