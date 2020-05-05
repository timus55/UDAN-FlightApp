package com.capgemini.flightmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Booking")
public class Tickets {

	@Id
	@Column(name = "BOOKINGID")
	private Integer bookingId;
	
	@ManyToOne
	@JoinColumn(name = "FLIGHTID")
	private Flights flight;
	
	@ManyToOne
	@JoinColumn(name = "USERID")
	private Users user;



	public Tickets() {
	}
	
	public Tickets(Integer bookingId, Flights flightData, Users user) {
		super();
		this.bookingId = bookingId;
		this.flight = flightData;
		this.user = user;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	
	public Flights getFlightData() {
		return flight;
	}

	public void setFlightData(Flights flightData) {
		this.flight = flightData;
	}

	public Users getuser() {
		return user;
	}

	public void setuser(Users user) {
		this.user = user;
	}
}
