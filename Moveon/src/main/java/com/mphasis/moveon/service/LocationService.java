package com.mphasis.moveon.service;
import java.util.List;

import com.mphasis.moveon.entities.Location;

public interface LocationService {

	public void addLocation(Location location);
	public void editLocation(Location location);
	public void removeLocation(String location_Id);
	public List<Location> getLocations();
	
}



