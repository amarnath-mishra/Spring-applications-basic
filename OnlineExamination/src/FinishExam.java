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
public class FinishExam extends HttpServlet {

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
        ExamDetail exd;
        int id2 = 0, id3 = 0, id4 = 0, id5 = 0;
        int right_option = 0;

        //exd = (ExamDetail)req.getSession().getAttribute("ExamDetails");

        Data dt4;
        Data dt5;
        Data dt2;


            dt4 = (Data) req.getSession().getAttribute("Identity");
            dt5 = (Data) req.getSession().getAttribute("chosen_exam_id");
            id4 = dt4.geti();
            id5 = dt5.geti();
        query1 = "select score from report where student_id = " + id4 + " and exam_id =" + id5;
        res = dbconn.getResult(query1, conn);
        try {
            if (res.next()) {
                score = res.getInt("score");
                out.println("your score is :"+ score);
            }
            req.getSession().removeAttribute("Identity" );

        } catch (SQLException e) {
            e.printStackTrace();
        }

       // RequestDispatcher rd = req.getRequestDispatcher("ViewExamQn.jsp");
        //rd.forward(req, resp);
    }
    }
