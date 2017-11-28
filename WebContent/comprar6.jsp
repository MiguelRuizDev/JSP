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
	<title>Mostrar Cesta</title>
</head>
<body>

	<h2>Productos comprados hasta el momento:</h2>
	
	<%
		Cesta cesta = new Cesta();
		CompraModelo lineaCompra= new CompraModelo();
		
		HttpSession sesion = request.getSession();
		cesta = (Cesta) sesion.getAttribute("cesta");
		UsuarioModelo usuario = new UsuarioModelo();
		usuario = (UsuarioModelo) sesion.getAttribute("usuarioLogged");

		TreeMap <String,CompraModelo> contenedorCompras = cesta.getContenedorCompras();

		ProductoDAO dao = new ProductoDAO();

	%>

	<table border = "2" >

		<tr>
			<th> Producto</th>
			<th> Cantidad</th>
		</tr>
			<%
				for ( CompraModelo comp : contenedorCompras.values()){ //atención al ".values()"
					out.println("<tr>");
					out.println("<td>");
					out.println(comp.getProducto().getDescripcion());
					out.println("</td>");
					out.println("<td>");
					out.println(comp.getCantidad());
					out.println("</td>");
					out.println("</tr>");
					}
			%>

		</table>

		<h2> Precio total compra: <font color="blue"><%

									float total = 0;

									for (CompraModelo compra : contenedorCompras.values())
										total += compra.getProducto().getPvp() * compra.getCantidad();

										out.println(total);

									%>
		</font></h2>
		
		<h2> Saldo restante: <font color = "blue"> <%=usuario.getSaldo() %></font></h2>

		<form action = "comprar3.jsp" method = "get">
			<input type= "submit" value = "Seguir comprando">	
		</form>
		<br>
		<form action = "comprar6_terminar.jsp" method = "get">
			<input type= "submit" value = "Terminar compra">
		</form>
		<br>
		<form action = "comprar6_abandonar.jsp" method = "get">
			<input type= "submit" value = "Abandonar compra">
		</form>

</body>
</html>