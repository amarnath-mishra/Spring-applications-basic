<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/UserServiceAppMVC/newuser" method="post">
  First name:<br>
  <input type="text" name="firstName" value="Enter first name">
  <br>
  Last name:<br>
  <input type="text" name="lastName" value="Enter last name">
   <br>
    ID:<br>
  <input type="number" name="id" >
  <br><br>
  <input type="submit" value="Submit">
</form>
 
</body>
</html>