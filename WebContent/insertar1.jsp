<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "java.util.*" %>
<%@ page import = "dao.CategoriaDAO" %>
<%@ page import = "modelo.CategoriaModelo" %>
<%@ page import = "vista.CategoriaVista" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insertar producto</title>
</head>
<body>

	<h2>Proceda a rellenar los campos del producto a insertar:</h2>

	<form action="insertar2.jsp" method = "get">
		
		<table>
			<tr>
				<td>Referencia:</td> 
				<td><input type="text" name="ref"/></td>
			</tr>
			<tr>
				<td>Descripcion:</td> 
				<td><input type="text" name="descripcion"/></td>
			</tr>
			<tr>
				<td>Pvp:</td> 
				<td><input type="text" name="pvp"/></td>
			</tr>
			<tr>
				<td>Stock:</td> 
				<td><input type="text" name="stock"/></td>
			</tr>
			<tr>
				<!-- creamos el combo, abriendo etiqueta de java  -->
				<td>Categoría:</td>
				<td><select name="categoria">
	
				<% 
					CategoriaDAO dao = new CategoriaDAO();
					Iterator <CategoriaModelo> iter = dao.findAll();
					while (iter.hasNext())
						out.println("<option>"+ iter.next().getNombre()+ "</option>");			
				%>
		
				</select></td>
		</table>
		<br>
		<input type= "submit" value = "Añadir">
	
	</form>

</body>
</html>