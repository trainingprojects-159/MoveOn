package com.mphasis.moveon.daoImpl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

	public void deleteSchedule(String schedule_Id) 
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Schedule sc = (Schedule) session.get(Schedule.class, schedule_Id);
		session.delete(sc);
		tr.commit();
	}

	public List<Schedule> getAll() 
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
		List<Vehicle> vehicles = session.createNativeQuery(schedule_Date, route_Id);
		
		return vehicles;
	}

	
}
