package com.project.countries.repositories;
import com.project.countries.models.*;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface CitiesRepo extends CrudRepository<Cities,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
