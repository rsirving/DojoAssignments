package com.project.relationships.repositories;
import com.project.relationships.models.Person;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface PersonRepo extends CrudRepository<Person,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
	List<Person> findAll();
}
