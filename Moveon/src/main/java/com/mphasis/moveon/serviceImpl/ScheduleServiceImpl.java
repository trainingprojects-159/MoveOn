package com.mphasis.moveon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.moveon.daos.ScheduleDao;
import com.mphasis.moveon.entities.Route;
import com.mphasis.moveon.entities.Schedule;
import com.mphasis.moveon.entities.Vehicle;
import com.mphasis.moveon.exceptions.BusinessException;
import com.mphasis.moveon.service.ScheduleService;

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

	public Schedule removeSchedule(String schedule_Id) throws BusinessException 
	{

		Schedule schedule = null;
		if(schedule.getSchedule_Id().equals(schedule_Id))
		{
			schedule = scheduleDao.deleteSchedule(schedule_Id);
		}
		else
		{
			throw new BusinessException("Enter scheduleID is invalid" + schedule_Id);
		}
		return schedule;

	}

	public List<Schedule> getAll() 
	{
		
		return scheduleDao.getAll();
	}

	

}
