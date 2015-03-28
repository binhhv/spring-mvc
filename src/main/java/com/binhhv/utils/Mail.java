package com.binhhv.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.binhhv.model.User;
@Component
public class Mail {
	@Autowired
    private MailSender mailSender;
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	public void sendMail(User user) throws IOException{
		SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("Action Required to Activate Membership");
        email.setText(getPropValues("mail.register.properties", user.getUsername(), "http://localhost:8083/teoti/user/register.html?code="+user.getConfirm_code()));
        mailSender.send(email);
	}
	public String getPropValues(String propFileName,String username,String link) throws IOException {
		 
		String result = "";
		Properties prop = new Properties();
 
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
 
		
		
		// get the property value and print it out
		result += prop.getProperty("body-title");
		result += prop.getProperty("body-message");
		result += prop.getProperty("body-message-active");
		result += prop.getProperty("body-message-confirm");
		result += prop.getProperty("body-message-link");
		result += prop.getProperty("body-end");
 
		result= result.replace("%/username%/", username);
		result= result.replace("%/link%/", link);
		return result;
	}
}
