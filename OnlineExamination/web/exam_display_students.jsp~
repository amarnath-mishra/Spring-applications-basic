<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Product page</title>
</head>
<body>
<h1>Exams</h1>
<form action="GetProduct" method="post">
  <table>
    <%@ page import="java.util.*" %>
    <%@ page import="bean.ExamDetail" %>
    <%@ page import ="bean.Data "%>
      <%= new java.util.Date() %>
    <tr><td></td><input type ="submit" name ="take2" value="Log Out"></tr>
</form>

<tr>ExamName<td></td><td><b>Subject1</b></td><td></td><td><b>Subject2</b></td><td></td><td><b>Subject3</b></td><td></td><td><b>Total</b>/tr>
  <form action="TakeExam" method="post">
    <%  ArrayList<ExamDetail> books;
      books = (ArrayList<ExamDetail>) session.getAttribute("TakenExams");
      Iterator it = books.iterator();
      ExamDetail pb = null;
      String examName;
      while (it.hasNext()) {
        pb = (ExamDetail) it.next();
        examName = pb.getName();
        out.println("<tr><td>" + pb.getName() + "</td>  <td></td><td>" + pb.getSub1() + "</td> <td></td> <td>" + pb.getSub2() + "</td> <td></td> <td>" + pb.getSub3() + "</td> <td></td> <td>" + pb.getTotal() +"<td></td><td><input type=\"submit\" name=\"\" + Integer.toString(pb.getquesid()) + \"\"value=\"Issue\"></td>" );


        //out.println("<tr><td><img src=" + pb.getImage() + " style=\"width:94px;height:98px\"></td>  <td></td><td>" + pb.getTitle() + "</td> <td></td> <td>" + pb.getAuthor() + "</td> <td></td> <td>" + pb.getPublicaton() + "</td> <td></td> <td>" + pb.getPrice() + "</td> <td></td> <td>" + pb.getId() + "</td></tr><br>");

        //out.println("<tr><td><img src=" + pb.getImage() + " style=\"width:94px;height:98px\"></td>  <td></td><td>" + pb.getTitle() + "</td> <td></td> <td>" + pb.getAuthor() + "</td> <td></td> <td>" + pb.getPublicaton() + "</td> <td></td> <td>" + pb.getPrice() + "</td> <td></td> <td>" + pb.getQuantity() + "</td></tr><br>");

      }
      // Data dt= new Data();
      //dt.seti(pb.getId());
      //session.setAttribute("max",dt);
    %>

    </table>
  </form>
</body>
</html>