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
  <div align = "center">
    <form action ="ValidateRegister" method ="POST">
      <table height="267">
        <tr>
          <td width="253" height="37">1. Username :
            <input name ="username" type="text" required="required" id="username" placeholder="username/rollno"></td>
          <td width="229">&nbsp;</td>
        </tr>

        <tr>
          <td height="30"> 2. Password ::
            <input name ="pass" type="password" required="required" id="pass" placeholder="password"></td>
          <td>&nbsp;</td>
        </tr>

        <tr>
          <td height="34"> 3(i).First Name:
            <input  name="firstName" type ="text" required="required" size="20" > </td>

          <td>(ii) Last Name :
            <input name="lastName" type ="text" required="required" size="20" > <br></td>
        </tr>
        <tr>
          <td>4. Email - ID :
            <input name="email" type ="email" required="required" placeholder="abc@example.com" > </td>
        </tr>
        <tr>
          <td height="34">5. Address :
            <input type ="text"  name="Address" size="20" > <br></td>
        </tr>
        <tr>
          <td>6. Mobile number :
            <input type ="number" name="mb" size="10"></td>
        </tr>

        <tr>
          <td height="42"> (After filling Reg. form Click here) --&gt;</td>
          <td><input type="submit" value="Register"></td>
          <td width="10"></td>
        </tr>
      </table>
      <p>&nbsp;</p>
    </form>
  </div>
  <footer>
    <p>Copyright 2016 Amarnath Mishra</p>
  </footer>
</div>
</body>
</html>
