<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload File</title>
</head>
<body>
	<center>
	<h1>Upload the Excel File to Check!</h1>
		<form action="../Data_Show" method="post"
			enctype="multipart/form-data">
			Select File to Upload:<input type="file" name="fileName"> <br><br><br>
			<input type="submit" value="Upload">
			
			<%if(request.getAttribute("error")!=null){ %>
			<p style="color: red;">*Invalid Extension</p>
			<%} %>
		</form>
		<%
			if (request.getAttribute("message") != null) {
		%>

		<p style="color: red;">
			<%
				String str = (String) request.getAttribute("message");
					String mtr = "";
					for (int i = 0; i < str.length(); i++) {

						if (str.charAt(i) == '|') {
			%>
			<br /><%=mtr%><br />
			<%
				mtr = "";
						} else {
							mtr = mtr + str.charAt(i);
						}
					}
			%>

		</p>
		<%
			}
		%>
	</center>
</body>
</html>