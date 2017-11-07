package com.project.languages.repositories;
import com.project.languages.models.Language;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface LanguageRepository extends CrudRepository<Language, Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
	List<Language> findAll();
}
