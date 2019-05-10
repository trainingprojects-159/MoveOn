package com.mphasis.moveon.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.moveon.daos.Booking_DetailsDao;
import com.mphasis.moveon.entities.Booking_Details;

@Repository
public class Booking_DetailsDaoImpl implements Booking_DetailsDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Booking_Details> getAll() 
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		List<Booking_Details> book_det = session.createCriteria(Booking_Details.class).list();
	    tr.commit();	
		return book_det;
	}

	public Booking_Details getByBooking_Id(String booking_Id) 
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Booking_Details book_details = (Booking_Details) session.createCriteria(Booking_Details.class, booking_Id);
		tr.commit();
		return book_details;
	}

	public void cancelByBooking_Id(String booking_Id) 
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Booking_Details bookdet = session.get(Booking_Details.class, booking_Id);
		bookdet.setStatus("canceled");
		session.update(bookdet);
		tr.commit();
		
		
	}

}
