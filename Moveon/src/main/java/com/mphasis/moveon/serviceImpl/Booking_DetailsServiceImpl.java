package com.mphasis.moveon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.moveon.daos.Booking_DetailsDao;
import com.mphasis.moveon.entities.Booking_Details;
import com.mphasis.moveon.services.Booking_DetailsService;

@Service
public class Booking_DetailsServiceImpl implements Booking_DetailsService 
{
	@Autowired
	Booking_DetailsDao booking_detailsDao;
	

	public void setBooking_detailsDao(Booking_DetailsDao booking_detailsDao) 
	{
		this.booking_detailsDao = booking_detailsDao;
	}

	public List<Booking_Details> getAll() 
	{
		return booking_detailsDao.getAll();
	}

	public Booking_Details getByBooking_Id(String booking_Id) 
	{
		return booking_detailsDao.getByBooking_Id(booking_Id);
	}

	public void removeBooking_Id(String booking_Id) 
	{
		booking_detailsDao.cancelByBooking_Id(booking_Id);
	}

}
