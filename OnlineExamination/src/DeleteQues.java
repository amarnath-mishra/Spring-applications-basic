import bean.Data;
import bean.QuesList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


// This Class is mainly to show all questions from DB , dont go on name
public class DeleteQues extends HttpServlet {

    Connection conn;
    DatabaseConnection dbconn;
    String query;
    Statement stmt;
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
        ResultSet res;
        res = dbconn.getResult(query,conn);
        out.println("I am in DeleteQues");
        Data dt1;
        int maxQnNo=0,qnNum=0;
        try {
            dt1 = (Data) req.getSession().getAttribute("maxViewQn");
            maxQnNo = dt1.geti();
            for (int i = 1; i <= maxQnNo; i++) {
                String ai = req.getParameter(Integer.toString(i));
                if (ai != null) {
                    qnNum = i;//QuestionSelected
                }
            }
        }
        catch (Exception e)
        {

        }
        out.println("qn no ="+ qnNum);

        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        query = "delete from questions where ques_id ="+qnNum;
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Show_questions delQn = new Show_questions();
        delQn.doPost(req, resp);
       /* try {
        req.getSession().setAttribute("questions", getResult(res));
    } catch (SQLException e) {
        e.printStackTrace();
    }

    RequestDispatcher rd = req.getRequestDispatcher("view_question.jsp");
    rd.forward(req,resp);*/

    }


}
