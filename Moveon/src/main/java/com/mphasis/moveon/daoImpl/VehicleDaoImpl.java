package com.mphasis.moveon.daoImpl;

import java.util.List;




import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.moveon.daos.VehicleDao;

import com.mphasis.moveon.entities.Vehicle;


@Repository

public class VehicleDaoImpl implements VehicleDao {
	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insertVehicle(Vehicle vehicle) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(vehicle);
		tr.commit();

	}

	public void updateVehicle(Vehicle vehicle) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(vehicle);
		tr.commit();
		session.close();

	}

	public Vehicle deleteVehicle(String vehicle_Id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Vehicle vehicle=session.get(Vehicle.class,vehicle_Id);
		session.delete(vehicle);
		tr.commit();
		return vehicle;

	}

	public List<Vehicle> getAllVehicles() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Vehicle> vehicles=session.createQuery("from Vehicle",Vehicle.class).list();
		return vehicles;
	}

	 public List<Vehicle> getAllByType(String vehicle_Type) {
		 Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			Criteria cri=session.createCriteria(Vehicle.class);
			cri.add(Restrictions.eq("vehicle_Type",vehicle_Type ));
			List<Vehicle> vehicle=cri.list();
			tr.commit();
			return vehicle;
	 }
}
