package com.forgotpassword.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forgotpassword.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer > {

//	Users findByEmail();
Users findByEmail(String email);
	

}
