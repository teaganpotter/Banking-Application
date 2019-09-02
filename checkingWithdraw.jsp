<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.user.User"%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
    <%
	User user = (User)request.getSession().getAttribute("user");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checking Withdraw</title>
</head>
<body>

<h1>${user.getFirstName()} ${user.getLastName()}</h1>
<h2> Withdraw from checking account</h2>

<form action="CWithdrawServlet" method="post" class="container">
		<div class="form-group">
			<label for="amount"> $ </label> <input type="text"
				class="form-control" name="amount" id="amount"
				placeholder="$$$" required/>
		</div>
		<button type="submit" class="btn btn-info">Take my money away!</button>
		<a href="accounts.jsp">Cancel transaction</a>
		
		</form>
	
</body>
</html>