<%@page import="com.spi.bean.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Show all info...
<jsp:useBean id="obj" class="com.spi.bean.Employee" scope="session"></jsp:useBean>
<jsp:setProperty property="noofyears" name="obj" />

Fname:<jsp:getProperty property="fname" name="obj"/><br>
lname:<jsp:getProperty property="lname" name="obj"/><br>
Address:<jsp:getProperty property="addresss" name="obj"/><br>
Qual:<jsp:getProperty property="qname" name="obj"/><br>
C-name:<jsp:getProperty property="cname" name="obj"/><br>
No of years:<jsp:getProperty property="noofyears" name="obj"/><br>
<%
Object emp=session.getAttribute("obj");

if(emp instanceof Employee)
{
	Employee eref=(Employee)emp;
	out.println(eref.getFname()+"<br>");
	out.println(eref.getLname()+"<br>");
	out.println(eref.getAddresss()+"<br>");
}

%>
</body>
</html>