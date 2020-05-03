package com.capgemini.flightmanagement.service;

import java.util.List;

import com.capgemini.flightmanagement.entity.*;

public interface FlightServiceInterface {
	
	Integer bookFlight(int flightid,Integer userid);
	
	boolean cancelFlight(Integer bookid);
	
	List<Flights> searchFlight(String source,String dest);
	
	List<Tickets> viewTickets(int userid);

	Tickets getBooking(Integer bookId);
}
