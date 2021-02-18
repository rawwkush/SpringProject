package com.thinkitive.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.thinkitive.model.Exam;

@Service
public class ExamCRUD {
	public ExamCRUD() {
		// TODO Auto-generated constructor stub
	}
	//delete a question from exam
	public void deleteQuestionFromExam(int id) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Exam.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Exam.class).add(Restrictions.eq("id", id));

		// Convenience method to return a single instance that matches
		// the query, or null if the query returns no results.
		Exam result = (Exam) criteria.uniqueResult();
		if (result != null) {
			session.delete(result);
		}
		tx.commit();
		session.close();
		factory.close();
	}

	//insert question in exam
	public void insertExam(Exam exam) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Exam.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(exam);
		tx.commit();
		session.close();
		factory.close();
	}
	
	//get all question of a exam
	public List<Exam> getExam(String subject) {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Exam.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		/*
		 * Employee is class name not table name here
		 */
		Criteria criteria = session.createCriteria(Exam.class).add(Restrictions.eq("subject", subject));
		List list = criteria.list();
		tx.commit();
		session.close();
		factory.close();
		return list;
	}
	
	public List<Exam> getAll() {
		Configuration cfg = new Configuration();
		cfg.addAnnotatedClass(Exam.class);
		SessionFactory factory = cfg.configure().buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		/*
		 * Employee is class name not table name here
		 */
		Criteria criteria = session.createCriteria(Exam.class);
		List list = criteria.list();
		tx.commit();
		session.close();
		factory.close();
		return list;
	}
}
