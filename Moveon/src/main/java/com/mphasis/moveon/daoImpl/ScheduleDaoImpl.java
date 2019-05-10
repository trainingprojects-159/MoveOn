package com.mphasis.moveon.daoImpl;

import java.util.List;

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
		List<Schedule> schedules = session.createCriteria(Schedule.class).list();
		tr.commit();
		return schedules;
	}

	public List<Vehicle> getByRouteSchedule(String schedule_Date, String route_Id) 
	{

		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query query1=session.createQuery("from Route where route_Id=:route_Id");
		query1.setParameter("route_Id", route_Id);
		Route route=(Route) query1.uniqueResult();
		Query query2=session.createQuery("from Schedule where schedule_Date=:schedule_Date and route=:route");
		query2.setParameter("schedule_Date", schedule_Date);
		query2.setParameter("route", route);
		Schedule schedule=(Schedule) query2.uniqueResult();
		Query query3 = session.createQuery("from Vehicle where vehicle_Id=:vehicle_Id ");
		query3.setParameter("vehicle_Id", schedule.getVehicle());
        List<Vehicle> vehicles=query3.getResultList();
        tr.commit();
		return vehicles;
	}

}
