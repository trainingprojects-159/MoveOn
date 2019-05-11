package com.mphasis.moveon.daoImpl;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.moveon.daos.AdminDao;
import com.mphasis.moveon.entities.Admin;

@Repository
public class AdminDaoImpl implements AdminDao {
@Autowired
SessionFactory sessionFactory;

public SessionFactory getSessionFactory() {
 return sessionFactory;
}

public void setSessionFactory(SessionFactory sessionFactory) {
 this.sessionFactory = sessionFactory;
}

public Admin login(String email, String password)
{
 Session session=sessionFactory.getCurrentSession();
 //Transaction tr=session.beginTransaction();
 //Query query=session.createQuery("from Admin where email = :email and password = :password");
 TypedQuery<Admin> query=session.createQuery("from Admin where email = :email and password = :password");
 query.setParameter("email", email);
 query.setParameter("password", password);
 Admin admin=null;
 try{
	   admin = (Admin) query.getSingleResult();
	 } catch (NoResultException nre) {
		 System.out.println("no result");
	 } catch (NonUniqueResultException nure) {
	 System.out.println("no result");
	}
 //tr.commit();
 return admin;
}

}