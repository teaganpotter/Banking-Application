<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.user.User"%>
    <%@ page import="com.banking.Address"%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
    <%
	User user = (User)request.getSession().getAttribute("user");
    Address address = (Address)request.getSession().getAttribute("address");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request Print Monthly Statement</title>
</head>
<body>
	<h1>${user.getFirstName()} ${user.getLastName()}</h1>
	<h2>Printable Monthly Statement</h2>
	<h3>Check your email at ${user.getEmail()} for your printable version of your monthly statement.</h3>

	<a href="accounts.jsp">Return to My Accounts</a>
	<a href="checkingTransactions.jsp">Return to previous page</a>
	

</body>
</html>