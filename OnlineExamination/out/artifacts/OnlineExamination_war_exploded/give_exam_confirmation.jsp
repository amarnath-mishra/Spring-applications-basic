<%@ page import="bean.ExamDetail" %>
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
        <li><a href="register.jsp"> Create Account</a></li>
        <li><a href="index.jsp">Login</a></li>
      </ul>
    </nav>
  </header>

  <div align="center">
    <p>												 	<img src="IIITGLogo.jpg" width="182" height="170" alt=""/></p>

    <h2>	Are You Sure To Take This Exam ??? </h1>
    </h2>
    <p style="font-style: italic; font-weight: bold; color: #3F3636;">(if yes then press the Button below)</p>
  </div>
  <%

    ExamDetail exd ;

    exd = (ExamDetail)(session.getAttribute("chosenExam"));
    session.setAttribute( "ExamDetails", exd );

  %>
  <div align="center">
    <form action ="Show_Exam_Ques" method ="POST">
      <table width="133">

        <tr>
          <td width="10"></td>
          <td width="97"><input type="submit" value="Start Exam Chosen"></td>
          <td width="10"></td>
        </tr>
      </table>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p>

    </form>
  </div>
  <footer>
    <p>Copyright 2016 Amarnath Mishra</p>
  </footer>
</div>
</body>
</html>
