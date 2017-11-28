<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import = "dao.*" %>
<%@ page import = "modelo.*" %>
<%@ page import = "controlador.*" %>
<%@ page import = "javax.servlet.http.HttpSession" %>
<%@ page import = "java.util.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Validación Producto</title>
</head>
<body>

	<%
		Vector <ProductoModelo> vector = new Vector();
		UsuarioModelo usuario = new UsuarioModelo();
		HttpSession sesion = request.getSession();
		vector = (Vector <ProductoModelo>) sesion.getAttribute("vectorProductos"); //OJO AL CAST
		usuario = (UsuarioModelo) sesion.getAttribute("usuarioLogged");
	%>
	
	<h2>Bienvenido, <font color="blue"> <%=usuario.getNombre() %></font></h2>
	<h2>Su saldo actual: <font color="blue"> <%= usuario.getSaldo() %></font></h2>

	<h3>Elija el producto que desee comprar:</h3>
	
	<form action="comprar4.jsp">
	Producto:
	<select name="descripcion">
	

	
	<% 
		ProductoDAO dao = new ProductoDAO();

		Iterator <ProductoModelo> iter = dao.findAll();
		
		while (iter.hasNext()){
			out.println("<option>"+ iter.next().getDescripcion()+ "</option>");
		}

	%>
	
	</select>
	
	<input type= "submit" value = "Confirmar">
	
	</form>

 

</body>
</html>