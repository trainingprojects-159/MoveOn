package com.mphasis.moveon.entities;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.moveon.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Admin 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="admin_seq")
	 @GenericGenerator(
		        name = "admin_seq", 
		        strategy = "com.mphasis.moveon.util.StringPrefixedSequenceIdGenerator", 
		        parameters = {
		            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AD"),
		            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String admin_Id;
	private String admin_name;
	private String email;
	private String password; 
	
	
	@OneToMany
	private List<Route> route;
	
	@OneToMany
	private List<Vehicle> vehicle;
	
	
	@OneToMany
	private List<Driver> driver;
	
	@OneToMany
	private List<Location> location;
	
	@OneToMany
	private List<Schedule> schedule;
	
	@OneToMany
	private List<Booking_Details> booking_details;
	
	
	
	
	public String getAdmin_Id() {
		return admin_Id;
	}
	public void setAdmin_Id(String admin_Id) {
		this.admin_Id = admin_Id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public List<Driver> getDriver() {
		return driver;
	}
	public void setDriver(List<Driver> driver) {
		this.driver = driver;
	}
	public List<Location> getLocation() {
		return location;
	}
	public void setLocation(List<Location> location) {
		this.location = location;
	}
	public List<Schedule> getSchedule() {
		return schedule;
	}
	public void setSchedule(List<Schedule> schedule) {
		this.schedule = schedule;
	}
	public List<Route> getRoute() {
		return route;
	}
	public void setRoute(List<Route> route) {
		this.route = route;
	}
	public void setBooking_details(List<Booking_Details> booking_details) {
		this.booking_details = booking_details;
	}
}
