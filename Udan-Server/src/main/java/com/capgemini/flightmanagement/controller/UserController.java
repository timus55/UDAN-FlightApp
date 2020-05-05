package com.capgemini.flightmanagement.controller;

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


/**
 * @author Sumeet Patil Date of creation: 19/04/2020 
 * 		   This is the controller for managing services related to Users.
 * 		   This controller handels register , Login and authentication services.
 * 
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("users")
public class UserController {

	/**
	 *  Autowires the UserServiceImpl object
	 *  
	 */
	
	@Autowired
	UserServiceImpl userService;
	
	private Logger logger = GlobalResources.getLogger(UserController.class);

	
	/**
	 * This method creates and add new user in database
	 * @param users : Users 
	 * @return ResponseEntity
	 * 
	 */
	
	@PostMapping("/addUser")
	public ResponseEntity<Boolean> createUser(@RequestBody Users users)throws EntityNotFound

	{
		boolean status = userService.registerUser(users);
		if( status == false) {
			throw new EntityNotFound("user already exits");
		}
		return ResponseEntity.ok(status);

	
	}
	

	/**
	 * This method performs login operations
	 * @param uName : string
	 * @param pass : string 
	 * @return ResponseEntity
	 * 
	 */
	
	@GetMapping("/login/{uName}/{pass}")
	public ResponseEntity<Integer> login(@PathVariable String uName,@PathVariable String pass) throws EntityNotFound{
		
		String methodName = "login()";
		logger.info(methodName + " called");
		
		Integer value = userService.validateUser(uName, pass);

		return ResponseEntity.ok(value);		
	}
	

}
