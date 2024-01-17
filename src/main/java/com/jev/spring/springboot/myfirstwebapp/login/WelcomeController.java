package com.jev.spring.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {
	
//	private AuthenticationService authenticationService ;
//
//	public LoginController(AuthenticationService authenticationService) {
//		super();
//		this.authenticationService = authenticationService;
//	}

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	///login => com.in28minutes.springboot.myfirstwebapp.login.LoginController => login.jsp
	
		//http://localhost:8080/login?name=Ranga
		//Model
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String gotoLoginPage(ModelMap map) {
		map.put("name",getLoggedInUsername());		//here we pass the name attribute by model method
		return "welcome";
	}
	
	private String getLoggedInUsername() {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}

	
//ALL THIS CODE IS NOT REQUIRED WHEN YOU ADD SPRIING SECURITY TO THE POM	
//	@RequestMapping(value="login", method=RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name, 
//			@RequestParam String password, ModelMap map) {
//		
//		if(authenticationService.authenticate(name, password)) {
//			map.put("name",name);
//			map.put("password", password);
//			
//			return "welcome";
//		}
//		
//		map.put("erroeMessage", "Invalid cred!");
//		return "login";
//	}

	
	
	
	
//	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
//		model.put("name", name);  //name of the attritute "name" and the value is name.
//		
//		logger.debug("Request param is logger debug {}",name);  //this won't be printed if prop file has info level logger defined
//		logger.info("Request param is logger info {}",name);
//		System.out.println("Request param is " + name); //NOT RECOMMENDED FOR PROD CODE
//		return "login";
	

}
