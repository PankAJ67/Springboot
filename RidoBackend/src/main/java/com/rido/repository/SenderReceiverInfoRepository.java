package com.rido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rido.entity.SenderReceiverInfo;

@Repository
public interface SenderReceiverInfoRepository extends JpaRepository<SenderReceiverInfo, Long>{

}
