package com.hrms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.dto.ProjectDto;
import com.hrms.entity.Project;

@Repository
public interface ProjectRepo   extends JpaRepository<Project , Long>{



}