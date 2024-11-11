package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mapping.entity.Mobile;

public interface MobileRepo  extends JpaRepository<Mobile,Integer> {

}
