package com.example.amit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	
	@GetMapping("/home")
	public String home()
	{
		return "Welcome to home!!! ;)";
	}
	
	
	@GetMapping("/user")
	public String user()
	{
		return "Welcome user";
	}
	
	@GetMapping("/admin")
	public String admin()
	{
		return "Welcome admin";
	}
	
}
