package com.mphasis.moveon.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.moveon.daos.PassengerDao;
import com.mphasis.moveon.entities.Passenger;


@Repository

public class PassengerDaoImpl implements PassengerDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insertPassenger(Passenger passenger) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(passenger);
		tr.commit();
		
	}

	public void updatePassenger(Passenger passenger) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(passenger);
		tr.commit();
		session.close();
		
	}

	public void deletePassenger(String id_Proof) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Passenger passengers=(Passenger)session.get(Passenger.class, id_Proof);
		session.delete(id_Proof);
		tr.commit();
		
	}
	
	public List<Passenger> getAllPassenger() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Passenger> passengers=session.createQuery("from Passenger",Passenger.class).list();
		tr.commit();
		return passengers;
		
	}

	

}
