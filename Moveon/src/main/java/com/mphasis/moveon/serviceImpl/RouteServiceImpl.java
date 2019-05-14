package com.mphasis.moveon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.moveon.daos.RouteDao;
import com.mphasis.moveon.entities.Route;
import com.mphasis.moveon.entities.Vehicle;
import com.mphasis.moveon.exceptions.BusinessException;
import com.mphasis.moveon.service.RouteService;
@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	RouteDao routeDao;
	public void setRouteDao(RouteDao routeDao) {
		this.routeDao = routeDao;
	}

	public void addRoute(Route route) {
		System.out.println("route values in service"+route.getDistance());
		routeDao.insertRoute(route);

	}

	public void editRoute(Route route) {
	routeDao.updateRoute(route);

	}

	public Route removeRoute(String route_Id) throws BusinessException 
	{
		Route route = null;
		if(route.getRoute_Id().equals(route_Id))
		{
			route = routeDao.deleteRoute(route_Id);
		}
		else
		{
			throw new BusinessException("Enter routeID is invalid" + route_Id);
		}
		return route;


	}

	public List<Route> getAllRoute() {
		return  routeDao.getAllRoute();
	}

	public List<Vehicle> getAllBySourceAndDestination(String source, String destination) {
		return routeDao.getAllBySourceAndDestination(source,destination);
	}

}
