<%@ page import="bean.ExamDetail" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="bean.QuesList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="bean.Data" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>LOG IN page</title>
</head>
<body>
<%

  Data dt1;
  int maxQnNo=0,qnNum=0;
  try {
    dt1 = (Data) session.getAttribute("maxViewQn");
    maxQnNo = dt1.geti();
    for (int i = 1; i <= maxQnNo; i++) {
      String ai = request.getParameter(Integer.toString(i));
      if (ai != null) {
        qnNum = i;//QuestionSelected
      }
    }
  }
  catch(Exception e)
  {
  }


  out.println("<h1>In View Ques page </h1>");
  ArrayList<QuesList> books;
  books = (ArrayList<QuesList>) session.getAttribute("questiontoUpdate");

  Iterator it = books.iterator();
  String temp,facc=null;
  QuesList pb = null;
  int idd= 0,right_op=0,mark=0,diff=0;

  String op1 = null,op2=null,op3=null,op4=null;

  String ques = null,subject=null;
  while (it.hasNext()) {
    pb = (QuesList) it.next();
    idd = pb.getquesid();
    ques = pb.getQuestion();
    op1=pb.getOp1();
    op2=pb.getOp2();
    op3= pb.getOp3();
    op4=pb.getOp4();
    subject= pb.getSubject();
    mark=pb.getMarks();
    right_op=pb.getRight_op();
    diff = pb.getDifficulty();
    facc= pb.getFac_name();

  }

%>
<h4>heyyy <%=idd%></h4>
<h4>heyno <%=qnNum%></h4>


<div align="center">
  <p><img src="IIITGLogo.jpg" width="201" height="192" alt=""/></p>
  <p><b>Online Exam System</b></p>
  <h3> Welcome Examiners please fill all entries to Update a question </h3>
</div>
<div align = "center">
  <form action ="UpdateQuesFeed" method ="POST">
    <table>
      <tr>
        <td>Your Question:</td>
        <td><input type="text" id="question" name ="question" value="<%=ques%>" placeholder="<%=ques%>"></td>
      </tr>
      <tr>
        <td>Subject:</td>
        <td><input type="text" id="subject" name ="subject" value="<%=subject%>" placeholder="<%=subject%>"></td>
      </tr>

      <tr>
        <td>Option1:</td>
        <td><input type="text" value="<%=op1%>" name ="option1" placeholder="<%=op1%>"></td>
      </tr>

      <tr>
        <td> Option2 : <input type ="text" value="<%=op2%>" name="option2" placeholder="<%=op2%>" size="20" > </td>
        <br>

        <td>Option3 : <input type ="text" value = "<%=op3%>" name="option3" placeholder="<%=op3%>" size="20" > <br></td>
        <br>
        <td>Option4 : <input type ="text" value="<%=op4%>" name="option4" placeholder="<%=op4%>" size="20" > <br></td>
      </tr>

      <tr>
        <td>Right Option : <input type ="number" name="right_option" value="<%=right_op%>" placeholder="<%=right_op%>" size="11"></td>
      </tr>
      <tr>
        <td>Total Marks : <input type ="number" name="marks" value="<%=mark%>" placeholder="<%=mark%>" size="11"></td>
      </tr>
      <tr>
        <td>Difficulty Level(0-5) : <input type ="number" name="level" value="<%=diff%>" placeholder="<%=diff%>" size="11"></td>
      </tr>
      <tr>
        <td>Ques_Added By(Fac name): <input type ="text" name="fac_name" value="<%=facc%>" placeholder="<%=facc%>" size="11"></td>
      </tr>

      <tr>
        <td></td>
        <td><input type="submit" name="<%=qnNum%>" value="Update Question"></td>
        <td></td>
      </tr>
    </table>

  </form>
</div>
</body>

</html>
