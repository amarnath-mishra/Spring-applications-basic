<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 4/2/2016
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student's Page</title>

</head>
<body>
<h1> Welcome on Student's Page <h1>
  <h1>Welcome <%=session.getAttribute("name")%></h1>

  <form action ="ShowExam" method ="POST">
    <input type="submit" value="See Exams">
  </form>

</body>
</html>
