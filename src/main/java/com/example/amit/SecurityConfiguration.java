package com.example.amit;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	public void configure(AuthenticationManagerBuilder auth) throws  Exception {
		auth.inMemoryAuthentication().withUser("amit").password("amit").roles("USER").and().withUser("ajay")
				.password("ajay").roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder getInstancePassword()
	{
		  return NoOpPasswordEncoder.getInstance();
	}

}
