package com.project.dojosninjas.repositories;
import com.project.dojosninjas.models.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface DojoRepo extends CrudRepository<Dojo,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
	Dojo findOne();
}
