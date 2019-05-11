package com.mphasis.moveon.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.moveon.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Booking_Details 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="book_seq")
	 @GenericGenerator(
		        name = "book_seq", 
		        strategy = "com.mphasis.moveon.util.StringPrefixedSequenceIdGenerator", 
		        parameters = {
		            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "BO"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String booking_Id;
	
	@ManyToOne
	private Customer customer;
	
	@ManyToOne
	private Admin admin;
	
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	private String passenger_Name;
	private int age;
	private String gender;
	private String boarding_Point;
	private String drop_Point;
	private String journey_Date;
	private String booking_Date;
	private double fare;
	private String status;
	private long card_Number;
	
	
	@OneToOne
	//@JoinColumn(name="route_Id")
	private Route route;
	
	@OneToOne
	//@JoinColumn(name="vehicle_Id")
	private Vehicle vehicle;


	public String getBooking_Id() {
		return booking_Id;
	}
	public void setBooking_Id(String booking_Id) {
		this.booking_Id = booking_Id;
	}
	public String getPassenger_Name() {
		return passenger_Name;
	}
	public void setPassenger_Name(String passenger_Name) {
		this.passenger_Name = passenger_Name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBoarding_Point() {
		return boarding_Point;
	}
	public void setBoarding_Point(String boarding_Point) {
		this.boarding_Point = boarding_Point;
	}
	public String getDrop_Point() {
		return drop_Point;
	}
	public void setDrop_Point(String drop_Point) {
		this.drop_Point = drop_Point;
	}
	public String getJourney_Date() {
		return journey_Date;
	}
	public void setJourney_Date(String journey_Date) {
		this.journey_Date = journey_Date;
	}
	public String getBooking_Date() {
		return booking_Date;
	}
	public void setBooking_Date(String booking_Date) {
		this.booking_Date = booking_Date;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getCard_Number() {
		return card_Number;
	}
	public void setCard_Number(long card_Number) {
		this.card_Number = card_Number;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Admin getAdmin() {
		return admin;
	}
	
	
	
}
