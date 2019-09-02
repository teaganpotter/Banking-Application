<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.user.User"%>
	<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./styles/styles.css">

 <%
	User user = (User)request.getSession().getAttribute("user");
    %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Checking Account Transactions</title>
</head>
<body>
<h1>${user.getFirstName()} ${user.getLastName()}</h1>
<h2> How many transactions would you like to see?</h2>


	<div class="container">
		<div style="margin-top: 100px"></div>
		<div style="width: 300px"></div>
	</div>
	<form action="STransactionHistoryServlet" method="post">
		<div class="form-group">
			<label for="numberOfTransactions"></label> <input
				type="text" class="form-control" name="numberOfTransactions" id="numberOfTransactions"
				placeholder="Number of Transactions">
		</div>
		<button type="submit">See Transaction History</button>
	</form> <hr>
	<form action="SMonthlyTransactionsServlet" method="post">
		<div class="form-group">
			<label for="month"></label> <input
				type="text" class="form-control" name="month" id="month"
				placeholder="Month Number">
		</div>
		<div class="form-group">
			<label for="year"></label> <input
				type="text" class="form-control" name="year" id="year"
				placeholder="Year">
		</div>
		<button type="submit">See My Monthly Statement</button>
	</form>
	<a href="requestPrintStatement.jsp">Send a printable monthly statement to my email!</a>
	<br>
	<br>
	<br>
	<a href="accounts.jsp">Return to My Accounts</a>
	<br>
	<br>
	<br>

	<c:if test="${trans != null}"> 
		<table>
			<tr>
				<th>Date of Transaction</th>
				<th>Type of Transaction</th>
				<th>Amount</th>
			
			</tr>
			<c:forEach var="tran" items="${trans}">
				<tr>
					<td><c:out value="${tran.getDate()}" /></td>
					<td><c:out value="${tran.getType()}" /></td>
					<td><c:out value="${tran.getAmount()}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
</body>
</html>