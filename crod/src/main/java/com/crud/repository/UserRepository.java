package com.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.entity.User;

	@Repository
	public interface UserRepository extends JpaRepository<User,Integer> {


		 Optional <User> findFirstByEmail(String email);
		

		
}
