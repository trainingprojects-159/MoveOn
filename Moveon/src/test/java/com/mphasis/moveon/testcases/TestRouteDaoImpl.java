package com.mphasis.moveon.testcases;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mphasis.moveon.configurations.AppConfig;
import com.mphasis.moveon.daos.RouteDao;
import com.mphasis.moveon.entities.Route;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
@WebAppConfiguration
@Transactional
public class TestRouteDaoImpl {


	@Autowired
	RouteDao routeDao;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Route route=new Route();
		route.setRoute_Id("RO111");
		routeDao.insertRoute(route);
		//assertNotNull(driverDao.getbyid(1));
		
		List<Route> routes=routeDao.getAllRoute();
		assertEquals(routes.size(),5);	
	}

}
