<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>LOGIN</h1>

<%=(String)request.getAttribute("error_msg") %>

<form method="post" action="MainController">
	<input type="hidden" name="page" value= "loginForm">
	<label>Username: </label>
	<input type="text" name="username" value="<%=request.getAttribute("username") %>">
	<br> <br>
	<label>Password: </label>
	<input type="password" name="password">
	<br> <br>
	<input type="submit" value="login">
</form>
</body>
</html>