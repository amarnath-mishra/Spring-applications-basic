import bean.Data;

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


public class UpdateQuesFeed extends HttpServlet  {

    Connection conn;
    ResultSet res;

    String question,subject, option1,option2,option3,option4,query,query1,fac_name;

    int duration,right_option,difficulty,marks;
    DatabaseConnection dbconn;
    Statement stmt;

    int store,temp;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("())text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Data dt1;
            int maxQnNo=0,qnNum=0;
            try {
                dt1 = (Data) request.getSession().getAttribute("maxViewQn");
                maxQnNo = dt1.geti();
                for (int i = 1; i <= maxQnNo; i++) {
                    String ai = request.getParameter(Integer.toString(i));
                    if (ai != null) {
                        qnNum = i;//QuestionSelected
                    }
                }
                out.println("idddd="+qnNum);
                out.println("iddkk="+maxQnNo);
            }
            catch (Exception e)
            {

            }
            temp=0;
            question = request.getParameter("question");
            fac_name =request.getParameter("fac_name");
            subject =request.getParameter("subject");
            option1 =request.getParameter("option1");
            option2 = request.getParameter("option2");
            option3 =request.getParameter("option3");
            option4 = request.getParameter("option4");
            marks = Integer.parseInt(request.getParameter("marks"));
            difficulty = Integer.parseInt(request.getParameter("level"));
            right_option = Integer.parseInt(request.getParameter("right_option"));

            dbconn = new DatabaseConnection();
            conn = dbconn.setConnection();


            try {
                try {
                    stmt = conn.createStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                query1 = "delete from questions where ques_id ="+qnNum;
                try {
                    stmt.executeUpdate(query1);
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                query = "insert into questions values(?,?,?,?,?,?,?,?,?,?,?)";
                dbconn.setvalue4(qnNum, marks, question, option1, option2, option3, option4, right_option, difficulty, subject,fac_name, conn, query);
            }
            catch(Exception e){
                System.out.println("yoyo");
            }
            out.write("Exam Has Successfully Created\n");
            out.write("click on this link to go back to login page- ");
            RequestDispatcher rd = request.getRequestDispatcher("examiners_page.jsp");
            rd.forward(request, response);

        }
        catch(Exception e){
            Show_questions delQn = new Show_questions();
            delQn.doPost(request, response);
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
