package com.mphasis.moveon.daos;

import java.util.List;

import com.mphasis.moveon.entities.Schedule;

public interface ScheduleDao 
{
	public void insertSchedule(Schedule schedule);
	public void deleteSchedule(int schedule_id);
	public List<Schedule> getAll();

}
