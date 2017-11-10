package com.project.countries.repositories;
import com.project.countries.models.*;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface CountriesRepo extends CrudRepository<Countries,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
	@Query("SELECT d FROM Countries c JOIN c.languages l WHERE l.")
}
