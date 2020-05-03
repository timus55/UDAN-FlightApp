package com.capgemini.flightmanagement.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.flightmanagement.controller.FlightController;
import com.capgemini.flightmanagement.dao.FlightDaoImpl;
import com.capgemini.flightmanagement.entity.Flights;
import com.capgemini.flightmanagement.entity.Tickets;
import com.capgemini.flightmanagement.entity.Users;
import com.capgemini.flightmanagement.exception.EntityNotFound;
import com.capgemini.flightmanagement.utility.GlobalResources;

@Service
@Transactional
public class FlightServiceImpl implements FlightServiceInterface {

	@Autowired
	private FlightDaoImpl daoObject;
	@Autowired
	private EntityManager entityManager;

	private Logger logger = GlobalResources.getLogger(FlightServiceImpl.class);

	private static int bookingId;

	public FlightServiceImpl() {
	}

	@Override
	public List<Flights> searchFlight(String source, String dest) {

		String methodName = "searchFlight()";
		logger.info(methodName + " called");

		try {
			String qStr = "SELECT f FROM Flights f WHERE f.source=:psource and f.destination=:pdest";
			TypedQuery<Flights> query = entityManager.createQuery(qStr, Flights.class);
			query.setParameter("psource", source);
			query.setParameter("pdest", dest);
			List<Flights> flights = query.getResultList();

			return flights;
		} catch (Exception e) {
			 
			throw new EntityNotFound("No Flight Found from "+source+" to "+dest);
		}
	}

	@Transactional
	@Override
	public Integer bookFlight(int flightid, Integer userid) {

		String methodName = "bookFlight()";
		logger.info(methodName + " called");

		try {

			Integer temp = bookingId;
			Tickets bd = new Tickets();
			Flights fd = daoObject.getFlightById(flightid);

			if (fd.getAvailableSeats() > 0) {
				fd.setAvailableSeats(fd.getAvailableSeats() - 1);
				daoObject.updateFlight(fd);

				String command = "select count(bd.bookingId) from Tickets bd";
				TypedQuery<Long> query1 = entityManager.createQuery(command, Long.class);
				long count = query1.getSingleResult();
				if (count > 0) {
					command = "select max(bd.bookingId) from Tickets bd";
					TypedQuery<Integer> query2 = entityManager.createQuery(command, Integer.class);
					Integer bid = query2.getSingleResult();
					temp = bid + 1;
				} else {
					temp = 1000;
				}

				command = "select user from Users user where user.userId =: puserid";
				TypedQuery<Users> query2 = entityManager.createQuery(command, Users.class);
				query2.setParameter("puserid", userid);

				Users user = query2.getSingleResult();
				bd.setBookingId(temp);
				bd.setuser(user);
				bd.setFlightData(fd);

				if (daoObject.addBooking(bd)) {
					return temp;
				}

			} else {
				System.out.println("No booking available");
			}
			return 0;
		} catch (Exception e) {
			 
			return 0;

		}
	}

	@Override
	public boolean cancelFlight(Integer bookid) {

		String methodName = "cancelFlight()";
		logger.info(methodName + " called");

		try {
			Tickets bd = daoObject.getBookingDetails(bookid);

			int availableSeats = bd.getFlightData().getAvailableSeats() + 1;
			bd.getFlightData().setAvailableSeats(availableSeats);

			return daoObject.cancelFlight(bd);
		} catch (Exception e) {
			throw new EntityNotFound("Cannot Canel Ticket ! No Tickect Found");
		}

	}

	@Override
	public List<Tickets> viewTickets(int userid) {

		String methodName = "viewTickets()";
		logger.info(methodName + " called");

		try {
			String qStr = "SELECT t FROM Tickets t WHERE userid=:uId";
			TypedQuery<Tickets> query = entityManager.createQuery(qStr, Tickets.class);
			query.setParameter("uId", userid);
			List<Tickets> tickets = query.getResultList();
			return tickets;

		} catch (Exception e) {
			throw new EntityNotFound("No Ticket Available");
//			 
//			return null;
		}

	}

	@Override
	public Tickets getBooking(Integer bookId) {

		String methodName = "getBooking()";
		logger.info(methodName + " called");

		try {

			return daoObject.getBookingDetails(bookId);

		} catch (Exception e) {
			throw new EntityNotFound("No booking found ..!");
		}

	}
}
