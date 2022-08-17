package com.example.amit;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{

	private String userName;
	private String userPassword;
	private boolean isActive;
	private List<GrantedAuthority> userRoles;  
	
	public MyUserDetails(User user)
	{
		this.userName=user.getUserName();
        this.userPassword=user.getUserpassword();
        this.isActive=user.isActive();
        this.userRoles=Arrays.stream(user.getUserRole().split(","))
        		.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        
        
	}
	
	public MyUserDetails(String userName)
	{
		
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return  userRoles;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return  userPassword;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return  true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return  true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
