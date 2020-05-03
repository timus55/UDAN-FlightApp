package com.capgemini.flightmanagement.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.flightmanagement.entity.Users;
import com.capgemini.flightmanagement.utility.GlobalResources;

@Repository
public class UserDaoImpl implements UserDaoInterface {

	@Autowired
	private EntityManager entityManager;
	
	private Logger logger = GlobalResources.getLogger(UserDaoImpl.class);
	
	@Override
	public boolean registerUser(Users users) {
	
		String methodName = "registerUser()";
		logger.info(methodName + " called");
		
		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(users);
		return true;
	}
}
