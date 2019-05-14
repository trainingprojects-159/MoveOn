package com.mphasis.moveon.daos;

import java.util.List;

import com.mphasis.moveon.entities.Schedule;
import com.mphasis.moveon.entities.Vehicle;
import com.mphasis.moveon.exceptions.BusinessException;

public interface ScheduleDao 
{
	public void insertSchedule(Schedule schedule);
	public Schedule deleteSchedule(String schedule_Id) throws BusinessException;
	public List<Schedule> getAllSchedule();
	public List<Vehicle> getByRouteSchedule(String schedule_Date,String route_Id) throws BusinessException;
}
