package com.mvcapp1.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.RequestDispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class Processor {

	private static final long serialVersionUID = 1L;
	String error = "";
	 String ans="";
	 @Autowired
	 private ValidateAndRead vr ;
	 
	 public String dopost(Model model)
	 {

			String dir = "/home/amarnath/Codes/Assignment_1/temp/";
			String temp = "";
			File[] file = new File(dir).listFiles();

			for (File f : file) {
				if (f.isFile()) {
					temp = f.getName();
				}
			}
	       
			dir = dir + temp;
			System.out.println(dir);
			//System.out.println("ni");
			File file2 = new File(dir);
			System.out.println(file2.toString());
			//System.out.println("nirmit");
			FileInputStream fileInputStream = null;
			try {
				fileInputStream = new FileInputStream(file2);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println(fileInputStream.toString());

			String ext = temp.substring(temp.lastIndexOf('.') + 1);
			ValidateAndRead vr = new ValidateAndRead();
			try {
				error =vr.validatenRead(ext, fileInputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ans = vr.ans;
			System.out.println(error);
			if (error.length() == 0) {
				
				System.out.println(ans);
				model.addAttribute("ans", ans);
				//request.setAttribute("ans",ans);
				ans="";
				error="";
				return "display";
//				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/display.jsp");
//				dispatcher.forward(request, response);
			} else {
				File dd = new File(dir);
				boolean re = dd.delete();
				if (re == true) {
					System.out.println("file Deleted");
				}
				model.addAttribute("message", error);
			//	request.setAttribute("message", error);
				error = "";
				ans="";
//				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/index.jsp");
//				dispatcher.forward(request, response);
				return "uploadfile";
			}
	 }
}
