package com.mvcapp1.services;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mvcapp1.controllerpackage.UserData;
import com.mvcapp1.daopackage.UserDAO;

@Controller
public class Services {
	
	@Autowired
	public UserDAO ud ;
	
	public void setUd(UserDAO ud) {
		this.ud = ud;
	}

	public LinkedList<UserData> addUser(UserData user)
	{
		
	return (LinkedList) ud.addUser(user);	
	}
	
	public LinkedList<UserData> showUser()
	{
		return (LinkedList) ud.getAll();
	}

	public LinkedList updateUser(UserData user) {
		
		return  ud.editAndUpdateUser(user);
	}

	public UserData editUser(int id) {
		
		return ud.editUser(id);
	//	return ud.editAndUpdateUser(id);
	}

	public LinkedList<UserData> delUser(int id) {

		return ud.deleteUser(id);
	}

	
}
