<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./styles/styles.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="LoginServlet" method="post" class="container">
	<div class="form-group">
			<label for="email"> Email Address</label> <input type="text"
				class="form-control" name="email" id="exampleInputEmail1"
				placeholder="johndoe@claimacademybank.com">
		</div>

	<div class="form-group">
			<label for="password">Password</label><input type="password"
			class="form-control" name="password" id="password"
			placeholder="password">
		</div>
		<button type="submit" class="btn btn-info">Submit</button>
	</form>
</body>
</html>