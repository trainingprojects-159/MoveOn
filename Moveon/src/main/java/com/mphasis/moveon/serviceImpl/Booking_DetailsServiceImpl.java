package com.mphasis.moveon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.moveon.daos.Booking_DetailsDao;
import com.mphasis.moveon.entities.Booking_Details;
import com.mphasis.moveon.exceptions.BusinessException;
import com.mphasis.moveon.service.Booking_DetailsService;

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

	public Booking_Details getByBooking_Id(String booking_Id) throws BusinessException 
	{
		Booking_Details bookdetails = null;
		if(bookdetails.getBooking_Id().equals(booking_Id))
		{
			bookdetails=booking_detailsDao.getByBooking_Id(booking_Id);
		}
		else
		{
			throw new BusinessException("Booking ID" + booking_Id + "is not present");
		}
		return bookdetails;
	}

	public Booking_Details removeBooking_Id(String booking_Id) throws BusinessException
	{
		Booking_Details bookingdetails1 = null;
		if(bookingdetails1.getBooking_Id().equals(booking_Id))
		{
			bookingdetails1=booking_detailsDao.cancelByBooking_Id(booking_Id);
		}
		else
		{
			throw new BusinessException("Booking ID" + booking_Id + "is not present");
		}
		return bookingdetails1;
		
	}

	public void bookTicket(Booking_Details booking_Details) throws BusinessException 
	{
		booking_detailsDao.book_Ticket(booking_Details);
	}

}
