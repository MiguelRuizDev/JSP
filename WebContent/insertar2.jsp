<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "dao.ProductoDAO" %>

<jsp:useBean id="nuevoProducto" class="modelo.ProductoModelo" scope="page"/>
<jsp:setProperty name="nuevoProducto" property="*"/>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="refresh" content="5;URL='index.html'" />
	<title>Resultado de insertar</title>
</head>
<body>

	<h2>
		<% 
		 	ProductoDAO dao = new ProductoDAO();
			if (dao.insert(nuevoProducto))
				out.println("Producto dado de alta correctamente");
			else
				out.println("El producto no se ha podido insertar");
		%>
	</h2>

<table border = "1">
<tr><td>Referencia: </td><td><jsp:getProperty name="nuevoProducto" property="ref"/></td></tr>
<tr><td>Descripción: </td><td><jsp:getProperty name="nuevoProducto" property="descripcion"/></td></tr>
<tr><td>Pvp: </td><td><jsp:getProperty name="nuevoProducto" property="pvp"/></td></tr>
<tr><td>Stock: </td><td><jsp:getProperty name="nuevoProducto" property="stock"/></td></tr>
<tr><td>Categoría: </td><td><jsp:getProperty name="nuevoProducto" property="categoria"/></td></tr>
</table>

</body>
</html>