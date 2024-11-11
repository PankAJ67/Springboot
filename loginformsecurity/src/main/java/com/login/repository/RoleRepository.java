package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.model.Role;

	
	

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	
}
