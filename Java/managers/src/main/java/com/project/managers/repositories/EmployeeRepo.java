package com.project.managers.repositories;
import com.project.managers.models.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface EmployeeRepo extends CrudRepository<Employee,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
}
