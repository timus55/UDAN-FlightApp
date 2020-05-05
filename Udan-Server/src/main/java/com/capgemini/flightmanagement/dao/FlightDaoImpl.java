package com.capgemini.flightmanagement.dao;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.capgemini.flightmanagement.entity.Flights;
import com.capgemini.flightmanagement.entity.Tickets;
import com.capgemini.flightmanagement.exception.EntityNotFound;
import com.capgemini.flightmanagement.utility.GlobalResources;


/**
 * @author	Sumeet Patil Date of creation: 19/04/2020 
 * 			This class is repository of the project which deals with Flight operations.
 * 			All the database relation update create operations are performed here.  
 * 
 */

@Repository
public class FlightDaoImpl implements FlightDaoInterface {
	
	/*
	 * Autowires the EntityManager object
	 */
	@Autowired
	private EntityManager entityManager;
	
	private Logger logger = GlobalResources.getLogger(FlightDaoImpl.class);

	public FlightDaoImpl() {
		
	}

	/**
	 * This method saves or update flight operations
	 * @param flights Object of Flights
	 * 
	 */
	@Override
	public void updateFlight(Flights flights)throws EntityNotFound 
	{
		
		String methodName = "updateFlight()";
		logger.info(methodName + " called");
		
		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(flights);	
	}

	/**
	 * This method returns the data of object corresponding to given bookingId
	 * @param bookingId 
	 */
	@Override
	public Tickets getBookingDetails(Integer bookingdId)throws EntityNotFound
	{
		String methodName = "getBookingDetails()";
		logger.info(methodName + " called");
		
		return entityManager.find(Tickets.class, bookingdId);
	}

	/**
	 * This method returns the boolean value if booking is successsfull.
	 * @param bookingId 
	 * @return boolean
	 * 
	 */
	
	@Transactional
	public boolean addBooking(Tickets bd)throws EntityNotFound
	{
		String methodName = "addBooking()";
		logger.info(methodName + " called");
		
		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(bd);
		return true;
	}

	/**
	 * This method returns the flights given flighId
	 * @param bookingId 
	 * @return flightId
	 * 
	 */
	
	@Override
	public Flights getFlightById(int flightId)throws EntityNotFound
	{		
		
		String methodName = "getFlightById()";
		logger.info(methodName + " called");
		
		return entityManager.find(Flights.class, flightId);
	}

	/**
	 * This method returns boolean if object is deleted or not.
	 * @param bookingId 
	 * @return boolean
	 * 
	 */
	
	@Override
	public boolean cancelFlight(Tickets bd) throws EntityNotFound
	{
		
		String methodName = "cancelFlight()";
		logger.info(methodName + " called");
		
		Session cs = entityManager.unwrap(Session.class);
		cs.saveOrUpdate(bd);
		cs.delete(bd);
		return true;
	}
}
