<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

  <title>Online Examination System </title>
  <link href="styles/main.css" rel="stylesheet" type="text/css">
  <script>var __adobewebfontsappname__="dreamweaver"</script><script src="http://use.edgefonts.net/source-sans-pro:n6:default.js" type="text/javascript"></script>

</head>

<body>

<div id="wrapper">
  <header id="top">
    <img src="IIITGLogo.jpg" style="float:left;  height:80px;width:100px; margin-left:0px;margin-top:0px;">
    <h1>Online Examination System</h1>
    <nav id="mainnav">
      <ul>
        <li><a href="sh.html" class="thispage">Home</a></li>

        <li method ="POST"><a href="ShowExam">See Exams</a></li>

        <li><a href="#">Report Card</a></li>
        <li><a href="examiner_register.jsp"> Create Account</a></li>
        <li><a href="indexExaminer.jsp">Login</a></li>
      </ul>
    </nav>
  </header>
  <h1>Question-Paper</h1>
  <form action="LogOut" method="post" >
    <table align="center">
      <%@ page import="java.util.*" %>
      <%@ page import="bean.ExamDetail" %>
      <%@ page import ="bean.Data "%>
      <%@ page import="bean.QuesList" %>
      <% //new java.util.Date() %>
      <tr><td></td>
        <div align="right";margin-right:200px;><input type ="submit" name ="take2" value="Log Out"></div></tr>

    </table>
  </form>


  <form action="HandleExam" method="post">
    <%  ArrayList<QuesList> books;

      books = (ArrayList<QuesList>) session.getAttribute("questions");

      Iterator it = books.iterator();
      String temp;
      QuesList pb = null;
      while (it.hasNext()) {
        pb = (QuesList) it.next();
        temp =Integer.toString(pb.getquesid());
    %>
    <hr>
    <div align="center">
      <% //out.println("<tr><td>" + pb.getquesid() + "</td>  <td></td><td>" + pb.getQuestion() + "</td> <td></td> <td><br>" + pb.getOp1() + "</td> <td></td> <td>" + pb.getOp2()+ "</td> <td></td> <td>" + pb.getOp3()+ "</td> <td></td> <td>" + pb.getOp4() + "</td> <td></td><td></td> <td>" + pb.getMarks()+"</td> <td></td> <td>" + pb.getFac_name() );
        out.println("<tr><h3><span style=\"color:blue;\">Question --></span> " + pb.getQuestion()+"\n"+ "</h3></tr>");
        //out.println("</tr>" +"<tr><td><input type=\"submit\"+ name =\"" + Integer.toString(pb.getquesid()) + "\"value=\"Confrim Answer\"></td></tr>");

        out.println("<tr><br></tr>");
        out.println("<tr><h4><span style=\"color:red;\">op-1-</span>" + pb.getOp1()+"</h4></tr>");
        //out.println("<tr><br></tr>");
        out.println("<tr><h4><span style=\"color:red;\">op-2-</span> " + pb.getOp2() + "</h4></tr>");
        //out.println("<tr><br></tr>");
        out.println("<tr><h4><span style=\"color:red;\">op-3-</span> " + pb.getOp3() + "</h4></tr>");
        //out.println("<tr><br></tr>");
        out.println("<tr><h4><span style=\"color:red;\">op-4-</span>" + pb.getOp4()+"</h4></tr>");
        out.println("<tr><br></tr>");

        try {


          //out.println("<tr><select name=\""+Integer.toString(pb.getquesid()*1000)+"\"> <option value=\"1\">Option1</option> <option value=\"2\">Option2</option> <option value=\"3\">Option3</option> <option value=\"4\">Option4</option> </select>" + "</tr>");
          out.println("<tr><select name=\""+Integer.toString(pb.getquesid()*1000)+"\"> <option value=\"option1\">Option1</option> <option value=\"option2\">Option2</option> <option value=\"option3\">Option3</option> <option value=\"option4\">Option4</option> </select>" + "</tr>");
          out.println("</tr>" +"<tr><td><input type=\"submit\"+ name =\"" + Integer.toString(pb.getquesid()) + "\"value=\"Confrim Answer\"></td></tr>");

          out.println("<tr><br><br></tr>");
          //out.println("\n" + "<h1>error in toggle button </h1>");
          //out.println("<tr><td></td><td></td> <td></td> <td></td> <td></td><td></td></tr>");
        }catch(Exception e){
          out.println(e+ "\n" + "<h1>error in toggle button </h1>");

        }

        // out.println("<tr><td>" + pb.getquesid() + "</td>  <td></td><td>" + pb.getQuestion() + "</td> <td></td> <td><br>" + pb.getOp1() + "</td> <td></td> <td>" + pb.getOp2()+ "</td> <td></td> <td>" + pb.getOp3()+ "</td> <td></td> <td>" + pb.getOp4() + "</td> <td></td><td></td> <td>" + pb.getMarks()+"</td> <td></td> <td>" + pb.getFac_name() );
        //out.println("<tr><td>" + pb.getName() + "</td>  <td></td><td>" + pb.getSub1() + "</td> <td></td> <td>" + pb.getSub2() + "</td> <td></td> <td>" + pb.getSub3() + "</td> <td></td> <td>" + pb.getTotal() + "</td><td></td><td><input type=\"submit\" name=\"" + temp + "\"value=\"Issue\"></td></tr><br>" );

        //out.println("<tr><td><img src=" + pb.getImage() + " style=\"width:94px;height:98px\"></td>  <td></td><td>" + pb.getTitle() + "</td> <td></td> <td>" + pb.getAuthor() + "</td> <td></td> <td>" + pb.getPublicaton() + "</td> <td></td> <td>" + pb.getPrice() + "</td> <td></td> <td>" + pb.getId() + "</td></tr><br>");

        //out.println("<tr><td><img src=" + pb.getImage() + " style=\"width:94px;height:98px\"></td>  <td></td><td>" + pb.getTitle() + "</td> <td></td> <td>" + pb.getAuthor() + "</td> <td></td> <td>" + pb.getPublicaton() + "</td> <td></td> <td>" + pb.getPrice() + "</td> <td></td> <td>" + pb.getQuantity() + "</td></tr><br>");

      }
        Data dt= new Data();
        dt.seti(pb.getquesid());
        session.setAttribute("maxi",dt);
        // out.println(pb.getquesid());
      %>
    </div>
  </form>
  <hr>
  <form action ="FinishExam" method="post">
    <td><input type="submit" value="Finish Exam"></td>
  </form>

  <hr>
  <footer>
    <p>Copyright 2016 Amarnath Mishra</p>
  </footer>

</div>
</body>
</html>