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
<title>Update Address</title>
</head>
<body>
	<h1>${user.getFirstName()} ${user.getLastName()}</h1>
	<h2>Update Your Address</h2>
	<h3>We have your assigned address as ${user.getAddress()}. What would you like to update it to?</h3>
	
	
	<form action="UpdateUserServlet" method="post" class="container">
	<div class="form-group">
			<label for="street">Street</label> <input type="text"
				class="form-control" name="street" id="street">
		</div>
		<div class="form-group">
			<label for="city">City</label> <input type="text"
				class="form-control" name="city" id="city">
		</div>
		<div class="form-group">
			<label for="state">State</label> <input type="text"
				class="form-control" name="state" id="state">
		</div>
		<div class="form-group">
			<label for="zipCode">Zip Code</label> <input type="text"
				class="form-control" name="zipCode" id="zipCode">
		</div>
		<button type="submit" class="btn btn-outline-dark">Update my address!</button>
		<a href="accounts.jsp" class="btn btn-outline-dark">Cancel my check book request</a>
		<a href="requestCheckBook.jsp" class="btn btn-outline-dark">My address is fine, return to previous page</a>
	</form>
	

</body>
</html>