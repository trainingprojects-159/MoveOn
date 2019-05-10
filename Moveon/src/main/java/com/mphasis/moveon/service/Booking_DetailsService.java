package com.mphasis.moveon.service;

import java.util.List;

import com.mphasis.moveon.entities.Booking_Details;

public interface Booking_DetailsService 
{
	public List<Booking_Details> getAll();
	public Booking_Details getByBooking_Id(String booking_Id);
	public void removeBooking_Id(String booking_Id);
	public void bookTicket(Booking_Details booking_Details);
}
