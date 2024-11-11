package com.forgotpassword.service.IMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;



@Service
public class EmailService {

	@Autowired
	private final JavaMailSender javaMailSender;
	
	

	public EmailService(JavaMailSender javaMailSender) {
		
	 	
			this.javaMailSender= javaMailSender;
		}
	
	
	 public void sendEmail(String to,String subject , String body)
	 {
		 try {
			 
			 MimeMessage message = javaMailSender.createMimeMessage(); 
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom("pankajkumarsahu047@gmail.com");
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body , true);
		javaMailSender.send(message);
		  System.out.println("sent successfully ");
		
		 }
		 
		  catch(Exception e )
		 {
			  e.printStackTrace();
			  e.getMessage();
			  System.out.println("ok1");
			  throw new RuntimeException(e);
			  
			  
		 }
	 
	
	 
	 
	}
}
