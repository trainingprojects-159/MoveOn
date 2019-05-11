package com.mphasis.moveon.service;

import java.util.List;

import com.mphasis.moveon.entities.Booking_Details;
import com.mphasis.moveon.exceptions.BusinessException;

public interface Booking_DetailsService 
{
	public List<Booking_Details> getAll();
	public Booking_Details getByBooking_Id(String booking_Id) throws BusinessException;
	public Booking_Details removeBooking_Id(String booking_Id) throws BusinessException;
	public void bookTicket(Booking_Details booking_Details) throws BusinessException;
}
