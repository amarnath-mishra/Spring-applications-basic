
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

  <title>Faculty Login Page</title>
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
  <script type="text/javascript">
    function validateUsername(){
      var text = document.getElementById("username").value;
      if(text == ""){
        document.getElementById("errorusername").innerHTML = "Provide Username";
        document.getElementById("errorusername").style.color = "red";
      }
      else{
        document.getElementById("errorusername").innerHTML = "OK";
        document.getElementById("errorusername").style.color = "green";
      }
    }
    function validatePassword(){
      var text = document.getElementById("pass").value;
      if(text == ""){
        document.getElementById("errorpassword").innerHTML = "Provide Password";
        document.getElementById("errorpassword").style.color = "red";
      }
      else{
        document.getElementById("errorpassword").innerHTML = "OK";
        document.getElementById("errorpassword").style.color = "green";
      }
    }
  </script>
  <h2 align="center";color="blue">   Welcome on Examiner's Page</h2>
  <p align="center"><img src="IIITGLogo.jpg" width="148" height="143" alt=""/></p>


  <table width="501" align="center">
    <form action="Show_questions" method="post">
      <tr>
        <td colspan="2" align="center"><p><a href="add_question.jsp">*****Click here to Add Questions****</a></p>
          <p>&nbsp;</p></td><td width="173"></td><input type="submit" name="log" value="Log Out"><td width="10"></td>
      </tr>
      <tr>
        <td width="301"><p>
          To View All Questions  Click Below--&gt;
        </p>
          <p>
            <input type="submit" name="issue" value="view all questions">
          </p>
          <p>&nbsp; </p></td>
      </tr>
    </form>
    <form action="Show_questions" method="post">
      <tr>
        <td><p>To view Questions Submitted Click Below --&gt;</p>
          <p>
            <input type="submit" name="return" value="View Questions submitted">
          </p></td>
      </tr>
    </form>

  </table>
  <p>&nbsp;</p>
  <footer>
    <p>Copyright 2016 Amarnath Mishra</p>
  </footer>
</div>
</body>
</html>
