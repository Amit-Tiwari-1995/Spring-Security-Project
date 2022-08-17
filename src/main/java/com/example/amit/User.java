package com.example.amit;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "User")
public class User
{
	
	@Id
	private int id;
	private String userName;
	private String userpassword;
	private String userRole;
	private boolean isActive;
	
}