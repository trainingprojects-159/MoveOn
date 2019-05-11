package com.mphasis.moveon.service;
import java.util.List;

import com.mphasis.moveon.entities.Location;
import com.mphasis.moveon.exceptions.BusinessException;

public interface LocationService {

	public void addLocation(Location location);
	public void editLocation(Location location);
	public Location removeLocation(String location_Id) throws BusinessException;
	public List<Location> getLocations();
	
}



