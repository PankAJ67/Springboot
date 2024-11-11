package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.entity.Emp;

@Repository
public interface EmpRepo  extends JpaRepository<Emp,Integer>{

}
