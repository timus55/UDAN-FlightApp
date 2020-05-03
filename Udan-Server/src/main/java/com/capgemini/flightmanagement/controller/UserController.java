package com.capgemini.flightmanagement.controller;

import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flightmanagement.entity.Users;
import com.capgemini.flightmanagement.exception.EntityNotFound;
import com.capgemini.flightmanagement.service.UserServiceImpl;
import com.capgemini.flightmanagement.utility.GlobalResources;;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserServiceImpl userService;
	
	private Logger logger = GlobalResources.getLogger(UserController.class);

	
	@PostMapping("/addUser")
	public ResponseEntity createUser(@RequestBody Users users)

	{
		boolean status = userService.registerUser(users);
		if( status == false) {
			throw new EntityNotFound("user already exits");
		}
		return ResponseEntity.ok(status);

	
	}
	

	
	@GetMapping("/login/{uName}/{pass}")
	public ResponseEntity login(@PathVariable String uName,@PathVariable String pass) {
		
		String methodName = "login()";
		logger.info(methodName + " called");
		
		Integer value = userService.validateUser(uName, pass);

		return ResponseEntity.ok(value);		
	}
	

}
