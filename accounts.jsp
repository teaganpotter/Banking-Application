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
<title>Accounts</title>
</head>
<body>

<h1>Welcome, ${user.getFirstName()} ${user.getLastName()}!</h1>

<div class="dropdown">
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="cdropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Checking Account
  </a>
  <span> 
  Balance = $ ${user.getChecking().getBalancestr()}
  </span>

  <div class="dropdown-menu" aria-labelledby="cdropdownMenuLink">
    <a class="dropdown-item" href="checkingDeposit.jsp">Deposit Cash</a>
    <a class="dropdown-item" href="checkingDepositCheck.jsp">Deposit Check</a>
    <a class="dropdown-item" href="checkingWithdraw.jsp">Withdraw</a>
    <a class="dropdown-item" href="transferToSavings.jsp">Transfer to Savings</a>
    <a class="dropdown-item" href="transferCToOutsideBank.jsp">Transfer to another bank</a>
    <a class="dropdown-item" href="requestCheckBook.jsp">Request check book</a>
    <a class="dropdown-item" href="checkingTransactions.jsp">See transaction history</a>
  </div>
</div>
<hr>
<div class="dropdown">
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="sdropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Savings Account
  </a>

<span> Balance = $ ${user.getSavings().getBalancestr()}</span>

  <div class="dropdown-menu" aria-labelledby="sdropdownMenuLink">
    <a class="dropdown-item" href="savingsDeposit.jsp">Deposit Cash</a>
    <a class="dropdown-item" href="savingsDepositCheck.jsp">Deposit Check</a>
    <a class="dropdown-item" href="savingsWithdraw.jsp">Withdraw</a>
    <a class="dropdown-item" href="transferToChecking.jsp">Transfer to Checking</a>
    <a class="dropdown-item" href="transferSToOutsideBank.jsp">Transfer to another bank</a>
    <a class="dropdown-item" href="savingsTransactions.jsp">See transaction history</a>
  </div>
</div>
<br>
<br>
<br>
<form action="LogoutServlet" method="post">
		<button type="submit">Logout</button>
	</form>
<br>
<br>
<br>
 <a href="areYouSure.jsp">Close My Bank Account</a>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


</body>
</html>