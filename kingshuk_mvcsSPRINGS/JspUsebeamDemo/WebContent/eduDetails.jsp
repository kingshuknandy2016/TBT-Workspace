<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="obj" class="com.spi.bean.Employee" scope="session"></jsp:useBean>
<jsp:setProperty property="fname" name="obj"/>
<jsp:setProperty property="lname" name="obj"/>
<jsp:setProperty property="addresss" name="obj"/>

<form action="expDetails.jsp">
<input type="text" name="qname" value=""/>
<input type="text" name="cname" value=""/>
<input type="submit" name="Go" value="Login"/>
</form>
</body>
</html>