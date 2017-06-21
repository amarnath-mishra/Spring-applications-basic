package Servlet;

import java.io.File;
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
 

@MultipartConfig(fileSizeThreshold=1024*1024*10, 	
                 maxFileSize=1024*1024*50,      	
                 maxRequestSize=1024*1024*100)   	
public class MainServlet extends HttpServlet {
 
private static final String UPLOAD_DIR = "temp";    
private static final long serialVersionUID = 205242440643911308L;

    
     
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
   
        String applicationPath = "/home/amarnath/workspace/ExcelUploadRead/";
        
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
         
       
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());
        
        String fileName = null;
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            int ind=fileName.lastIndexOf('.');
            String ext= fileName.substring(ind+1);
            int index=fileName.lastIndexOf('\\');
            String file_n= fileName.substring(index+1);		
            if(!(ext.compareTo("xls")==0 || ext.compareTo("xlsx")==0))
            {
            	request.setAttribute("error","1");
            	getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
            	flag=1;
            }
            else
            {
            part.write(uploadFilePath + File.separator + file_n);
            }
        }
 

        if(flag==0)
        getServletContext().getRequestDispatcher("/Processor").forward(
                request, response);
    }
 
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
