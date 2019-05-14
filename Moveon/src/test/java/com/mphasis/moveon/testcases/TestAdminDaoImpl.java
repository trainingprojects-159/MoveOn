package com.mphasis.moveon.testcases;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.mphasis.moveon.configurations.AppConfig;
import com.mphasis.moveon.daos.AdminDao;

import com.mphasis.moveon.exceptions.BusinessException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@Transactional
public class TestAdminDaoImpl {

	@Autowired
	AdminDao adminDao;
	
	@Test
	public void test() throws BusinessException 
	{
		assertNull(adminDao.login("shevin23@gmail.com", "shevin@12"));
		
		assertNotNull(adminDao.login("pavan@gmail.com", "Pavan@12"));
		
	}
	
}