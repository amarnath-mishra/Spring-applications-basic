import bean.Data;
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
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Get_Taken_ExamID extends HttpServlet {

    Connection conn;
    Statement stmt;
    ResultSet res,res1;


    String username, password, query,query1;
    DatabaseConnection dbconn;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("())text/html;charset=UTF-8");
        int id1=0,id2=0,id3=0;
        PrintWriter out = response.getWriter();
        try{
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date=new Date();
            String dat=dateFormat.format(date);
            /*


             String examID = request.getParameter("temp");
  int id3;
  int id2 = 0;
  Data dt2;
  dt2= (Data) request.getSession().getAttribute("max");
  id3=dt2.geti();//No. Of Products
  for(int i=1;i<=id3;i++){
    String ai = request.getParameter(Integer.toString(i));
    if(ai!=null)
    {
      id2=i;//ProductSelected
    }
  }


             */

            Data dt2;
            dt2= (Data) request.getSession().getAttribute("max");
            id3=dt2.geti();//No. Of Products
            for(int i=1;i<=id3;i++){
                String ai = request.getParameter(Integer.toString(i));
                if(ai!=null)
                {
                    id2=i;//ProductSelected
                }
            }
            Data dt1=new Data();
            dt1.seti(id2);
            Data dt = new Data();
            dt.seti(id3);
            request.getSession().setAttribute("total_exam",dt1);
            request.getSession().setAttribute("chosen_exam_id",dt);




            query = "select name,department,subject1,subject2,subject3 from exam where exam_id ="+Integer.toString(id2);
            out.println(query);
           dbconn = new DatabaseConnection();
            conn = dbconn.setConnection();

            res = dbconn.getResult(query,conn);
            //out.println(res.getNString("subject1"));
            try {
                if (res.next())
                {
                    ExamDetail exdetail = new ExamDetail();
                    exdetail.setid(id2);
                    exdetail.setName(res.getNString("name"));
                    exdetail.setSub1(res.getNString("subject1"));
                    exdetail.setSub2(res.getNString("subject2"));
                    exdetail.setSub3(res.getNString("subject3"));
                    exdetail.setDept(res.getNString("department"));

                    request.getSession().setAttribute("chosenExam", exdetail);
                    out.println(exdetail.getDept());
                    out.println(exdetail.getName());
                }
                else{
                    out.println("\n NO Exams of this id ");
                }

            }
            catch(Exception e)
            {
                out.println("come in catch\n");
                out.println(e);
            }




           RequestDispatcher rd = request.getRequestDispatcher("give_exam_confirmation.jsp");
            rd.forward(request, response);
           /* int temp = 0;
            dbconn=new DatabaseConnection();
            conn = dbconn.setConnection();
            stmt=conn.createStatement();
            int flag=0;
            query="select * from track where user_id = '"+id1+"'";
            res=dbconn.getResult(query,conn);
            if(res.next())
            {
                flag=res.getInt("total");
                if(flag<6) {
                    flag = flag + 1;
                    query = "update track set total = '" + flag + "' where user_id = '" + id1 + "'";
                    stmt.executeUpdate(query);
                }
            }
            else{
                flag=flag+1;
                query="insert into track values('"+id1+"','"+flag+"')";
                stmt.executeUpdate(query);
            }
            if(flag<6) {
                query = "select * from product where product_id = '" + id2 + "'";
                res = dbconn.getResult(query, conn);
                if (res.next()) {
                    temp = res.getInt("quantity");
                }
                temp = temp - 1;
                query = "update product set quantity = '" + temp + "' where product_id = '" + id2 + "'";
                stmt.executeUpdate(query);
                int store = 0;
                query = "select * from cart";
                res = dbconn.getResult(query, conn);
                if (res.next()) {
                    query1 = "select max(order_id) from cart";
                    res1 = dbconn.getResult(query1, conn);
                    if (res1.next()) {
                        store = res1.getInt("max(order_id)");
                        query = "insert into cart values(?,?,?,?)";
                        dbconn.setvalue2(store + 1, id1, id2, dat, conn, query);
                    }

                } else {
                    query = "insert into cart values(?,?,?,?)";
                    dbconn.setvalue2(1, id1, id2, dat, conn, query);
                }

                ProductFetcher fetch = new ProductFetcher();
                fetch.doPost(request, response);
            }
            else{
                RequestDispatcher rd = request.getRequestDispatcher("return.jsp");
                rd.forward(request, response);
            }*/
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
