package com.hrms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dto.ProjectDto;
import com.hrms.entity.Project;
import com.hrms.repo.ProjectRepo;
import com.hrms.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepo projectRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProjectDto createProject(ProjectDto projectdto) {

		Project project = modelMapper.map(projectdto, Project.class);
		projectRepository.save(project);
		return modelMapper.map(project, ProjectDto.class);

	}

	@Override
	public List<ProjectDto> getAllProject() {
		List<Project> emp = projectRepository.findAll();
		List<ProjectDto> collect = emp.stream().map(project -> {
			ProjectDto map = this.modelMapper.map(project, ProjectDto.class);
			return map;
		}).collect(Collectors.toList());
		return collect;
	}

	@Override
	public ProjectDto getProject(long Id) {
		Project user = projectRepository.findById(Id).get();
		ProjectDto a = modelMapper.map(user, ProjectDto.class);
		return a;

	}

	@Override
	public void deleteProject(long id) {

		projectRepository.deleteById(id);

	}

	@Override
	public ProjectDto updateProject(long id, ProjectDto project) {
		Project poost = projectRepository.findById(id).get();

		poost.setCompanyName(project.getCompanyName());
		poost.setCustomerName(project.getCustomerName());
		poost.setDescription(project.getDescription());
		poost.setEmailId(project.getEmailId());
		poost.setFinishDate(project.getFinishDate());
		poost.setPhoneNumber(project.getPhoneNumber());
		poost.setProjectTitle(project.getProjectTitle());
		poost.setSkillRequired(project.getSkillRequired());
		poost.setTechnologyUsed(project.getTechnologyUsed());
		poost.setProjectStatus(project.getProjectStatus());
		poost.setTeamSize(project.getTeamSize());

		Project save = projectRepository.save(poost);
		ProjectDto b = this.modelMapper.map(save, ProjectDto.class);
		return b;
	}

}
