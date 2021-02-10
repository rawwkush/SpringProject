package com.Thinkitive;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import DatabaseConnection.MyDBConnection;
import QuestionAnswer.Courses;
import Users.Student;
import Users.Teacher;

@RestController
public class AdminController {

	MyDBConnection db = new MyDBConnection();
	
//	@PostMapping(value="/addCourse")
//	public void addCourse(@RequestBody Courses c) {
//		db.addNewCourse(c);
//	}
//	
	@DeleteMapping(value="/deleteCourse")
	public void deleteCourse(@PathVariable("cName")String cName) {
		db.delCourse(cName);
	}
	
	
	@GetMapping(value="/teacherDetails")
	public List<Teacher> teacherDetails(){
		return db.getAllTeacher();
	}
	
	@DeleteMapping(value="/deleteTeacher/{id}")
	public void deleteteacher(@PathVariable("id")Integer id) {
		db.deleteStudent(id);
	}
	
//	@PutMapping(value="/updateStudent")
//	public void updateStudent(@RequestBody Student std) {
//		System.out.println(std);
//		db.updateStudent(std);
//	}
	
//	@PutMapping(value="/updateTeacher")
//	public void updateTeacher(@RequestBody Teacher t) {
//		System.out.println(t);
//		db.updateTeacher(t);
//	}
	
	@PutMapping(value="/loginTeacher")
	public void teacherLogin(@RequestParam(name ="email")String email,@RequestParam(name ="password")String pass) {
		db.LoginValidateForTeacher(email, pass);
	}
	
	@GetMapping(value="/stdlogin")
	public String studentLogin(@RequestParam(name ="email")String email,@RequestParam(name ="password")String pass) {
		if(db.LoginValidateForStudent(email, pass))
			return "Successfully Loged In";
		else
			return "Invalid Credentials";
	}
	
	@GetMapping(value="getAllStud")
	public List<Student> getAllStudents(){
		return db.getAllStudent();
	}
	
	@GetMapping(value="getAllteacher")
	public List<Teacher> getAllteachers(){
		return db.getAllTeacher();
	}
	
	@DeleteMapping(value="/deleteStudent/{id}")
	public void deleteStudent(@PathVariable("id")Integer id) {
		db.deleteStudent(id);
	}
}
