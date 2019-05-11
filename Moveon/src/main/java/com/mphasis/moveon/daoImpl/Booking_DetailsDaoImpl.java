package com.mphasis.moveon.daoImpl;

import java.util.List;

import javax.persistence.TypedQuery;

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
		List<Booking_Details> book_det = session.createQuery("from Booking_Details",Booking_Details.class).list();
	    tr.commit();	
		return book_det;
	}

	public Booking_Details getByBooking_Id(String booking_Id) 
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		TypedQuery<Booking_Details> query=session.createQuery("from Booking_Details where booking_Id=:booking_Id",Booking_Details.class);
		query.setParameter("booking_Id", booking_Id);
		Booking_Details book_details = query.getSingleResult();
		tr.commit();
		return book_details;
	}

	public Booking_Details cancelByBooking_Id(String booking_Id) 
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Booking_Details bookdet = session.get(Booking_Details.class, booking_Id);
		bookdet.setStatus("canceled");
		session.update(bookdet);
		tr.commit();
		return bookdet;
		
		
	}

	public void book_Ticket(Booking_Details booking_Details) 
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(booking_Details);
		tr.commit();
	}

}
