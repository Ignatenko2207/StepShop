<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome!</title>
</head>
<body>
<br>
<%=session.getValue("username")%>

<%!String somestring=""; %>
<br>
<br>
You are authorised!!!

<br>
<br>
Your orders:
<table>
	<tr>
		<td>Good</td>
		<td>Amount</td>
		<td>Order price</td>
		<td>Order date</td>
	
	</tr>
	<tr>
		<td></td>
	
	</tr>
</table>

</body>
</html>