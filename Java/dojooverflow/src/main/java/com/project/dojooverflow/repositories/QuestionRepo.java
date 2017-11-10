package com.project.dojooverflow.repositories;
import com.project.dojooverflow.models.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface QuestionRepo extends CrudRepository<Question,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
	List<Question> findAll();
	Question findById(Long id);
}
