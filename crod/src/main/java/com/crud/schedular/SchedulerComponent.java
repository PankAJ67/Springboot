package com.crud.schedular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.crud.service.UserService;


@Component
public class SchedulerComponent {

	
	 @Autowired
	    private UserService userService;


	    @Scheduled(fixedRate = 80000) // Run every 1 minute
	    public void invalidateExpiredOtps() {
	        userService.invalidateExpiredOtps();
	    }

	   
}
