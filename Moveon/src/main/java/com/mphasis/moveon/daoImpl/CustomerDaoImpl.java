package com.mphasis.moveon.daoImpl;


import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.moveon.daos.CustomerDao;
import com.mphasis.moveon.entities.Admin;
import com.mphasis.moveon.entities.Customer;

@Repository

public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Customer login(String email, String password) {
		Session session=sessionFactory.openSession();
		TypedQuery<Customer> query=session.createQuery("from Customer where email = :email and password = :password");
		 query.setParameter("email", email);
		 query.setParameter("password", password);
		 Customer customer= query.getSingleResult();
		 return customer;
	}

	public Customer register(Customer customer) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(customer);
		tr.commit();
		return customer;
	}

}
