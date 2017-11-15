package com.project.beltprep.repositories;
import com.project.beltprep.models.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface GuildRepo extends CrudRepository<Guild,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
	List<Guild> findAll();
}
