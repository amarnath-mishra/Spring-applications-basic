package Servlet;

import java.io.File;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
@WebServlet("/Data_Show")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
                 maxFileSize=1024*1024*50,      	// 50 MB
                 maxRequestSize=1024*1024*100)   	// 100 MB
public class MainServlet extends HttpServlet {
    private FileUpload fu ;
    private static final long serialVersionUID = 205242440643911308L;
	
    /**
     * Directory where uploaded files will be saved, its relative to
     * the web application directory.
     */
    private static final String UPLOAD_DIR = "temp";
    public void setFu(FileUpload fu) {
		this.fu = fu;
	}


     
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		 fu = (FileUpload) context.getBean("handleFile");
    	
        // gets absolute path of the web application
        String applicationPath = "/home/amarnath/Codes/Assignment_1/";
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        
      //  fu =  new FileUpload();
         
        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        System.out.println("Upload File Directory= "+fileSaveDir.getAbsolutePath());
        
        String fileName = null;
        int flag=0;
        
        try{
        	flag = fu.fileUpload(request.getParts(),uploadFilePath);
        }
        catch(Exception e)
        {
        	if(e.getMessage().equals("extension not valid"));
        	{
        		request.setAttribute("error","1");
            	getServletContext().getRequestDispatcher("/jsp/index.jsp").forward(request, response);
        	}
        }
        
        //Get all the parts from request and write it to the file on server
    
        //request.setAttribute("message", fileName + " File uploaded successfully!");
        if(flag==0)
        getServletContext().getRequestDispatcher("/Processor").forward(
                request, response);
    }
 
  

}