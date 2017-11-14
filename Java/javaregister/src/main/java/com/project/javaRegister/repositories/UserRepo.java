package com.project.javaRegister.repositories;
import com.project.javaRegister.models.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface UserRepo extends CrudRepository<User,Long>{
	// Query methods go here.
	
	// Example:
	// public YourModelHere findByName(String name);
	User findByEmail(String email);
}
