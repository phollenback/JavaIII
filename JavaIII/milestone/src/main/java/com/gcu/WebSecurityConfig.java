package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gcu.business.UserBusinessService;

@Configuration
public class WebSecurityConfig 
{
	private UserBusinessService service;

	@Autowired
	public void setService(UserBusinessService service) {
	    this.service = service;
	}

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
	{
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/", "/images/**", "/service/**", "/signup", "/doSignUp").permitAll()
					.anyRequest().authenticated())
			.formLogin(form -> form
					.loginPage("/login")
					.usernameParameter("username")
					.passwordParameter("password")
					.permitAll()
					.defaultSuccessUrl("/", true))
			.logout(lo -> lo
					.logoutUrl("/logout")
					.invalidateHttpSession(true)
					.clearAuthentication(true)
					.permitAll()
					.logoutSuccessUrl("/"));
		
		
		return http.build();
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth
		.userDetailsService(service)
		.passwordEncoder(passwordEncoder());
	}
	
	 private PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
}