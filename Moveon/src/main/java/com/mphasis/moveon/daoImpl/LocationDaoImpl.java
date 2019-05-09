package com.mphasis.moveon.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.moveon.daos.LocationDao;
import com.mphasis.moveon.entities.Location;

@Repository
@Transactional
public class LocationDaoImpl implements LocationDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insertLocation(Location location) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(location);
		tr.commit();
	}

	public void updateLocation(Location location) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(location);
		tr.commit();
		session.close();
		
	}

	public void deleteLocation(int location_Id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Location location=session.get(Location.class, location_Id);
		session.delete(location);
		tr.commit();
	}

	public List<Location> getAll() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Location> locations=session.createCriteria(Location.class).list();
		return locations;
	}

	
	

}
