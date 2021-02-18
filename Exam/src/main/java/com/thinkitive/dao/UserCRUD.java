package com.thinkitive.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.thinkitive.model.User;

@Service
public class UserCRUD {
	public UserCRUD() {
		// TODO Auto-generated constructor stub
	}
	public void updateUser(User user) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		if(user!=null) {
			session.update(user);
		}	
		tx.commit();
		session.close();
		factory.close();

	}
	
	
	public void approve(int id,String activateOrNot) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("id", id));

		// Convenience method to return a single instance that matches
		// the query, or null if the query returns no results.
		User user = (User)criteria.uniqueResult();
		if(user!=null) {
			user.setApprove(activateOrNot);
			session.update(user);
		}
		
		tx.commit();
		session.close();
		factory.close();

	}
	
	private boolean isValidUser(String username) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("username", username));

		// Convenience method to return a single instance that matches
		// the query, or null if the query returns no results.
		Object result = criteria.uniqueResult();
		tx.commit();
		session.close();
		factory.close();
		if (result != null) {
			User user = (User) result;
			System.out.println("user = " + user.getUsername());
			return true;
		}

		return false;
	}

	public User getUser(Integer id) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("id", id));

		// Convenience method to return a single instance that matches
		// the query, or null if the query returns no results.
		Object result = criteria.uniqueResult();
		tx.commit();
		session.close();
		factory.close();
		if (result != null) {
			User user = (User) result;
			System.out.println("user = " + user.getUsername());
			return user;
		}

		return null;
	}

	
	
	public boolean isValidUser(Integer id) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("id", id));

		// Convenience method to return a single instance that matches
		// the query, or null if the query returns no results.
		Object result = criteria.uniqueResult();
		tx.commit();
		session.close();
		factory.close();
		if (result != null) {
			User user = (User) result;
			System.out.println("user = " + user.getUsername());
			return true;
		}

		return false;
	}

	
	
	public User login(String username, String password) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("username", username));

		// Convenience method to return a single instance that matches
		// the query, or null if the query returns no results.
		Object result = criteria.uniqueResult();
		tx.commit();
		session.close();
		factory.close();

		if (result != null) {
			User user = (User) result;
			if (user.getPassword().equals(password))
				return user;
			// else invalid password
		}
		return null;
	}

	public void deleteUser(String username) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("username", username));

		// Convenience method to return a single instance that matches
		// the query, or null if the query returns no results.
		Object result = criteria.uniqueResult();
		if (result != null) {
			User user = (User) result;
			session.delete(user);
		}
		tx.commit();
		session.close();
		factory.close();
	}

	public String insertUser(User user) {
		if (isValidUser(user.getUsername())) {
			System.err.println("username already exist");
			return "Username Taken"; // user already exist
		}
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
		factory.close();
		return "sucess";
	}

	public List<User> getAll() {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		/*
		 * Employee is class name not table name here
		 */
		Criteria criteria = session.createCriteria(User.class);
		List list = criteria.list();
		tx.commit();
		session.close();
		factory.close();
		return list;
	}
}
