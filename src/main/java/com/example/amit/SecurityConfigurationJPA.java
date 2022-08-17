package com.example.amit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfigurationJPA extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder getInstancePassword() {
		return NoOpPasswordEncoder.getInstance();

	}

	public void configure(HttpSecurity http)  throws Exception{
		http.httpBasic().and().authorizeRequests().antMatchers("/home").hasAnyRole("USER", "ADMIN").antMatchers("/user")
				.hasRole("USER").antMatchers("/admin").hasRole("ADMIN").and().formLogin();
	}

}
 	