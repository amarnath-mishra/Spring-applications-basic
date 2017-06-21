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


public class  ValidateExaminerLogin extends HttpServlet {

    Connection conn;
    ResultSet res,res2;
    int id,temp;

    String username, password, query,query2;
    DatabaseConnection dbconn;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("())text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
            temp=0;
            username = request.getParameter("username");
            password = request.getParameter("pass");
            request.getSession().setAttribute("examinername",username);
            if((username.equals("admin"))&& (password.equals("admin123")))
            {
                RequestDispatcher rd = request.getRequestDispatcher("adminscreen.jsp");/*SEE*/
                rd.forward(request, response);
            }
            else {

                query = "select * from examiners where username = '" + username + "' and password = '" + password + "'";
                query2 = "select fac_id from examiners where username = '" + username + "' and password = '" + password + "'";
                dbconn = new DatabaseConnection();
                conn = dbconn.setConnection();
                res = dbconn.getResult(query, conn);
                res2 = dbconn.getResult(query2, conn);
                Data dt = new Data();
                if (res.next()) {
                    dt.seti(res.getInt("fac_id"));
                    request.getSession().setAttribute("Identity", dt);
                    RequestDispatcher rd = request.getRequestDispatcher("examiners_page.jsp");/*SEE*/
                    rd.forward(request, response);
                    out.write(username);
                }
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


   /* @Override
    public String getServletInfo() {
        return "Short description";
    }
    private Data getResult(ResultSet rs) throws SQLException {
        int temp=0;
        Data dt = new Data();
        if (rs.next()) {
            ProductBean pbi = new ProductBean();
            pbi.setId(rs.getInt("ID"));
            temp = pbi.getId();
            dt.seti(temp);

        }
        return dt;
    }*/

}
