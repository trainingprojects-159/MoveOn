package com.mphasis.moveon.daos;

import java.util.List;

import com.mphasis.moveon.entities.Booking_Details;
import com.mphasis.moveon.exceptions.BusinessException;

public interface Booking_DetailsDao 
{
	public List<Booking_Details> getAll();
	public Booking_Details getByBooking_Id(String booking_Id) throws BusinessException;
	public Booking_Details cancelByBooking_Id(String booking_Id) throws BusinessException;
	public void book_Ticket(Booking_Details booking_Details) throws BusinessException;

}
