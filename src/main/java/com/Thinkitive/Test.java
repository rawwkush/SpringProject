package com.Thinkitive;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import DatabaseConnection.MyDBConnection;
import QuestionAnswer.Courses;
import Users.Student;

public class Test {

	public static void main(String[] args) {
		
		MyDBConnection db = new MyDBConnection();
		
		db.addQuestion("DBMS", "What is the maximun size of pendrive", "8GB", "4GB", "4TB", "None", "4GB");
	
	
//		Student s = new Student();
//		s.setAddress("2B, Delhi");
//		s.setN
//		db.updateStudent(null);
		
		
	}
}
