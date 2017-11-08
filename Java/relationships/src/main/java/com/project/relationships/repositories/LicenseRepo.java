package com.project.relationships.repositories;
import com.project.relationships.models.License;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface LicenseRepo extends CrudRepository<License,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
