package com.jev.spring.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String password ) {
		
		boolean isValidUsername = username.equalsIgnoreCase("jev");
		boolean isValidPassword = password.equalsIgnoreCase("zxcvbnm");		
		
		return isValidUsername && isValidPassword;
	}

}
