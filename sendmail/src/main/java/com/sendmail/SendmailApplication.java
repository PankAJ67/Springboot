package com.sendmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SendmailApplication {

	@Autowired
	private EmailSenderService senderService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(SendmailApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void sendMail()
	{
		senderService.SendEmail("pankajkumarsahu047@gmail.com", "otpsent  ", "otpValue");
	}
	
	
	
	
	
	
	
}
