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
    <h3> <em>Welcome Examinees please fill all fields to register</em></h3>
  </div>
  <form action ="ValidateExaminerReg" method ="POST">
    <table>
      <tr>
        <td>Username:</td>
        <td><input type="text" id="username" name ="username"></td>
      </tr>

      <tr>
        <td>Password:</td>
        <td><input type="password" id="pass" name ="pass"></td>
      </tr>

      <tr>
        <td> Subject1 : <input type ="text"  name="sub1" size="20" > </td>

        <td>Subject2 : <input type ="text" name="sub2" size="20" > <br></td>
      </tr>
      <tr>
        <td>Email Address : <input type ="email" name="email" > </td>
      </tr>
      <tr>
        <td>Address : <input type ="text"  name="Address" size="20" > <br></td>
      </tr>
      <tr>
        <td>Mobile number : <input type ="number" name="mb" size="10"></td>
      </tr>

      <tr>
        <td></td>
        <td><input type="submit" value="Register"></td>
        <td></td>
      </tr>
    </table>

  </form>
</div>
<footer>
  <p>Copyright 2016 Amarnath Mishra</p>
</footer>
</div>
</body>
</html>
