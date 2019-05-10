package com.mphasis.moveon.services;

import java.util.List;

import com.mphasis.moveon.entities.Schedule;
import com.mphasis.moveon.entities.Vehicle;

public interface ScheduleService 
{
	public void addSchedule(Schedule schedule);
	public void removeSchedule(String schedule_Id);
	public List<Schedule> getAll();
	public List<Vehicle> getByRouteSchedule(String schedule_Date,String route_Id);
	

}
