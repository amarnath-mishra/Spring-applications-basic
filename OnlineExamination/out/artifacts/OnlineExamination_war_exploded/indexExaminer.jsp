
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
    <h4 align="right">(Examiner's Page)</h4>
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
  <div id="hero">
    <article>
      <h3>login</h3>


      <p>Welcome Examiners(Faculties) please login first </p>

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

      <form action ="ValidateExaminerLogin" method ="POST">
        <table>
          <tr>
            <td>Username:</td>
            <td><input type="text" id="username" name ="username" onblur="validateUsername()""></td>
            <td><label id="errorusername"></label></td>
          </tr>

          <tr>
            <td>Password:</td>
            <td><input type="password" id="pass" name ="pass" onblur="validatePassword()""></td>
            <td><label id="errorpassword"></label></td>
          </tr>

          <tr>
            <td></td>
            <td><input type="submit" value="Login"></td>
            <td></td>
          </tr>


          <tr>

            <td colspan="2" align="center"><a href="examiner_register.jsp">REGISTER</a></td>
          </tr>

        </table>
        <p2><i>Click on register</i> if you are a <b>first</b> time user</p2>
      </form>
    </article>
    <div id ="auto_slide">
      <link rel="stylesheet" >
      <style>
        .mySlides {display:none;}
      </style>
      <body>

      <div class="w3-content w3-section" style="max-width:1000px; height:510px;padding-top: 10px;">

        <img class="mySlides" src="images/Exam1.jpg" style="width:90%; height:495px;">
        <img class="mySlides" src="images/Exam2.jpg" style="width:90%; height:495px">

        <img class="mySlides" src="images/Exam5.jpg" style="width:90%;height:495px">
        <img class="mySlides" src="images/Result1.jpg" style="width:90%;height:495px">

      </div>


      <script>
        var myIndex = 0;
        carousel();

        function carousel() {
          var i;
          var x = document.getElementsByClassName("mySlides");
          for (i = 0; i < x.length; i++) {
            x[i].style.display = "none";
          }
          myIndex++;
          if (myIndex > x.length) {myIndex = 1}
          x[myIndex-1].style.display = "block";
          setTimeout(carousel, 4000);
        }
      </script>
      <hr size="7" color ="gray">
      <div class="side-bar wow animated flipInX" id="NOTICES" align="center"><p style="font-family:'Josefin Slab', serif;font-size:22px; color:rgba(170,34,34,1);font-weight:bold; text-decoration:underline">NOTICES AND ANNOUNCEMENTS</p>
        <div class="Link2 wobble-horizontal" style="font-family:'Josefin Slab', serif;font-size:20px;method="POST""><br><a href="ShowExam" target="_BLANK">   Added New Exams
        </a><br><br></div>
      <div class="Link1 wobble-horizontal" style="font-family:'Josefin Slab', serif;font-size:20px;"> <br>
        <a href="http://iiitg.ac.in/Non_Faculty_Rec.html" target="_BLANK">
          Check your Results
        </a><br><br></div>
    </div>


  </div >
</div>
<footer>
  <p>Copyright 2016 Amarnath Mishra</p>
</footer>
</div>
</body>
</html>
