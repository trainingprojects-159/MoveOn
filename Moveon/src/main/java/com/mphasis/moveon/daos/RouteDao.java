package com.mphasis.moveon.daos;

import java.util.List;

import com.mphasis.moveon.entities.Route;
import com.mphasis.moveon.entities.Vehicle;
import com.mphasis.moveon.exceptions.BusinessException;

public interface RouteDao 
{
	public void insertRoute(Route route);
	public void updateRoute(Route route);
	public Route deleteRoute(String route_Id) throws BusinessException;
    public List<Route> getAllRoute();
    public List<Vehicle> getAllBySourceAndDestination(String source,String destination);
}
	