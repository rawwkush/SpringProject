package com.Thinkitive;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DatabaseConnection.MyDBConnection;
import QuestionAnswer.Courses;
import QuestionAnswer.Exam;

@RestController
public class ExamController {

//	MyDBConnection db = new MyDBConnection();
//	
//	@PostMapping(value="/addExam")
//	public void addExam(@RequestParam(name ="cName")String cName,@RequestParam(name ="stdId")int sid) {
//		db.startExam(cName, sid);
//	}
//	
//	@PutMapping(value="/submit")
//	public void submit(@RequestParam(name ="examId")Integer eid,@RequestParam(name ="stdId")int sid) {
//		db.submit(sid, eid);
//	}
	
}
