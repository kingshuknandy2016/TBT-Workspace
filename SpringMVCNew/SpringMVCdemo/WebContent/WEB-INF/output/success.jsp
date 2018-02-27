<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	
	
		
		<!-- let's add tag srping:url -->
		<spring:url value="/resources/demo.js" var="demoJS" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<script src="${demoJS}"></script>
		<!-- Finish adding tags -->
</head>

<body>
<h1>Hi welcome</h1>

<p>This is first paragraph.</p>  
<p>This is second paragraph.</p>  
<p>This is third paragraph.</p>  

</body>
</html>