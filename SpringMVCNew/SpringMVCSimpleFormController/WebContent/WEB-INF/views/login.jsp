<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="ss" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <center>
		<h1>Login Page</h1>
	</center>
	
	<form:form method="POST" action="checkForUser" modelAttribute="loginmodel">
		<table>


			<tr>
				<td>UserName:</td>
				<td><form:input path="username" /></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><form:password  path="password" /></td>
				<td>${msg}</td>
			</tr>




			<tr><td> </td>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>