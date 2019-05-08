package com.mphasis.moveon.daos;

import java.util.List;

import com.mphasis.moveon.entities.Schedule;
import com.mphasis.moveon.entities.Vehicle;

public interface ScheduleDao 
{
	public void insertSchedule(Schedule schedule);
	public void deleteSchedule(int schedule_id);
	public List<Schedule> getAll();
	public List<Vehicle> getByRouteSchedule(String schedule_date,int rout_id);

}
