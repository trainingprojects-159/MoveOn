package com.mphasis.moveon.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.moveon.daos.RouteDao;
import com.mphasis.moveon.entities.Route;
import com.mphasis.moveon.entities.Vehicle;
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

	public void removeRoute(String route_Id) {
		routeDao.deleteRoute(route_Id);


	}

	public List<Route> getAll() {
		return  routeDao.getAll();
	}

	public List<Vehicle> getAllBySourceAndDestination(String source, String destination) {
		return routeDao.getAllBySourceAndDestination(source,destination);
	}

}
