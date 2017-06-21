<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Excel data has been validated</h1>
		<h3>Your Data</h3>

		<table border="1">

			<tr>
				<th>ID</th>
				<th>Username</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Address</th>
				<th>Age</th>
				<th>Passing Year</th>
			</tr>
			<%
				if (request.getAttribute("ans") != null) {
					String str= (String)request.getAttribute("ans");
					String mtr="";
					int count=0;
					%>
					<tr>
					<%
					for(int i=0;i<str.length();i++)
					{
						if(count==7)
						{
							count=0;
							%>
							</tr>
							<tr>
						<%}
					
						
						if(str.charAt(i)=='|')
						{
							%><td><%=mtr %></td><% 
									mtr="";
								count++;
						}
						else
						{
							mtr=mtr+str.charAt(i);
						}
					}
						
					
			%>
				


			<%
				}
			%>

		</table>
	</center>
</body>
</html>