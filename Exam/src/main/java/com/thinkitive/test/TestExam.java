package com.thinkitive.test;

import com.thinkitive.dao.ExamCRUD;
import com.thinkitive.model.Exam;

public class TestExam {
	public static void main(String[] args) {
		delete();
	}
	
	private static void add() {
		// TODO Auto-generated method stub
		ExamCRUD crud = new ExamCRUD();
		Exam exam = new Exam();
		exam.setSubject("physics");
		exam.setQuesid(5);
		crud.insertExam(exam);
	}
	
	private static void delete() {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			ExamCRUD crud = new ExamCRUD();
			crud.deleteQuestionFromExam(4);
	}
	
}
