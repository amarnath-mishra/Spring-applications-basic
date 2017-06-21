package com.mvcapp1.controllerpackage;


import java.io.File;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.Part;

public class FileUpload {

	private int flag;
	String fileName = null;
	 
	public int fileUpload(Collection<Part> collection,String uploadFilePath) throws Exception
	{
		
		 //Get all the parts from request and write it to the file on server
        for (Part part : collection) {
            fileName = getFileName(part);
            int ind=fileName.lastIndexOf('.');
            String ext= fileName.substring(ind+1);
            int index=fileName.lastIndexOf('\\');
            String file_n= fileName.substring(index+1);		
            if(!(ext.compareTo("xls")==0 || ext.compareTo("xlsx")==0))
            {
            	flag=1;
            	throw new Exception("extension not valid");
            	      	           	
            }
            else
            {
            part.write(uploadFilePath + File.separator + file_n);
            }
        }
		return flag;
	}
	
	 /**
     * Utility method to get file name from HTTP header content-disposition
     */
	 private String getFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        System.out.println("content-disposition header= "+contentDisp);
	        String[] tokens = contentDisp.split(";");
	        for (String token : tokens) {
	            if (token.trim().startsWith("filename")) {
	            	
	                return token.substring(token.indexOf("=") + 2, token.length()-1);
	            }
	        }
	        return "";
	    }
}
