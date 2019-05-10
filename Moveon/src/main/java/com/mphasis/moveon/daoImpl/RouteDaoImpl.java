package com.mphasis.moveon.daoImpl;

import java.util.List;






import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.mphasis.moveon.daos.RouteDao;
import com.mphasis.moveon.entities.Route;
import com.mphasis.moveon.entities.Vehicle;
@Repository

public class RouteDaoImpl implements RouteDao {
	@Autowired
		SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

	public void insertRoute(Route route) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(route);
		tr.commit();

		

	}

	public void updateRoute(Route route) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.update(route);
		tr.commit();
		session.close();

	}

	public void deleteRoute(int route_Id) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Route route=session.get(Route.class,route_Id);
		session.delete(route);
		tr.commit();

	}

	public List<Route> getAll() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Route> routes=session.createCriteria(Route.class).list();
		return routes;
	}

	public Vehicle getAllBySourceAndDestination(String source, String destination) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query query1=session.createSQLQuery("select vehicle_Id,vehicle_Name,vehicle_Type,seat_Capacity,vehicle_Num,fare where vehicle_Id = (select vehicle_Id from schedule where route_id = (select route_id from route where source=:source and destination=:destination");
		query1.setParameter("source", source);
		query1.setParameter("destination", destination);
        Vehicle vehicle=(Vehicle) query1.uniqueResult();
        tr.commit();
		return vehicle;
	}

}
