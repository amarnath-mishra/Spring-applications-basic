<%@ page import="bean.Data" %>
<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 4/3/2016
  Time: 12:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>
<h1>hi,Welcome </h1>
<% String examID = request.getParameter("temp");
  int id3;
  int id2 = 0;
  Data dt2;
  dt2= (Data) request.getSession().getAttribute("max");
  id3=dt2.geti();//No. Of Products
  for(int i=1;i<=id3;i++){
    String ai = request.getParameter(Integer.toString(i));
    if(ai!=null)
    {
      id2=i;//ProductSelected
    }
  }
out.println(id2);
%>

</body>
</html>
