package com.capgemini.flightmanagement.service;

import com.capgemini.flightmanagement.entity.Users;

public interface UserServiceInterface {

	boolean registerUser(Users users);
	
	Integer validateUser(String uname, String password);
	
}
