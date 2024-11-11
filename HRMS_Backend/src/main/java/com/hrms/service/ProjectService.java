package com.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrms.dto.ProjectDto;

@Service
public interface ProjectService {

	public ProjectDto createProject(ProjectDto projectdto);

	public ProjectDto getProject(long Id);

	List<ProjectDto> getAllProject();

	void deleteProject(long id);

	public ProjectDto updateProject(long id, ProjectDto project);

}
