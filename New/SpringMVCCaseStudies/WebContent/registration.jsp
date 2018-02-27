<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

${message}

<form action="insert.htm" method="post">
      Eid:<input type="text" name="eid" value=""><br>
        Name:<input type="text" name="name" value=""><br>
          Email-Id:<input type="text" name="emailid" value=""><br>
            Pincode:<input type="text" name="pincode" value=""><br>
              Cell No:<input type="text" name="cellno" value=""><br>
                <input type="submit" name="ok" value="Create"><br>   
   

</form>

</body>
</html>