package com.capgemini.flightmanagement.controller;

import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.flightmanagement.entity.Flights;
import com.capgemini.flightmanagement.entity.Tickets;
import com.capgemini.flightmanagement.exception.EntityNotFound;
import com.capgemini.flightmanagement.service.FlightServiceImpl;
import com.capgemini.flightmanagement.utility.GlobalResources;;


/**
 * @author Sumeet Patil Date of creation: 19/04/2020 
 * 		   This is the controller for managing services related to Flights.
 * 		   This controller handels search book and cancel flights services
 * 		   and it also returns the bookings of the user	
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("flights")
public class FlightController {

	
	/**
	 *  Autowires the FlightServiceImpl object
	 *  
	 */
	@Autowired
	FlightServiceImpl flightService;
	
	private Logger logger = GlobalResources.getLogger(FlightController.class);

	/**
	 * This method returns the single Booking given bookingId
	 * @param bookId : boolean 
	 * @return ResponseEntity<Tickets>
	 * 
	 */

	@GetMapping("/getBokking/{bookId}")
	public ResponseEntity<Tickets> getSingleBooking(@PathVariable Integer bookID)throws EntityNotFound
	{
		String methodName = "getSingleBooking()";
		logger.info(methodName + " called");
		
		Tickets tickets = flightService.getBooking(bookID);
		
		return ResponseEntity.ok(tickets);
	}
	
	/**
	 * This method searches flights for particular source and destination
	 * @param source : String
	 * @param destination : String
	 * @return  ResponseEntity<Flights>
	 * 
	 */
	
	@GetMapping("/searchFlight/{source}/{dest}")
	public ResponseEntity<List<Flights>> searchFlight(@PathVariable String source,@PathVariable String dest) throws EntityNotFound
	{
		String methodName = "searchFlight()";
		logger.info(methodName + " called");
		
		List <Flights> flights = flightService.searchFlight(source, dest);
		
		return ResponseEntity.ok(flights);
	}
	
	/**
	 * This method returns all the booking for particular user
	 * @param userId : Integer
	 * @return Tickets : ResponseEntity<List<Tickets>>
	 * 
	 */
	
	@GetMapping("/all/{userid}")
	public ResponseEntity<List<Tickets>> getBookings(@PathVariable Integer userid)throws EntityNotFound
	{
		String methodName = "getBookings()";
		logger.info(methodName + " called");
		
		List <Tickets> tickets = flightService.viewTickets(userid);
		

		return ResponseEntity.ok(tickets);
		
	}
	
	
	/**
	 * This method books flights for given userid and flightid
	 * @param flightid : Integer
	 * @param userId : Integer
	 * @return status : Integer 
	 * 
	 */
	
	@GetMapping("/bookFlight/{flightId}/{userId}")
	public Integer bookFlight(@PathVariable Integer flightId,@PathVariable Integer userId)throws EntityNotFound
	{
		String methodName = "bookFlight()";
		logger.info(methodName + " called");
		
		return flightService.bookFlight(flightId, userId);
	}
	
	
	/**
	 * This method cancels boooked flight for given booking Id
	 * @param flightid : Integer
	 * @param userId : Integer
	 * @return Response Entity : Integer 
	 * 
	 */
	
	@GetMapping("/cancelFlight/{bookingId}")
	public ResponseEntity<Boolean> cancelFlight(@PathVariable Integer bookingId)
	{
		String methodName = "cancelFlight()";
		logger.info(methodName + " called");
		
		boolean status = flightService.cancelFlight(bookingId);
		return ResponseEntity.ok(status);
	}	
}
