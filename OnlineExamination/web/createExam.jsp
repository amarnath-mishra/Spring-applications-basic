
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title> Examiner's Registration Page</title>
</head>
<body>

<div align="center">
  <p><img src="IIITGLogo.jpg" width="201" height="192" alt=""/></p>
  <p><b>Online Exam System</b></p>
  <h3> Welcome Admin please fill all entries to create a exam </h3>
</div>
<div align = "center">
  <form action ="CreateNewExam" method ="POST">
    <table>
      <tr>
        <td>Examname:</td>
        <td><input type="text" id="examname" name ="examname"></td>
      </tr>

      <tr>
        <td>Department:</td>
        <td><input type="text" id="department" name ="department"></td>
      </tr>

      <tr>
        <td> Subject1 : <input type ="text"  name="sub1" size="20" > </td>

        <td>Subject2 : <input type ="text" name="sub2" size="20" > <br></td>
        <td>Subject3 : <input type ="text" name="sub3" size="20" > <br></td>
      </tr>

      <tr>
        <td>Total : <input type ="number" name="total" size="11"></td>
      </tr>
      <tr>
        <td>Difficulty Level(0-5) : <input type ="number" name="level" size="11"></td>
      </tr>
      <tr>
        <td>Time(hours) : <input type ="number" name="time" size="11"></td>
      </tr>

      <tr>
        <td></td>
        <td><input type="submit" value="CreateExam"></td>
        <td></td>
      </tr>
    </table>

  </form>
</div>
</body>
</html>
