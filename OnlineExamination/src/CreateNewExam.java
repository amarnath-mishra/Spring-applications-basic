import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;



public class CreateNewExam extends HttpServlet  {

    Connection conn;
    ResultSet res;

    String examname, department, query,query1,subject1,subject2,subject3;
    int duration,examlevel,examtotal;
    DatabaseConnection dbconn;
    int store,temp;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("())text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            temp=0;
            examname = request.getParameter("examname");
            department = request.getParameter("department");
            subject1 =request.getParameter("sub1");
            subject2 =request.getParameter("sub2");
            subject3 = request.getParameter("sub3");
            examtotal = Integer.parseInt(request.getParameter("total"));
            examlevel = Integer.parseInt(request.getParameter("level"));
            duration = Integer.parseInt(request.getParameter("time"));


                query = "select * from exam where name = '" + examname + "' and department = '" + department + "'";
                dbconn = new DatabaseConnection();
                conn = dbconn.setConnection();
                res = dbconn.getResult(query, conn);

                if (res.next()) {
                    out.write("This (Exam Name & Department) Already Exists");
                } else {
                    query1 = "select max(exam_id) from exam";
                    res = dbconn.getResult(query1, conn);
                    if (res.next()) {
                        store = res.getInt("max(exam_id)");
                        store = store + 1;
                    }


                    query = "insert into exam values(?,?,?,?,?,?,?,?,?)";
                    dbconn.setvalue5(store, examname, department,subject1,subject2,subject3,examtotal,examlevel,duration,conn, query);
                    out.write("Exam Has Successfully Created\n");
                    out.write("click on this link to go back to login page- ");
                    RequestDispatcher rd = request.getRequestDispatcher("adminscreen.jsp");
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
