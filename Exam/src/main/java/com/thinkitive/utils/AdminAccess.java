package com.thinkitive.utils;

import org.springframework.beans.factory.annotation.Autowired;

import com.thinkitive.dao.UserCRUD;
import com.thinkitive.model.User;

public class AdminAccess {
	@Autowired
	private UserCRUD usCrud;

	public String approveUsers(Integer adminID, Integer usrId, String approve) {
		if (isAdmin(adminID)) {
			User user= usCrud.getUser(usrId);
			user.setApprove(approve);
			usCrud.updateUser(user);
			return "success";
		}
		return "You don't have right to perform actions";
	}
	
	private boolean isAdmin(Integer id) {
		User usr= usCrud.getUser(id);
		if(usr.getRole().equals("admin")) {
			return true;
		}
		return false;
	}
	
	
	public String assignRoles(Integer adminID, Integer usrId, String role) {
		if (isAdmin(adminID)) {
			User user= usCrud.getUser(usrId);
			user.setRole(role);
			usCrud.updateUser(user);
			return "success";
		}
		return "You don't have right to perform actions";
	}
	

}
