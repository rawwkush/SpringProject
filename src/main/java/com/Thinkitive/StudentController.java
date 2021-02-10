package com.Thinkitive;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DatabaseConnection.MyDBConnection;
import QuestionAnswer.Courses;
import QuestionAnswer.Question;
import Users.Student;
import Users.Teacher;

@RestController
public class StudentController {

	MyDBConnection db = new MyDBConnection();
	
	
	@PostMapping(value="/registerStd")
	public String Register(@RequestBody Student std) {
		db.addNewStudent(std);
		return "Successfully Registered";
	}
	
	
	@GetMapping(value="/getQuestionByCourseName/{cName}")
	public List<Question> getAllQuestionByCourse(@PathVariable("cName")String cName){
		
		return db.getAllQuestionsByCourse(cName);
	}
	
	@GetMapping(value="/getAllCourses")
	public List<Courses> getAllCourses(){
		return db.getAllCourses();
	}
	
	@PutMapping(value="/updateStudent")
	public String updateStudent(@RequestBody Student std, @RequestParam(name="email")String email, @RequestParam(name="password")String pass) {
		System.out.println(std);
		if(db.LoginValidateForStudent(email, pass)) {
			db.updateStudent(std);
			return "Successfully Updated";
		}
		else {
			return "Invalid Credentials";
		}
	}
	
	@GetMapping(value="/getStudent/{stdId}")
	public Student getStudentById(@PathVariable(name="stdId")Integer stdId) {
		return db.getStudentById(stdId);
	}
	
	@PutMapping(value="/submit")
	public void submit(@RequestParam(name ="examId")Integer eid,@RequestParam(name ="stdId")int sid) {
		db.submit(sid, eid);
	}
}
