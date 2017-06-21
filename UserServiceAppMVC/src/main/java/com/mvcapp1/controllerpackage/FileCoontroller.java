package com.mvcapp1.controllerpackage;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.mvcapp1.services.Services;

@Controller
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
maxFileSize=1024*1024*50,      	// 50 MB
maxRequestSize=1024*1024*100)   	// 100 MB
public class FileCoontroller {
	@Autowired
	public Services services;

	public void setServices(Services services) {
		this.services = services;
	}
	
	public String uploadnewfile()
	{
		return null;
		
	}
	
	

}
