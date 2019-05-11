package com.mphasis.moveon.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.moveon.daos.DriverDao;
import com.mphasis.moveon.entities.Driver;

@Repository

public class DriverDaoImpl implements DriverDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insertDriver(Driver driver) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(driver);
		tr.commit();
	}

	public void updateDriver(Driver driver) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(driver);
		tr.commit();
		session.close();
		
	}

	public Driver deleteDriver(String driver_Id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Driver driver=session.get(Driver.class, driver_Id);
		session.delete(driver);
		tr.commit();
		return driver;
	}

	public List<Driver> getAll() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Driver> drivers=session.createQuery("from Driver",Driver.class).list();
		tr.commit();
		return drivers;
	}

	
	
	

}
