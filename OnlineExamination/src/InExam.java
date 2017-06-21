

import java.sql.Connection;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InExam extends HttpServlet {

    Connection conn;
    ResultSet res;

    String username, password, query,query1,first_name,last_name,email;
    DatabaseConnection dbconn;
    int store,temp;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("())text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            temp=0;
            username = request.getParameter("username");
            password = request.getParameter("pass");
            first_name =request.getParameter("firstName");
            last_name =request.getParameter("lastName");
            email = request.getParameter("email");
            //temp = Integer.parseInt(username);

            query = "select * from student where username = '" + username + "' and password = '" + password + "'";
            dbconn = new DatabaseConnection();
            conn = dbconn.setConnection();
            res = dbconn.getResult(query, conn);

            if (res.next()) {
                out.write("You Are Already Registered");
            } else {
                query1 = "select max(ID) from student";
                res = dbconn.getResult(query1, conn);
                if (res.next()) {
                    store = res.getInt("max(ID)");
                    store = store + 1;
                }
                query = "insert into student values(?,?,?,?,?,?)";
                dbconn.setvalue(store, username, password,first_name,last_name,email,conn, query);
                out.write("You Are Successfully Registered\n");
                out.write("click on this link to go back to login page- ");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);

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
