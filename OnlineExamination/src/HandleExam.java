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
import java.util.ArrayList;


// This Class is mainly to show all questions from DB , dont go on name
public class HandleExam extends HttpServlet {

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
        ExamDetail exd;
        int id2 = 0, id3 = 0, id4 = 0, id5 = 0;
        int right_option =0;

        //exd = (ExamDetail)req.getSession().getAttribute("ExamDetails");
        Data dt2;
        Data dt4;
        Data dt5;
        try {
            dt2 = (Data) req.getSession().getAttribute("maxi");
            dt4 = (Data) req.getSession().getAttribute("Identity");
            dt5 = (Data) req.getSession().getAttribute("chosen_exam_id");
            id3 = dt2.geti();//No. Of Products
            id4 = dt4.geti();
            id5 = dt5.geti();

            for (int i = 1; i <= id3; i++) {
                String ai = req.getParameter(Integer.toString(i));
                if (ai != null) {
                    id2 = i;//ProductSelected
                }
            }
        } catch (Exception e) {
            out.println("This Session is Expired, for giving a exam you have to create a new session ");
        }
        String choice = req.getParameter(Integer.toString(id2 * 1000));
        // Data dt1=new Data();
        //dt1.seti(id2);
        //Data dt = new Data();
        //dt.seti(id3);
        //out.println(id2);
       // out.println("heyyy" + choice);
        //out.println("id " + Integer.toString(id4) + "exam_id " + Integer.toString(id5));
        dbconn = new DatabaseConnection();
        conn = dbconn.setConnection();
        try {
            stmt=conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        query1 = "select score from report where student_id = " + id4 + " and exam_id =" + id5;
        res = dbconn.getResult(query1, conn);
        query3 = "select right_op from questions where ques_id ='" + id2+ "'";
        res1 = dbconn.getResult(query3, conn);

        try {
            if(res1.next())
            {
                right_option= res1.getInt("right_op");
               // out.println("\nRight_op =  \n"+ right_option+"\nchoice ="+choice.charAt(6) );
            }
        } catch (SQLException e) {
            out.println("catch of getting right option\n");
            e.printStackTrace();
        }
        String choosen = Character.toString(choice.charAt(6));


        if(Integer.parseInt(choosen) == right_option) {
    out.println("option matched \n");

    try {
        if (res.next()) {
            out.println("id were already there \n");
            score = res.getInt("score");
            score = score + 4;
            out.println("score" + score);
            query2 = "update report set score ='" + score + "'where student_id = '" + id4 + "' and exam_id = '" + id5 + "'";
            stmt.executeUpdate(query2);


            // insert.executeUpdate();

        } else {
            out.println("created new result id \n");
            score =score +4;
            query = "insert into report (student_id,exam_id,score) values(?,?,?)";
            dbconn.setvalue7(id4, id5, score, conn, query);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("Score could not be extracted\n");
    }
}
else
{
    out.println("Options did not match \n");
}

        RequestDispatcher rd = req.getRequestDispatcher("ViewExamQn.jsp");
        rd.forward(req,resp);
        //String user =  req.getSession().getAttribute("Identity");
        //req.getSession().setAttribute("total_exam",dt1);
        //req.getSession().setAttribute("chosen_exam_id",dt);






       //query = "select * from questions where subject in (\""+exd.getSub1() + "\",\"" + exd.getSub2() + "\",\"" + exd.getSub3() + "\")";

       // res = dbconn.getResult(query,conn);
      /*  try {
            req.getSession().setAttribute("questions", getResult(res));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = req.getRequestDispatcher("viewExamQues.jsp");
        rd.forward(req,resp);*/
    }
/*
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
            ql.setDifficluty(rs.getInt("difficulty"));
            ql.setAnswered("answered");

            //int temp = rs.getInt("quantity");
            // ed.setId(temp);
            /*if(temp!=0)
            {
                ed.setQuantity("Available");
            }
            else{
                ed.setQuantity("Not Available");
            }*
            result.add(ql);
        }

        return result;
    }*/
}
