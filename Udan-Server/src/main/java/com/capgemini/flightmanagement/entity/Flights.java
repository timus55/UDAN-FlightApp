package com.capgemini.flightmanagement.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Table(name = "flight")
public class Flights {

	@Id
	@Column(name="FLIGHTID")
	private Integer flightId;
	
	@Column(name = "SOURCE")
	private String source;
	
	@Column(name = "DESTINATION")
	private String destination;
	
	@Column(name = "FLIGHTDATE")
	private String flightDate;
	
	@Column(name = "DEPARTURETIME")
	private String departureTime;
	
	@Column(name = "FARE")
	private Double fare;
	
	@Column(name = "TOTALFARE")
	private Double totalFare;
	
	@Column(name = "AVAILABLESEATS")
	@Min(0)
	@Max(150)
	private Integer availableSeats;
	
	@OneToMany(mappedBy="flight",cascade=CascadeType.ALL)
	private List<Tickets>tickets = new ArrayList<Tickets>();
	
	public Flights() {
		
	}


	public Flights(Integer flightId, String source, String destination, String flightDate, String departureTime,
			Double fare, Double totalFare) {
		super();
		this.flightId = flightId;
		this.source = source;
		this.destination = destination;
		this.flightDate = flightDate;
		this.departureTime = departureTime;
		this.fare = fare;
		totalFare = fare * 1.18;
		setAvailableSeats(50);
	}


	public Integer getFlightId() {
		return flightId;
	}


	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getFlightDate() {
		return flightDate;
	}


	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}


	public String getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}


	public Double getFare() {
		return fare;
	}


	public void setFare(Double fare) {
		this.fare = fare;
	}


	public Double getTotalFare() {
		return totalFare;
	}


	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}


	public Integer getAvailableSeats() {
		return availableSeats;
	}


	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}


	@Override
	public String toString() {
		return "Flights [flightId=" + flightId + ", source=" + source + ", destination=" + destination + ", flightDate="
				+ flightDate + ", departureTime=" + departureTime + ", fare=" + fare + ", totalFare=" + totalFare
				+ ", availableSeats=" + availableSeats + "]";
	}
	
	
}
