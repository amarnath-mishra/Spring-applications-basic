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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


// This Class is mainly to show all questions from DB , dont go on name
public class UpdateQues extends HttpServlet {

    Connection conn;
    DatabaseConnection dbconn;
    String query;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("())text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        ExamDetail exd ;

        exd = (ExamDetail)req.getSession().getAttribute("ExamDetails");


        dbconn = new DatabaseConnection();
        conn = dbconn.setConnection();
        ResultSet res;

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
            query = "select * from questions where ques_id ="+ qnNum;
            res = dbconn.getResult(query,conn);
            req.getSession().setAttribute("questiontoUpdate", getResult(res));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("update_ques.jsp");/*SEE*/
        rd.forward(req,resp);
    }

    private ArrayList<QuesList> getResult(ResultSet rs) throws SQLException {
        ArrayList<QuesList> result = new ArrayList<QuesList>();
        while (rs.next()) {
            QuesList ql = new QuesList();
            ql.setQuestion(rs.getNString("question"));
            ql.setOp1(rs.getNString("option1"));
            ql.setOp2(rs.getNString("option2"));
            ql.setOp3(rs.getNString("option3"));
            ql.setOp4(rs.getNString("option4"));
            ql.setFac_name(rs.getNString("quesBy"));
            ql.setSubject(rs.getNString("subject"));
            ql.setMarks(rs.getInt("marks"));
            ql.setquesid(rs.getInt("ques_id"));
            ql.setRight_op(rs.getInt("right_op"));
            ql.setDifficulty(rs.getInt("difficulty"));
            ql.setAnswered("not answered");

            //int temp = rs.getInt("quantity");
            // ed.setId(temp);
            /*if(temp!=0)
            {
                ed.setQuantity("Available");
            }
            else{
                ed.setQuantity("Not Available");
            }*/
            result.add(ql);
        }

        return result;
    }
}
