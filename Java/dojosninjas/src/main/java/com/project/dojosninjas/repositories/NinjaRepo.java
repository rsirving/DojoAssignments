package com.project.dojosninjas.repositories;
import com.project.dojosninjas.models.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface NinjaRepo extends CrudRepository<Ninja,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
	@Query("select n from Ninja n where n.dojo = ?1")
	List<Ninja> findByDojo(Long id);
}
