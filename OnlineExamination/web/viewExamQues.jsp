<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>View_Questions</title>
</head>
<body>
<h1>Questions</h1>
<form action="Show_questions" method="post">
  <table>
    <%@ page import="java.util.*" %>
    <%@ page import="bean.QuesList" %>
    <%@ page import ="bean.Data "%>
      <%= new java.util.Date() %>
    <tr><td></td><input type ="submit" name ="take2" value="Log Out"></tr>
    </table>
</form>


<form action="HandleExam" method="post">

  <%  ArrayList<QuesList> books;
    int count = 1;
    books = (ArrayList<QuesList>) session.getAttribute("questions");
    Iterator it = books.iterator();
    QuesList pb = null;
    %>
    <div>
      <legend>
    <%

    while (it.hasNext())
    {
      pb = (QuesList) it.next();

      //out.println("<tr><td>" + pb.getquesid() + "</td>  <td></td><td>" + pb.getQuestion() + "</td> <td></td> <td><br>" + pb.getOp1() + "</td> <td></td> <td>" + pb.getOp2()+ "</td> <td></td> <td>" + pb.getOp3()+ "</td> <td></td> <td>" + pb.getOp4() + "</td> <td></td><td></td> <td>" + pb.getMarks()+"</td> <td></td> <td>" + pb.getFac_name() );
      out.println("<tr>Question --> " + pb.getQuestion()+"\n"+ "</tr>");
      out.println("<tr><br></tr>");
      out.println("<tr>(1)- " + pb.getOp1()+"</tr>");
      out.println("<tr><br></tr>");
      out.println("<tr>(2)- " + pb.getOp2() + "</tr>");
      out.println("<tr><br></tr>");
      out.println("<tr>(3)- " + pb.getOp3() + "</tr>");
      out.println("<tr><br></tr>");
      out.println("<tr>(4)- " + pb.getOp4()+"</tr>");
      out.println("<tr><br></tr>");
      out.println("<td></td><td></td> <td></td> <td></td> <td></td><td></td>");
      try {


        //out.println("<tr><select name=\"options\"> <option value=\"1\">Option1</option> <option value=\"2\">Option2</option> <option value=\"3\">Option3</option> <option value=\"4\">Option4</option> </select>" + "</tr>");
        out.println("</tr>" +"<tr><td><input type=\"submit\"+ name =\"" + Integer.toString(pb.getquesid()) + "\"value=\"Confrim Answer\"></td></tr>");

        out.println("<tr><br><br></tr>");
        //out.println("\n" + "<h1>error in toggle button </h1>");
        //out.println("<tr><td></td><td></td> <td></td> <td></td> <td></td><td></td></tr>");
      }catch(Exception e){
        out.println(e+ "\n" + "<h1>error in toggle button </h1>");

      }

     // out.println("<h1>i see you </h1>");
      //out.println("<tr><td><img src=" + pb.getImage() + " style=\"width:94px;height:98px\"></td>  <td></td><td>" + pb.getTitle() + "</td> <td></td> <td>" + pb.getAuthor() + "</td> <td></td> <td>" + pb.getPublicaton() + "</td> <td></td> <td>" + pb.getPrice() + "</td> <td></td> <td>" + pb.getId() + "</td></tr><br>");

      //out.println("<tr><td><img src=" + pb.getImage() + " style=\"width:94px;height:98px\"></td>  <td></td><td>" + pb.getTitle() + "</td> <td></td> <td>" + pb.getAuthor() + "</td> <td></td> <td>" + pb.getPublicaton() + "</td> <td></td> <td>" + pb.getPrice() + "</td> <td></td> <td>" + pb.getQuantity() + "</td></tr><br>");

    }
     Data dt1= new Data();
    dt1.seti(pb.getquesid());
    session.setAttribute("maxi",dt1);
      out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
      out.println(pb.getquesid());
  %>
      </legend>
</div>


</form>
</body>
</html>