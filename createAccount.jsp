<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
<link rel="stylesheet" type="text/css" href="./styles/styles.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<form action="RegistrationServlet" method="post" class="container">
		<div class="form-group">
			<label for="firstName"> First Name </label> <input type="text"
				class="form-control" name="firstName" id="firstName"
				placeholder="John" required/>
		</div>
		<div class="form-group">
			<label for="lastName"> Last Name</label> <input type="text"
				class="form-control" name="lastName" id="lastName"
				placeholder="Doe" required/>
		</div>
		<div class="form-group">
			<label for="email"> Email Address</label> <input type="text"
				class="form-control" name="email" id="exampleInputEmail1"
				placeholder="johndoe@claimacademybank.com" required/>
		</div>
		<br>Address<br>
		<div class="form-group">
			<label for="street">Street</label> <input type="text"
				class="form-control" name="street" id="street" placeholder="123 Main St." required/>
		</div>
		<div class="form-group">
			<label for="city">City</label> <input type="text"
				class="form-control" name="city" id="city" placeholder="Nowheresville" required/>
		</div>
		<div class="form-group">
			<label for="state">State</label> <input type="text"
				class="form-control" name="state" id="state" placeholder="IL" required/>
		</div>
		<div class="form-group">
			<label for="zipCode">Zip Code</label> <input type="text"
				class="form-control" name="zipCode" id="zipCode"
				placeholder="12345" required/>
		</div>
		<div class="form-group">
			<label for="password">Password</label><input type="password"
			class="form-control" name="password" id="password"
			placeholder="password" required/>
		</div>
		<p>Overdraft protection: opting in for overdraft protection protects your account from withdrawing 
		a balance past zero (resulting in a negative balance). Overdraft protection will not allow transactions 
		that exceed the balance in your account. If you do not opt in for overdraft protection, Claim Academy 
		Bank will allow transactions resulting in negative balances up to $500. Without protection, each of these
		transactions will result in an additional $30. Would you like to sign up for overdraft protection?
		</p>
		<input type="radio" name="hasOverdraftProtection" value="true">Yes
		<input type="radio" name="hasOverdraftProtection" value="false">No<br>
		<button type="submit" class="btn btn-info">Submit</button>
	</form>
</body>
</html>