package com.mphasis.moveon.service;

import java.util.List;

import com.mphasis.moveon.entities.Schedule;
import com.mphasis.moveon.exceptions.BusinessException;

public interface ScheduleService 
{
	public void addSchedule(Schedule schedule);
	public Schedule removeSchedule(String schedule_Id) throws BusinessException;
	public List<Schedule> getAll();
	
	

}
