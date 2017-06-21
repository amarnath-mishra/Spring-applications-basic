<%@ page import="bean.ExamDetail" %>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 4/3/2016
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exam_Questions</title>
</head>
<body>
<h1>Here are your questions: </h1>
<% ExamDetail exd ;

  exd = (ExamDetail)(session.getAttribute("ExamDetails"));

  %>
<h2> your exam name is <%= exd.getName()%></h2>
</body>
</html>
