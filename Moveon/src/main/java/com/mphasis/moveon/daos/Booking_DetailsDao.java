package com.mphasis.moveon.daos;

import java.util.List;

import com.mphasis.moveon.entities.Booking_Details;

public interface Booking_DetailsDao 
{
	public List<Booking_Details> getAll();
	public Booking_Details getByBooking_Id(String booking_Id);
	public void cancelByBooking_Id(String booking_Id);
	public void book_Ticket(Booking_Details booking_Details);

}
