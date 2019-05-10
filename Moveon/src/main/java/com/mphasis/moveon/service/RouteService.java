package com.mphasis.moveon.service;

import java.util.List;

import com.mphasis.moveon.entities.Route;
import com.mphasis.moveon.entities.Vehicle;

public interface RouteService {
	public void addRoute(Route route);
	public void editRoute(Route route);
	public void removeRoute(String route_Id);
    public List<Route> getAll();
    public List<Vehicle> getAllBySourceAndDestination(String source,String destination);

}
