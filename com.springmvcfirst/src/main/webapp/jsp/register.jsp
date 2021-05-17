<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Register Page</h1>
<form action="user-register" method="post">
		Username: <input type="text" name="uname" /> <br/>
		Password: <input type="text" name="password" /> <br/>
		Email: <input type="text" name="email" /> <br/>
		<input type="submit" value="Submit" />
		<a href="/SpringMVC/index.jsp">Back to Login</a>
	</form>
</body>
</center>
</html>