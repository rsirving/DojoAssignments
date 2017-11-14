package com.project.auth.repositories;
import com.project.auth.models.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository 												
public interface RoleRepo extends CrudRepository<Role,Long>{
	List<Role> findAll();
	List<Role> findByName(String name);
}
