package com.mphasis.moveon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.moveon.daos.LocationDao;
import com.mphasis.moveon.entities.Driver;
import com.mphasis.moveon.entities.Location;
import com.mphasis.moveon.exceptions.BusinessException;
import com.mphasis.moveon.service.LocationService;


@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	LocationDao locationDao;
	
	public void setLocationDao(LocationDao locationDao) {
		this.locationDao = locationDao;
	}

	public void addLocation(Location location) {
		System.out.println("Location value in service"+location.getLocation_Name());
		locationDao.insertLocation(location);
	}	
	
	public Location removeLocation(String id) throws BusinessException 
	{
		Location location = null;
		if(location.getLocation_Id().equals(id))
		{
			location = locationDao.deleteLocation(id);

		}
		else
		{
			throw new BusinessException("Enter Driver ID is not present" + id);
		}
		return location;

	}

	public void editLocation(Location location) {
		// TODO Auto-generated method stub
		locationDao.updateLocation(location);

	}
	

	public List<Location> getLocations() {
		// TODO Auto-generated method stub
		return locationDao.getAll();
	}

		
	}

	
