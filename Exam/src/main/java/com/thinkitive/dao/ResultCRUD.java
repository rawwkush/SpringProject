package com.thinkitive.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.thinkitive.model.Question;
import com.thinkitive.model.Result;
import com.thinkitive.model.User;

@Service
public class ResultCRUD {
	public ResultCRUD() {
		// TODO Auto-generated constructor stub
	}

	public void update(int studentId, String subject, int result) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(User.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class).
				add(Restrictions.eq("studentid", studentId)).
				add(Restrictions.eq("subject", subject));
		// Convenience method to return a single instance that matches
		// the query, or null if the query returns no results.
		Result rs = (Result) criteria.uniqueResult();
		rs.setResult(result);
		session.update(rs);
		tx.commit();
		session.close();
		factory.close();

	}

	public List<Result> getResult(int studenid) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Result.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Result.class).add(Restrictions.eq("studentid", studenid));
		List list = criteria.list();
		tx.commit();
		session.close();
		factory.close();
		return list;
	}

	public Result getSubjectResult(int studenid, String subject) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Result.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Result.class).
				add(Restrictions.eq("studentid", studenid)).
				add(Restrictions.eq("subject", subject));
		Result result =(Result) criteria.uniqueResult();
		tx.commit();
		session.close();
		factory.close();
		return result;
	}
	
	
	public void insertResult(Result result) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Result.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(result);
		tx.commit();
		session.close();
		factory.close();
	}

	public List<Result> getAll() {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Result.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		/*
		 * Question is a class name, not table name here
		 */
		Criteria criteria = session.createCriteria(Result.class);
		List list = criteria.list();
		tx.commit();
		session.close();
		factory.close();
		return list;
	}

}
