<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>

<title>Enter Name</title>

</head>

<body>

	<center>

		<h1>Enter name</h1>

		<br />

		<form:form commandName="user" method="POST" name="user">

Name:<form:input path="name" />
			<br />

			<font color="red"><form:errors path="name" /></font>
			<br />

			<input type="submit" value="Save" />

		</form:form>

	</center>

</body>

</html>