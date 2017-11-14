package com.project.auth.repositories;
import com.project.auth.models.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface UserRepo extends CrudRepository<User,Long>{
	User findByUsername(String username);
}
