import bean.Data;
import bean.ExamDetail;
import bean.QuesList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;



// This Class is mainly to show all questions from DB , dont go on name
public class LogOut extends HttpServlet {

    Connection conn;
    DatabaseConnection dbconn;
    String query,query1,query2,query3;
    int score;
    public PreparedStatement insert;
    Statement stmt;
    ResultSet res,res1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("())text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        dbconn = new DatabaseConnection();
        conn = dbconn.setConnection();
        String str2=req.getParameter("take2");
        if(str2!=null)
        {
            req.getSession().invalidate();
            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.forward(req,resp);
        }

    }
}
