package com.crud.serviceimpl;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dto.UserDto;
import com.crud.entity.User;
import com.crud.repository.UserRepository;
import com.crud.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;

	private String generateRandomOtp() {
		Random random = new Random();
		int otp = 1000 + random.nextInt(9000);
		return String.valueOf(otp);
	}

	@Override
	public UserDto generateOtp(String email) {
		User user = userRepository.findFirstByEmail(email).orElseThrow(() -> new RuntimeException("user not" + email));
		String otp = generateRandomOtp();
		user.setOtp(otp);
		 user.setOtpGeneratedTime(LocalDateTime.now());
		User use = userRepository.save(user);

		UserDto a = this.mapper.map(use, UserDto.class);
		return a;
	}

	@Override
	public UserDto createEmployee(UserDto userdto) {
		User user = mapper.map(userdto, User.class);
		User userSaved = userRepository.save(user);
		UserDto ok = this.mapper.map(userSaved, UserDto.class);
		return ok;
	}

	@Override
	public void deleteUser(int id) {

		userRepository.deleteById(id);

	}

	@Override
	public UserDto updateUser(int id, UserDto userDto) {
		User user = userRepository.findById(id).get();
		user.setEmail(userDto.getEmail());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setName(userDto.getName());
		User save = userRepository.save(user);
		UserDto a = this.mapper.map(save, UserDto.class);
		return a;
	}

	@Override
	public List<UserDto> getAllEmployee() {
		List<User> emp = this.userRepository.findAll();
		List<UserDto> collect = emp.stream().map(user -> {
			UserDto map = this.mapper.map(user, UserDto.class);
			return map;
		}).collect(Collectors.toList());
		return collect;
	}

	@Override
	public boolean isOtpValid(String email, String otp) {
		User user = userRepository.findFirstByEmail(email).orElseThrow(() -> new RuntimeException("user not" + email));
		if (user.getOtp().equals(otp)) {
			return true;
		}
		else {
		return false;
		}

	}
//user.getOtp() != null &&
	@Override
 
	public void invalidateExpiredOtps() {
//		List<User> users = userRepository.findAll();
//		LocalDateTime now = LocalDateTime.now();
//		for (User user : users) {
//			if (user.getOtp() != null && user.getOtpGeneratedTime() != null
//					&& user.getOtpGeneratedTime().isBefore(LocalDateTime.now())) {
//				user.setOtp(null);
//    user.setOtpGeneratedTime(null);
//				 userRepository.save(user);
//			}
			
			   List<User> users = userRepository.findAll();
		        for (User user : users) {
		            if (user.getOtp() != null && user.getOtpGeneratedTime() != null) {
		                long minutes = ChronoUnit.MINUTES.between(user.getOtpGeneratedTime(), LocalDateTime.now());
		                if (minutes > 1) {
		                    user.setOtp(null);
		                    user.setOtpGeneratedTime(null);
		                    System.out.println( " time is "+user.getOtpGeneratedTime());
		                    userRepository.save(user);
			
			
			

		}
	}

}
	}
}

