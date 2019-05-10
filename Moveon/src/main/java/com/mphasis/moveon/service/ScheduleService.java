package com.mphasis.moveon.service;

import java.util.List;

import com.mphasis.moveon.entities.Schedule;

public interface ScheduleService 
{
	public void addSchedule(Schedule schedule);
	public void removeSchedule(String schedule_Id);
	public List<Schedule> getAll();
	
	

}
