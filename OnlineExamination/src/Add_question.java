import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;



public class Add_question extends HttpServlet  {

    Connection conn;
    ResultSet res;

    String question,subject, option1,option2,option3,option4,query,query1,fac_name;

    int duration,right_option,difficulty,marks;
    DatabaseConnection dbconn;
    int store,temp;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("())text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
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


            query = "select * from questions where question = '" + question + "' and subject = '" + subject + "'";
            dbconn = new DatabaseConnection();
            conn = dbconn.setConnection();
            res = dbconn.getResult(query, conn);

            if (res.next()) {
                out.write("This ( Question & Subject Combination ) Already Exists");
            } else {
                query1 = "select max(ques_id) from questions";
                res = dbconn.getResult(query1, conn);
                    if (res.next()) {
                        store = res.getInt("max(ques_id)");
                        store = store + 1;
                    }

                try {
                    query = "insert into questions values(?,?,?,?,?,?,?,?,?,?,?)";
                    dbconn.setvalue4(store, marks, question, option1, option2, option3, option4, right_option, difficulty, subject,fac_name, conn, query);
                }
                catch(Exception e){
                    System.out.println("yoyo");
                }
                out.write("Exam Has Successfully Created\n");
                out.write("click on this link to go back to login page- ");
               RequestDispatcher rd = request.getRequestDispatcher("examiners_page.jsp");
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
