package com.sendmail;



import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;

	private String generateOTP()
	{	Random random = new Random();
	 int otpValue= 100000+ random.nextInt(900000);
	return String.valueOf(otpValue);
	} 
	
	public void SendEmail(String toEmail , String  subject ,String   body )
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("pankajkumarsahu047@gmail.com");
		message.setText(body);
		message.setSubject(subject);
		message.setTo(toEmail);
		mailSender.send(message);
		System.out.println("mail sent successfully");
	
	}

	
	
	
	
	
	
	
}
