<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function ajaxCall() {
		alert("hi");
		var xhttp;
		if (window.XMLHttpRequest) {
			xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (xhttp.readyState == 4 && xhttp.status == 200) {
					document.getElementById("demo").innerHTML = xhttp.responseText;
				}
			};
		} else {
			// code for IE6, IE5
			xhttp = new ActiveXObject("Microsoft.XMLHTTP");
			xhttp.onreadystatechange = function() {
				if (xhttp.readyState == 4 && xhttp.status == 200) {
					document.getElementById("demo").innerHTML = xhttp.responseText;
				}
			};
		}

		xhttp.open("GET",
				"http://www.w3schools.com/ajax/ajax_xmlhttprequest_send.asp",
				true);
		xhttp.send();

	}
</script>
</head>
<body>

	<input type="button" id="inp" onclick="ajaxCall()" value="Hit me!!"></input>
	<p id="demo"></p>

</body>
</html>