
<%@page import="com.mvcapp1.controllerpackage.UserData"%>
<%@page import="java.util.LinkedList"%>
<%@ page contentType = "text/html; charset = UTF-8" %>
<html>
   <head>
      <title>Hello World</title>
   </head>
   
   <body>
   <form action="/UserServiceAppMVC/adduser" method="post">
    <input type="submit" value="Add more user" />
</form>
   
   <h2> hiheifheifh1221</h2>
       <h2>${Lname}</h2> 
       <table>
       <tr>
       <td> first name  </td>
       <td>last name  </td>
       <td> ID</td>
       
       </tr>
       <% LinkedList<UserData> list =(LinkedList<UserData>) request.getAttribute("userList"); %>
       <%for(UserData uList : list) { %>
       <tr>
       <td> <%= uList.getFirstName() %> </td> 
       <td><%= uList.getLastName()%>  </td>
       <td> <%=uList.getId()%></td>
       
       <td>
   <form action="/UserServiceAppMVC/updateuser/<%=uList.getId()%>" method="post">
    <input type="submit" value="update User" />
</form> <td>

 <td>
   <form action="/UserServiceAppMVC/deleteuser/<%=uList.getId()%>" method="post">
    <input type="submit" value="Delete User" />
</form> <td>

<td>
   <form action="/UserServiceAppMVC/jasonview/<%=uList.getId()%>" method="post">
    <input type="submit" value="View in Jason" />
</form> <td>
       </tr>
       
       
       <%} %>
       
       </table>
       
      
       
   </body>
</html>