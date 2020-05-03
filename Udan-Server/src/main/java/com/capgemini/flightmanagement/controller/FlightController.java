package com.capgemini.flightmanagement.controller;

import java.util.ArrayList;
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

import com.capgemini.flightmanagement.entity.Flights;
import com.capgemini.flightmanagement.entity.Tickets;
import com.capgemini.flightmanagement.entity.Users;
import com.capgemini.flightmanagement.exception.EntityNotFound;
import com.capgemini.flightmanagement.service.FlightServiceImpl;
import com.capgemini.flightmanagement.utility.GlobalResources;;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("flights")
public class FlightController {

	@Autowired
	FlightServiceImpl flightService;
	
	private Logger logger = GlobalResources.getLogger(FlightController.class);

	

	@GetMapping("/getBokking/{bookId}")
	public ResponseEntity<Tickets> getSingleBooking(@PathVariable Integer bookID) {
		String methodName = "getSingleBooking()";
		logger.info(methodName + " called");
		
		Tickets tickets = flightService.getBooking(bookID);
		
		return ResponseEntity.ok(tickets);
	}
	
	
	@GetMapping("/searchFlight/{source}/{dest}")
	public ResponseEntity<List<Flights>> searchFlight(@PathVariable String source,@PathVariable String dest)
	{
		String methodName = "searchFlight()";
		logger.info(methodName + " called");
		
		List <Flights> flights = flightService.searchFlight(source, dest);
		
		return ResponseEntity.ok(flights);
	}
	
	@GetMapping("/all/{userid}")
	public ResponseEntity<List<Tickets>> getBookings(@PathVariable Integer userid)
	{
		String methodName = "getBookings()";
		logger.info(methodName + " called");
		
		List <Tickets> tickets = flightService.viewTickets(userid);
		

		return ResponseEntity.ok(tickets);
		
	}
	
	@GetMapping("/bookFlight/{flightId}/{userId}")
	public Integer bookFlight(@PathVariable Integer flightId,@PathVariable Integer userId)
	{
		String methodName = "bookFlight()";
		logger.info(methodName + " called");
		
		return flightService.bookFlight(flightId, userId);
	}
	
	@GetMapping("/cancelFlight/{bookingId}")
	public ResponseEntity cancelFlight(@PathVariable Integer bookingId)
	{
		String methodName = "cancelFlight()";
		logger.info(methodName + " called");
		
		boolean status = flightService.cancelFlight(bookingId);
		return ResponseEntity.ok(status);
	}	
}
