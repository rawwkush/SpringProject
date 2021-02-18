package com.thinkitive;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.model.Result;
import com.thinkitive.model.User;
import com.thinkitive.utils.AdminAccess;
import com.thinkitive.utils.LoginOrRegister;
import com.thinkitive.utils.StudentAcess;

@RestController
public class MyController {
	@Autowired
	private LoginOrRegister loginOrRegister;
	@Autowired
	private StudentAcess studentAcess;
	@Autowired
	private AdminAccess adminAccess;
	
	
	
	@PostMapping("/login")
	public User login(User user) {
		User usr = loginOrRegister.doLogin(user.getUsername(), user.getPassword());
		return usr;
	}

	
	@PostMapping("/register")
	public String register(User user) {
		String response=loginOrRegister.doRegister(user);
		return response;
	}

	@GetMapping("/student/result")
	public List<Result> result(@RequestParam(value = "studentId")  Integer id) {
		return studentAcess.getResult(id);
	}

	@GetMapping("/student/question")
	public List<Result> question(@RequestParam(value = "questionId")  Integer id) {
		return studentAcess.getResult(id);
	}

		
	@PostMapping("/student/question/submit")
	public String saveAnswer(@RequestParam(value = "questionId")  Integer questionId,
			@RequestParam(value = "studentId")  Integer studentId,
			@RequestParam(value = "subject")  String subject,
			@RequestParam(value = "option")  Integer option) {
		return studentAcess.updateResult(studentId, questionId,subject, option);
	}
	
	
	
	@PostMapping("/admin/approve")
	public String approveUsers(@RequestParam(value = "adminId")  Integer adminId,
			@RequestParam(value = "studentid")  Integer studentId,
			@RequestParam(value = "apprrove")  String approve) {
		String response=adminAccess.approveUsers(adminId, studentId, approve);
		return response;
	}

	@PostMapping("/admin/assignroles")
	public String assignRoles(@RequestParam(value = "adminId")  Integer adminId,
			@RequestParam(value = "studentid")  Integer studentId,
			@RequestParam(value = "role")  String role) {
		String response=adminAccess.assignRoles(adminId, studentId, role);
		return response;
	}
	
}
