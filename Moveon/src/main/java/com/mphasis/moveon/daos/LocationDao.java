package com.mphasis.moveon.daos;

import java.util.List;

import com.mphasis.moveon.entities.Location;

public interface LocationDao 
{
	public void insertLocation(Location location);
	public void updateLocation(Location location);
	public void deleteLocation(int location_id);
	public List<Location> getAll();
	
	

}
