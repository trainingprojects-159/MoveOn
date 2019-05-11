package com.mphasis.moveon.daos;

import java.util.List;

import com.mphasis.moveon.entities.Location;
import com.mphasis.moveon.exceptions.BusinessException;

public interface LocationDao 
{
	public void insertLocation(Location location);
	public void updateLocation(Location location);
	public Location deleteLocation(String location_Id) throws BusinessException;
	public List<Location> getAll();
	
	

}
