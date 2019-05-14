package com.mphasis.moveon.daoImpl;

import java.util.List;


import javax.persistence.TypedQuery;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.moveon.daos.ScheduleDao;
import com.mphasis.moveon.entities.Route;
import com.mphasis.moveon.entities.Schedule;
import com.mphasis.moveon.entities.Vehicle;


@Repository
public class ScheduleDaoImpl implements ScheduleDao
{

	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insertSchedule(Schedule schedule) 
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(schedule);
		tr.commit();
	}

	public Schedule deleteSchedule(String schedule_Id) 
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Schedule sc = (Schedule) session.get(Schedule.class, schedule_Id);
		session.delete(sc);
		tr.commit();
		return sc;
	}

	public List<Schedule> getAllSchedule() 
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		List<Schedule> schedules = session.createQuery("from Schedule",Schedule.class).list();
		tr.commit();
		return schedules;
	}

	public List<Vehicle> getByRouteSchedule(String schedule_Date, String route_Id) 
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		//TypedQuery<Vehicle> query = session.createNativeQuery("");
		//List<Vehicle> vehicles=query.getResultList();
		NativeQuery<Vehicle> nativeQuery = session.createNativeQuery("select * from vehicle where vehicle_Id in"
				                 + "(select vehicle_Id from schedule where schedule_Date=:schedule_Date and route_Id=:)"
				                 + "(select * from route where route_Id=:route_Id)");
		nativeQuery.setParameter("route_Id", route_Id);
		nativeQuery.setParameter("schedule_Date", schedule_Date);
		List<Vehicle> vehicles=nativeQuery.getResultList();
		return vehicles;
	}

	
}
