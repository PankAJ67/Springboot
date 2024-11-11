package com.hrms.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.dto.EmployeeDto;
import com.hrms.entity.Employee;
import com.hrms.repo.EmployeeRepo;
import com.hrms.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private ModelMapper modelMapper;
	  
	@Autowired
	private PasswordEncoder encoder;


	@Override
	public EmployeeDto creatEmployee(MultipartFile profilePath, MultipartFile appointmentLetterPath,
			MultipartFile relivingLetterPath, MultipartFile experienceLetterPath, EmployeeDto employeeDto)
			throws IOException {

//		Employee employee = modelMapper.map(employeeDto, Employee.class);

		// profile path
		if (!profilePath.isEmpty()) {
			String profileUploadDir = "C:\\Users\\pankaj\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\HRMS_Backend\\src\\main\\resources\\static\\profilePath";

			try {
				String fileExtension = profilePath.getOriginalFilename()
						.substring(profilePath.getOriginalFilename().lastIndexOf(".") + 1);
				String filePath = profileUploadDir + File.separator + employeeDto.getAddress() + "_profilePath" + "."
						+ fileExtension;
				profilePath.transferTo(new File(filePath).toPath());

				// Set the image path in the user DTO
				employeeDto.setProfilePath(employeeDto.getAddress() + "_profilePath" + "." + fileExtension);

			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException("Failed to save the profile: " + e.getMessage());
			}
		}

		// appointmentletter path
   
		if (!appointmentLetterPath.isEmpty()) {
			String profileUploadDir = "C:\\Users\\pankaj\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\HRMS_Backend\\src\\main\\resources\\static\\appoinmentLetterPath";

			try {
				String fileExtension = appointmentLetterPath.getOriginalFilename()
						.substring(appointmentLetterPath.getOriginalFilename().lastIndexOf(".") + 1);
				String filePath = profileUploadDir + File.separator + employeeDto.getAppointmentLetterPath()
						+ "_appointmentLetterPath" + "." + fileExtension;
				appointmentLetterPath.transferTo(new File(filePath).toPath());

				// Set the image path in the user DTO
				employeeDto.setAppointmentLetterPath(filePath);

			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException("Failed to save the profile: " + e.getMessage());
			}
		}

		// reliving letter path
		if (!relivingLetterPath.isEmpty()) {
			String profileUploadDir = "C:\\Users\\pankaj\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\HRMS_Backend\\src\\main\\resources\\static\\relivingLetterPath";

			try {
				String fileExtension = relivingLetterPath.getOriginalFilename()
						.substring(relivingLetterPath.getOriginalFilename().lastIndexOf(".") + 1);
				String filePath = profileUploadDir + File.separator + employeeDto.getAddress()
						+ "_relivingLetterPath" + "." + fileExtension;
				relivingLetterPath.transferTo(new File(filePath).toPath());

				// Set the image path in the user DTO
				employeeDto
						.setRelivingLetterPath(employeeDto.getAddress() + "_relivingLetterPath" + "." + fileExtension);

			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException("Failed to save the profile: " + e.getMessage());
			}
		}

		// experienceLetterPath

		if (!experienceLetterPath.isEmpty()) {
			String profileUploadDir = "C:\\Users\\pankaj\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\HRMS_Backend\\src\\main\\resources\\static\\experienceLetterPath";

			try {
				String fileExtension = experienceLetterPath.getOriginalFilename()
						.substring(experienceLetterPath.getOriginalFilename().lastIndexOf(".") + 1);
				String filePath = profileUploadDir + File.separator + employeeDto.getAddress()						+ "_experienceLetterPath" + "." + fileExtension;
				experienceLetterPath.transferTo(new File(filePath).toPath());

				// Set the image path in the user DTO
				employeeDto.setExperienceLetterPath(
						employeeDto.getAddress() + "_experienceLetterPath" + "." + fileExtension);

			} catch (IOException e) {
				e.printStackTrace();
				throw new IOException("Failed to save the profile: " + e.getMessage());
			}
		}
	
//		
	Employee employe = modelMapper.map(employeeDto, Employee.class);
// password change 
	employe.setPassword(this.encoder.encode(employe.getEmployeeId()+"@"+employe.getFirstName()));
		this.employeeRepo.save(employe);

		 return modelMapper.map(employe, EmployeeDto.class);
	}

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDTO) {
		Employee employee = modelMapper.map(employeeDTO, Employee.class);
		employee = employeeRepo.save(employee);
		return modelMapper.map(employee, EmployeeDto.class);
	}

	@Override
	public EmployeeDto getEmployee(int Id) {
		Employee user = this.employeeRepo.findById(Id).get();
		EmployeeDto employeeDto = this.modelMapper.map(user, EmployeeDto.class);
		return employeeDto;
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> emp = this.employeeRepo.findAll();
		List<EmployeeDto> collect = emp.stream().map(employee -> {
			EmployeeDto map = this.modelMapper.map(employee, EmployeeDto.class);
			return map;
		}).collect(Collectors.toList());
		return collect;
	}

	@Override
	public void deletePost(int id) {
		this.employeeRepo.deleteById(id);

	}

	@Override
	public EmployeeDto updateEmployee(int id, EmployeeDto postRequest) {
		Employee post = employeeRepo.findById(id).get();
		post.setAddress(postRequest.getAddress());
		post.setCity(postRequest.getCity());
		post.setDateOfBirth(postRequest.getDateOfBirth());
		post.setEmailAddress(postRequest.getEmailAddress());
		post.setDepartment(postRequest.getDepartment());
		post.setMobileNumber(postRequest.getMobileNumber());
		post.setSalary(postRequest.getSalary());
		post.setOfficeLocation(postRequest.getOfficeLocation());
		post.setNationality(postRequest.getNationality());
		post.setWorkingDays(postRequest.getWorkingDays());

		Employee save = employeeRepo.save(post);
		EmployeeDto map = this.modelMapper.map(save, EmployeeDto.class);
		return map;
	}

}