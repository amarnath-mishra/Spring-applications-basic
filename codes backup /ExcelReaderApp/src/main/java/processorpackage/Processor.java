package processorpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Servlet.FileUpload;

/**
 * Servlet implementation class Processor
 */
@WebServlet("/Processor")
public class Processor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String error = "";
	 String ans="";
	 private ValidateAndRead vr ;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Processor() {
		super();
		// TODO Auto-generated constructor stub
	}

	// /**
	// * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	// response)
	// */
	// protected void doGet(HttpServletRequest request, HttpServletResponse
	// response) throws ServletException, IOException {
	// // TODO Auto-generated method stub
	// //response.getWriter().append("Served at:
	// ").append(request.getContextPath());
	//
	//
	// System.out.println("in get");
	//
	// }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		 vr = (ValidateAndRead) context.getBean("validateFile");

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
		FileInputStream fileInputStream = new FileInputStream(file2);

		System.out.println(fileInputStream.toString());

		String ext = temp.substring(temp.lastIndexOf('.') + 1);
		ValidateAndRead vr = new ValidateAndRead();
		error =vr.validatenRead(ext, fileInputStream);
		ans = vr.ans;
		System.out.println(error);
		if (error.length() == 0) {
			
			System.out.println(ans);
			request.setAttribute("ans",ans);
			ans="";
			error="";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/display.jsp");
			dispatcher.forward(request, response);
		} else {
			File dd = new File(dir);
			boolean re = dd.delete();
			if (re == true) {
				System.out.println("file Deleted");
			}
			request.setAttribute("message", error);
			error = "";
			ans="";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/index.jsp");
			dispatcher.forward(request, response);
		}

	}

	

}
