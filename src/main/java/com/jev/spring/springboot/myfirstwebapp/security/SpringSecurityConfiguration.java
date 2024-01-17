package com.jev.spring.springboot.myfirstwebapp.security;
import static org.springframework.security.config.Customizer.withDefaults;
import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
//LDAP or Database
	// In Memory

//	InMemoryUserDetailsManager
//	InMemoryUserDetailsManager(UserDetails... users)

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		
		UserDetails user1 = createNewUser("jev","zxcvbnm");
		UserDetails user2 = createNewUser("ranga","dummy");
		
		return new InMemoryUserDetailsManager(user1,user2);
	}

private UserDetails createNewUser(String username,String password) {
	Function<String, String> encoder = input -> passwordEncoder().encode(input);
	UserDetails user = User.builder()
						.passwordEncoder(encoder)
						.username(username)
						.password(password)
						.roles("USER").build();
	return user;
}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	
	//all urls are protected
	//a login form is shown for unauthorized requests
	//CSRF disable
	//config - frames are allowed 
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(
				auth->auth.anyRequest().authenticated());
		http.formLogin(withDefaults());
		http.csrf().disable();
		http.headers().frameOptions().disable();
		
		
		return http.build();
		
	}
}
