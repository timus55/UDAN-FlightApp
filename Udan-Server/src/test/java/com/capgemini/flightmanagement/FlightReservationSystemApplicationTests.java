package com.capgemini.flightmanagement;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.capgemini.flightmanagement.dao.FlightDaoImpl;
import com.capgemini.flightmanagement.entity.Flights;
import com.capgemini.flightmanagement.entity.Tickets;
import com.capgemini.flightmanagement.entity.Users;
import com.capgemini.flightmanagement.service.FlightServiceImpl;
import com.capgemini.flightmanagement.service.UserServiceImpl;
import com.capgemini.flightmanagement.utility.GlobalResources;

@SpringBootTest
class FlightReservationSystemApplicationTests {

	@Test
	void contextLoads() {
	}

private static Logger logger = GlobalResources.getLogger(FlightReservationSystemApplicationTests.class);
	
	@Autowired
	FlightServiceImpl flightService;
	
	@Autowired
	UserServiceImpl userService;

	
	@BeforeAll
	static void setUpBeforeClass() {
		logger.info("SetUpClass called");
	}
	
	@BeforeEach
	void setup() {
		logger.info("Test Case Started");
		System.out.println("Test Case Started");
	}
	
	@AfterEach
	void tearDown() {
		logger.info("Test Case Over");
		System.out.println("Test Case Over");
	}
	
	@Test
	@DisplayName("User LoggedIn successfully")
	@Rollback(true)
	public void loginTest() {
		String methodName = "login()";
		logger.info(methodName + " called");
		
		Integer value = userService.validateUser("dishu17","Pass123");
		assertNotEquals(0, value);
	}
	
	@Test
	@DisplayName("User LoggedIn successfully 2")
	@Rollback(true)
	public void loginTest2() {
		String methodName = "login()";
		logger.info(methodName + " called");
		
		Integer value = userService.validateUser("snep55","Pass123");
		assertEquals(2, value);
	}
	
	@Test
	@DisplayName("Book Flight")
	@Rollback(true)
	public void bookFlight() {
		
		assertEquals(true, flightService.bookFlight(2,1));
	
	}
	
	@Test
	@DisplayName("User created successfully")
	@Rollback(true)
	public void createUser() {
		Users user = new Users();
		user.setAge(25);
		user.setUserId(101);
		user.setName("Rama");
		user.setUsername("rama55");
		user.setPassword("Pass123");
		
		boolean status = userService.registerUser(user);
		System.out.println(user+" "+status);
		assertEquals(true, status);
	}
	

	
	@Test
	@DisplayName("Cancel Flight")
	@Rollback(true)
	public void cancelFlight() {
		
		assertEquals(false, flightService.cancelFlight(101));
	
	}
	
	@Test
	@DisplayName("Search Flight")
	@Rollback(true)
	public void searchFlight() {
		
		List <Flights> flights = flightService.searchFlight("PUNE", "MUMBAI");
				
		assertNotNull(flights);
	
	}
	
	@Test
	@DisplayName("Search Flight")
	@Rollback(true)
	public void viewTickets() {
		
		List <Tickets> tickets = flightService.viewTickets(1);
		
		assertNotNull(tickets);
	
	}
	
}
