package com.mphasis.moveon.service;

import java.util.List;

import com.mphasis.moveon.entities.Route;
import com.mphasis.moveon.entities.Vehicle;
import com.mphasis.moveon.exceptions.BusinessException;

public interface RouteService {
	public void addRoute(Route route);
	public void editRoute(Route route);
	public Route removeRoute(String route_Id) throws BusinessException;
    public List<Route> getAllRoute();
    public List<Vehicle> getAllBySourceAndDestination(String source,String destination);

}
