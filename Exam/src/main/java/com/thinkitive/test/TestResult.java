package com.thinkitive.test;

import com.thinkitive.dao.ResultCRUD;
import com.thinkitive.model.Result;

public class TestResult {
	public static void main(String[] args) {
		add();
	}
	
	private static void add() {
		// TODO Auto-generated method stub
		ResultCRUD crud = new ResultCRUD();
		Result result= new Result();
		result.setStudentid(1);
		result.setSubject("physics");
		result.setResult(60);
		crud.insertResult(result);
	}

}
