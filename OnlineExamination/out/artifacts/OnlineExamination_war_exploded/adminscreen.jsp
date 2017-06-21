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

  </div>
  <h1> Welcome Admin </h1>
  <div align="center">
    <form action ="createExam.jsp" method ="POST">
      <p>(To create a new Exam press this button)--&gt;
        <input type="submit" value="Create New Exam">


      </p>
      <p>&nbsp;</p>
    </form>


    <form action ="ShowExam" method ="POST">
      <p>
        (To check all Exams List)--&gt;
        <input type="submit" value="See Exams">


      </p>
      <p>&nbsp;</p>
    </form>
    <p>&nbsp;</p>
    <p>&nbsp;</p>
  </div>
  <footer>
    <p>Copyright 2016 Amarnath Mishra</p>
  </footer>
</div>
</body>
</html>
