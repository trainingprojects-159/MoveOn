package com.mphasis.moveon.daos;

import java.util.List;

import com.mphasis.moveon.entities.Route;

public interface RouteDao 
{
	public void insertRoute(Route route);
	public void updateRoute(Route route);
	public void deleteRoute(int route_id);
    public List<Route> getAll();
}
