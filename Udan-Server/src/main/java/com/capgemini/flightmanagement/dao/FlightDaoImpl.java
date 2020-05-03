package com.capgemini.flightmanagement.dao;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.flightmanagement.entity.Flights;
import com.capgemini.flightmanagement.entity.Tickets;
import com.capgemini.flightmanagement.entity.Users;
import com.capgemini.flightmanagement.service.FlightServiceImpl;
import com.capgemini.flightmanagement.utility.GlobalResources;

@Repository
public class FlightDaoImpl implements FlightDaoInterface {
	
	@Autowired
	private EntityManager entityManager;
	
	private Logger logger = GlobalResources.getLogger(FlightDaoImpl.class);

	public FlightDaoImpl() {
		
	}

	@Override
	public void updateFlight(Flights fd) {
		
		String methodName = "updateFlight()";
		logger.info(methodName + " called");
		
		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(fd);	
	}

	@Override
	public Tickets getBookingDetails(Integer bookindId)
	{
		String methodName = "getBookingDetails()";
		logger.info(methodName + " called");
		
		return entityManager.find(Tickets.class, bookindId);
	}


	@Transactional
	public boolean addBooking(Tickets bd)
	{
		String methodName = "addBooking()";
		logger.info(methodName + " called");
		
		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(bd);
		return true;
	}

	@Override
	public Flights getFlightById(int flightId) {		
		
		String methodName = "getFlightById()";
		logger.info(methodName + " called");
		
		return entityManager.find(Flights.class, flightId);
	}

	@Override
	public boolean cancelFlight(Tickets bd) {
		
		String methodName = "cancelFlight()";
		logger.info(methodName + " called");
		
		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(bd);
		cs.delete(bd);
		return true;
	}
}
