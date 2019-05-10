package com.mphasis.moveon.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

 

import com.mphasis.moveon.entities.Booking_Details;

import com.mphasis.moveon.entities.Customer;

import com.mphasis.moveon.entities.Passenger;

import com.mphasis.moveon.service.Booking_DetailsService;

import com.mphasis.moveon.service.CustomerService;

import com.mphasis.moveon.service.PassengerService;

@RestController
@RequestMapping("/customer")

public class CustomerController 
{

	@Autowired

	CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(value="/customer/register",method=RequestMethod.POST)
	public void register(@RequestBody Customer customer) 
	{
		 this.customerService.registerService(customer);
	}

	@RequestMapping(value="/customer/login",method=RequestMethod.POST)
	public void login(@RequestBody String email,String password) 
	{
		 this.customerService.loginService(email,password);
	}

	@Autowired

	PassengerService passengerService;
	
	public void setPassengerService(PassengerService passengerService) {
		this.passengerService = passengerService;
	}

	@RequestMapping(value="/passenger/add",method=RequestMethod.POST)
	public void addPassenger(@RequestBody Passenger passenger) 
	{
		 this.passengerService.addPassenger(passenger);
	}

	@RequestMapping(value="/passenger/edit",method=RequestMethod.PUT)
	public void editPassenger(@RequestBody Passenger passenger) 
	{
		 this.passengerService.editPassenger(passenger);
	}

	@RequestMapping(value="/passenger/{id_Proof}",method=RequestMethod.DELETE)
	public void removeCar(@PathVariable("id_Proof")String  id_Proof) 

	{
		this.passengerService.removePassenger(id_Proof);
	}

	@RequestMapping(value="/passengers",method=RequestMethod.GET)
	public List<Passenger> listPassenger()
	{
		return passengerService. getAllPassenger();
	}

	@Autowired
	Booking_DetailsService booking_DetailsService;
	

	public void setBooking_DetailsService(Booking_DetailsService booking_DetailsService) {
		this.booking_DetailsService = booking_DetailsService;
	}

	@RequestMapping(value="/booking_Details/book_Ticket",method=RequestMethod.POST)
    public void  book_Ticket(@RequestBody Booking_Details booking_Details) 
	{
		this.booking_DetailsService.bookTicket(booking_Details);
	}
	
	@RequestMapping(value="/booking_Details/removeBooking_Id",method=RequestMethod.DELETE)
	public void removeBooking_Id(@PathVariable("booking_Id")String booking_Id)
	{
		this.booking_DetailsService.removeBooking_Id(booking_Id);
	}
	
	@RequestMapping(value="/booking_Details/getByBooking_Id",method=RequestMethod.GET)
	public void getByBooking_Id(@PathVariable("booking_Id")String booking_Id)
	{
		this.booking_DetailsService.getByBooking_Id(booking_Id);
	}
	
	@RequestMapping(value="/bookings",method=RequestMethod.GET)
	public List<Booking_Details> listBooking()
	{
		return booking_DetailsService.getAll();
	}
	

}