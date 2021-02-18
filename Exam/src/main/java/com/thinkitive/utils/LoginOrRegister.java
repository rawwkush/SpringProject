package com.thinkitive.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.dao.UserCRUD;
import com.thinkitive.model.User;

@Service
public class LoginOrRegister {
	@Autowired
	private UserCRUD crud;
	
	public User doLogin(String username, String password) {
		User user =crud.login(username, password);
		if(user!=null)
			return user;
		return null;
	}
	
	public String doRegister(User user) {
		String msg=crud.insertUser(user);
		return msg;
	}
	
	public String resetPassword() {
		return "todo";
	}
}
