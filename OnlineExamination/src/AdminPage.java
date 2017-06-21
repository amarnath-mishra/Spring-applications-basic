import bean.ExamDetail;

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


// This Class is mainly to show all exams from DB , dont go on name
public class AdminPage extends HttpServlet {

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
        query = "select * from exam";
        dbconn = new DatabaseConnection();
        conn = dbconn.setConnection();
        ResultSet res;
        res = dbconn.getResult(query,conn);
        try {
            req.getSession().setAttribute("Exams", getResult(res));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("examiners_page.jsp");/*SEE*/
        rd.forward(req,resp);
    }

    private ArrayList<ExamDetail> getResult(ResultSet rs) throws SQLException {
        ArrayList<ExamDetail> result = new ArrayList<ExamDetail>();
        while (rs.next()) {
            ExamDetail ed = new ExamDetail();
            ed.setSub1(rs.getNString("subject1"));
            ed.setSub2(rs.getNString("subject2"));
            ed.setSub3(rs.getNString("subject3"));
            ed.setName(rs.getNString("name"));
            ed.setTotal(rs.getInt("total"));
            //int temp = rs.getInt("quantity");
           // ed.setId(temp);
            /*if(temp!=0)
            {
                ed.setQuantity("Available");
            }
            else{
                ed.setQuantity("Not Available");
            }*/
            result.add(ed);
        }

        return result;
    }
}
