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
import QuestionAnswer.Question;
import Users.Student;
import Users.Teacher;

@RestController
public class TeacherController {

	MyDBConnection db = new MyDBConnection();
	
	@PostMapping(value="/registerTeacher")
	public String Register(@RequestBody Teacher t) {
		db.addNewTeacher(t);
		return "Successfully Registered";
	}
	
	@PutMapping(value="/updateTeacher")
	public String updateStudent(@RequestBody Teacher t, @RequestParam(name="email")String email, @RequestParam(name="password")String pass) {
		if(db.LoginValidateForStudent(email, pass)) {
			db.updateTeacher(t);
			return "Successfully Updated";
		}
		else {
			return "Invalid Credentials";
		}
	}
		
	@PostMapping(value="/addQuestion")
	public Question addQuestion(@RequestBody Question ques) {
		System.out.println(ques);
		db.addQuestion(ques);
		return ques;
	}
	
	@PostMapping(value="/addCourse")
	public Courses addCourse(@RequestBody Courses c) {
		System.out.println(c);
		db.addNewCourse(c);
		return c;
	}
	
	@DeleteMapping(value="/deleteQuestion/{questionId}")
	public void deleteQuestion(@PathVariable("questionId")Integer id) {
		System.out.println(id);
		db.delQuestion(id);
	}
	
	@GetMapping(value="/getAllQues")
	public List<Question> getAllQuestion(){
		return db.getAllQuestions();
	}
	
//	@GetMapping(value="getAllStud")
//	public List<Student> getAllStudents(){
//		return db.getAllStudent();
//	}
	
	@PostMapping(value="/addExam")
	public void addExam(@RequestParam(name ="cName")String cName,@RequestParam(name ="stdId")int sid) {
		db.startExam(cName, sid);
	}
	
	@GetMapping(value="/calculateMarks")
	public void calculateMarks(@RequestBody Student s, @RequestParam(name ="questionId")Integer qid,@RequestParam(name ="answer")String answer) {
		//map.put(qid, answer);
		Question ques = new Question();
		ques.setQuestionId(qid);
		ques.setAnswer(answer);
		
		int marks = db.calculateMarks(s, ques);
		db.updateStudentByMarks(s.getStdId(), marks);
		
		System.out.println(marks);
		System.out.println(s);
		//System.out.println(map);
	}
}
