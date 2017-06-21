	package com.mvcapp1.controllerpackage;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvcapp1.services.Services;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
public class MyController {
	
	
	@Autowired
	public Services services;
	LinkedList<UserData> usersList;
	
   public void setServices(Services services) {
		this.services = services;
	}


@RequestMapping(value = "/hello", method = RequestMethod.GET)
   public String printHello(ModelMap model) {
      model.addAttribute("message", "Hello Spring MVC Framework!");
      return "hello";
   }
   
@RequestMapping(value = "/adduser", method = RequestMethod.POST)
public String newUser( Model model)
{
return "userform";	
}

   @RequestMapping(value = "/newuser", method = RequestMethod.POST)
	public String newUser(@ModelAttribute("user") UserData user,
			BindingResult result, Model model)
	{
	   System.out.println("\n name is : " + user + result + "\n");
	   
	  // model.addAttribute("Lname", user.getLastName());
	   usersList = services.addUser(user);
	   model.addAttribute("userList", usersList);
	   
		return "showuser";
	   
	}
   
   
   @RequestMapping(value = "/edituser", method = RequestMethod.POST)
	public String editUser(@ModelAttribute("user") UserData user,
			BindingResult result, Model model)
	{
	  // System.out.println("\n name is : " + user + result + "\n");
	   
	  // model.addAttribute("Lname", user.getLastName());
	   usersList = services.addUser(user);
	   model.addAttribute("userList", usersList);
	   
		return "showuser";
	   
	}
   
   
   @RequestMapping(value = "/updateuser/{id}", method = RequestMethod.POST)
  	public String editUserDetails(@PathVariable int id, Model model)
  	{
	   UserData temp = services.editUser(id);
	  usersList =  services.updateUser(temp);
	  model.addAttribute("eFname", temp.getFirstName());
	  model.addAttribute("eLname", temp.getLastName());
	  model.addAttribute("eID", temp.getId());
	   
	  return "editUser";
  	//  return services.updateUser(id);
  		
  	   
  	}
   
   @RequestMapping(value = "/jasonview/{id}", method = RequestMethod.POST)
 	public @ResponseBody UserData ViewInJason(@PathVariable int id, Model model)
 	{
	   UserData temp = services.editUser(id);
	 
	  return temp;
 	//  return services.updateUser(id);
 		
 	   
 	}
   
   @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.POST)
 	public String updateUser( @PathVariable int id,Model model)
 	{
	  usersList =  services.delUser(id);
	  model.addAttribute("userList", usersList);
	   
	  return "showuser";
 	//  return services.updateUser(id);
 		
 	   
 	}
   
   
}