package com.mphasis.moveon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.moveon.daos.ScheduleDao;
import com.mphasis.moveon.entities.Schedule;
import com.mphasis.moveon.entities.Vehicle;
import com.mphasis.moveon.services.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService
{
	@Autowired
	ScheduleDao scheduleDao;

	public void setScheduleDao(ScheduleDao scheduleDao) 
	{
		this.scheduleDao = scheduleDao;
	}

	public void addSchedule(Schedule schedule) 
	{
		scheduleDao.insertSchedule(schedule);
	}

	public void removeSchedule(String schedule_Id) 
	{
		scheduleDao.deleteSchedule(schedule_Id);
	}

	public List<Schedule> getAll() 
	{
		
		return scheduleDao.getAll();
	}

	public List<Vehicle> getByRouteSchedule(String schedule_Date, String route_Id) 
	{
		
		return scheduleDao.getByRouteSchedule(schedule_Date, route_Id);
	}

}
