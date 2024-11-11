package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.FileItem;



@Repository
public interface FileItemRepository  extends JpaRepository<FileItem ,Integer>{
}
