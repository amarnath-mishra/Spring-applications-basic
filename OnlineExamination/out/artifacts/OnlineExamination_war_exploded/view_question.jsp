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
  <h3>Questions & related information list </h3>
  <form action="LogOut" method="post" >
    <table align="center">
      <%@ page import="java.util.*" %>
      <%@ page import="bean.ExamDetail" %>
      <%@ page import ="bean.Data "%>
      <% //new java.util.Date() %>
      <tr><td></td>
        <div align="right";margin-right:200px;><input type ="submit" name ="take2" value="Log Out"></div></tr>

    </table>
  </form>

  <form action="Show_questions" method="post">
    <table>
      <%@ page import="java.util.*" %>
      <%@ page import="bean.QuesList" %>
      <%@ page import ="bean.Data "%>
      <h5> Date & Time --> <%= new java.util.Date() %></h5>
      <tr><td></td><input type ="submit" name ="take2" value="Refresh Questions"></tr>
  </form>

  <form action="Show_questions" method="post">
    <%  ArrayList<QuesList> books;
      books = (ArrayList<QuesList>) session.getAttribute("questions");
      Iterator it = books.iterator();
      QuesList pb = null;
      while (it.hasNext()) {
        pb = (QuesList) it.next();%>
    <%

        out.println("<tr><td>" + pb.getquesid() + "</td>  <td></td><td>" + pb.getQuestion() + "</td> <td></td> <td><br>" + pb.getOp1() + "</td> <td></td> <td>" + pb.getOp2()+ "</td> <td></td> <td>" + pb.getOp3()+ "</td> <td></td> <td>" + pb.getOp4() + "</td> <td></td><td></td> <td>" + pb.getMarks()+"</td> <td></td> <td>" + pb.getFac_name() );

    %>
    <form action ="UpdateQues" method ="POST">
      <tr>
        <td></td>
        <td><input type="submit" name = "<%=pb.getquesid()%>" value = "Update This Ques"></td>
        <td></td>
      </tr>
    </form>

    <form action ="DeleteQues" method ="POST">
      <tr>
        <td></td>
        <td><input type="submit" name="<%=pb.getquesid()%>" value="Delete This Ques"></td>
        <td></td>
      </tr>
    </form>


    <%
        //out.println("<tr><td><img src=" + pb.getImage() + " style=\"width:94px;height:98px\"></td>  <td></td><td>" + pb.getTitle() + "</td> <td></td> <td>" + pb.getAuthor() + "</td> <td></td> <td>" + pb.getPublicaton() + "</td> <td></td> <td>" + pb.getPrice() + "</td> <td></td> <td>" + pb.getId() + "</td></tr><br>");

        //out.println("<tr><td><img src=" + pb.getImage() + " style=\"width:94px;height:98px\"></td>  <td></td><td>" + pb.getTitle() + "</td> <td></td> <td>" + pb.getAuthor() + "</td> <td></td> <td>" + pb.getPublicaton() + "</td> <td></td> <td>" + pb.getPrice() + "</td> <td></td> <td>" + pb.getQuantity() + "</td></tr><br>");

      }
      Data dt= new Data();
      dt.seti(pb.getquesid());
      session.setAttribute("maxViewQn",dt);
    %>


    </table>
  </form>
  <footer>
    <p>Copyright 2016 Amarnath Mishra</p>
  </footer>
</div>
</body>
</html>