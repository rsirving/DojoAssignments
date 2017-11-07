package com.project.boots.repositories;
import com.project.boots.models.Boot;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface BootRepository extends CrudRepository<Boot,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
	List<Boot> findAll();
}
