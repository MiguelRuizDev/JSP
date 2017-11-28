<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Log-In</title>
</head>
<body>
	
 	<h2>Antes de comprar debe validarse, introduzca sus datos de usuario:</h2>

	<form action="comprar2.jsp" method = "post">
		
		<table>
			<tr>
				<td>Login: </td>
				<td><input type="text" name="login"/></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password"/></td>
			</tr>
		</table>
		<br>
		<input type= "submit" value = "Log-In">
	</form>

</body>
</html>