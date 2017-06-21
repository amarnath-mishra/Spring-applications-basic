package com.mvcapp1.daopackage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.mvcapp1.controllerpackage.UserData;
@Controller
public class UserDAO {

	
private static HashMap<Integer,UserData> map = new HashMap();

 
	public LinkedList addUser(UserData u)
	{
 	  map.put(u.getId(), u );
 	  return getAll();
	}
	
	
	public LinkedList getAll(){
		LinkedList<UserData> li =  new  LinkedList();
		for (Map.Entry<Integer, UserData> entry : map.entrySet()) {
		   // System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			li.add(entry.getValue());
		}
		return li;
	}

	

	public LinkedList editAndUpdateUser(UserData user) {
	    map.remove(user.getId());
		map.put(user.getId(), user);
	 	  return getAll();
	}


	public LinkedList<UserData> deleteUser(int id) {
		// TODO Auto-generated method stub
		map.remove(id);
		return getAll();
	}


	public UserData editUser(int id) {
		// TODO Auto-generated method stub
		return map.get(id);
	}
	
}
