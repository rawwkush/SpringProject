package com.thinkitive.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.dao.ExamCRUD;
import com.thinkitive.dao.QuestionCRUD;
import com.thinkitive.dao.ResultCRUD;
import com.thinkitive.dao.UserCRUD;
import com.thinkitive.model.Exam;
import com.thinkitive.model.Question;
import com.thinkitive.model.Result;

@Service
public class StudentAcess {
	@Autowired
	ResultCRUD rsCrud;
	@Autowired
	ExamCRUD exCrud;
	@Autowired
	QuestionCRUD qCrud;
	@Autowired
	UserCRUD usrCrud;
	
	public List<Result> getResult(Integer id) {
		return rsCrud.getResult(id);
	}
	
	public List<Exam> getQuestionIds(String subject) {
		return exCrud.getExam(subject);
	}
	
	public Question getQuestion(Integer questionId) {
		return qCrud.getQuestion(questionId);
	}
	
	public String updateResult(Integer questionId, Integer studentId,String subject, Integer option) {
		if(usrCrud.isValidUser(studentId)) {
			if(qCrud.getQuestion(questionId).getCorrectoption().equals(""+option)) {
				Result result=rsCrud.getSubjectResult(studentId,subject);
				int marks= result.getResult();
				marks++;
				rsCrud.update(studentId, subject, marks);
			}
		}
		return "success";
	}
	
}
