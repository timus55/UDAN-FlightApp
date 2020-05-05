package com.capgemini.flightmanagement.dao;

import com.capgemini.flightmanagement.entity.Flights;
import com.capgemini.flightmanagement.entity.Tickets;

public interface FlightDaoInterface {

	boolean cancelFlight(Tickets bd);
	
	public Flights getFlightById(int flightId);
	
	public Tickets getBookingDetails(Integer bookindId);
	
	public void updateFlight(Flights fd);
	
}
