/**
 * Created by hp on 3/26/2016.
 */
//public class validateExaminerReg {


import java.sql.Connection;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.lang.model.type.NullType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ValidateExaminerReg extends HttpServlet {

    Connection conn;
    ResultSet res;

    String username, password, query,query1,subject1,subject2,email,temp;
    DatabaseConnection dbconn;
    int store;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("())text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            username = request.getParameter("username");
            password = request.getParameter("pass");
            subject1 =request.getParameter("sub1");
            subject2 =request.getParameter("sub2");
            email = request.getParameter("email");
            // temp = Integer.parseInt(username);

            query = "select * from examiners where username = '" + username + "' and password = '" + password + "'";
            dbconn = new DatabaseConnection();
            conn = dbconn.setConnection();
            res = dbconn.getResult(query, conn);

            if (res.next())
            {
                out.write("You Are Already Registered");
            }
            else{
                query1 = "select max(fac_id) from examiners";
                res = dbconn.getResult(query1, conn);
                if (res.next())
                {
                    store = res.getInt("max(fac_id)");
                    store = store + 1;
                }
                query = "insert into examiners values(?,?,?,?,?,?)";
                dbconn.setvalue(store,username,password,subject1,subject2,email,conn, query);
                out.write("You Are Successfully Registered\n");
                out.write("You Can proceed to LogIn page");
            }

        }
        catch(Exception e){
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
        finally{
            out.close();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}



