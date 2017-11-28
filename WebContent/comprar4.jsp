<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "dao.*" %>
<%@ page import = "modelo.*" %>
<%@ page import = "controlador.*" %>
<%@ page import = "javax.servlet.http.HttpSession" %>
<%@ page import = "java.util.*" %>

<jsp:useBean id="nuevoProducto" class="modelo.ProductoModelo" scope="page"/>
<jsp:setProperty name="nuevoProducto" property="descripcion"/> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Validación cantidad</title>
</head>
<body>

	<%
		ProductoDAO daoProd = new ProductoDAO();

		//en vez de cogerlo de la base de datos, lo recogemos del vector cargado
		HttpSession sesion = request.getSession();	
		ProductoModelo productoEscogido = new ProductoModelo();
		Vector <ProductoModelo>	vector = (Vector <ProductoModelo>) sesion.getAttribute("vectorProductos");
	
		//cargar un TreeMap con el vector, para luego sacarlo mediante clave del TreeMap
		TreeMap treeMap = new TreeMap();
	
		for (ProductoModelo prod : vector)
			treeMap.put(prod.getDescripcion(),prod);
		
		//le pasamos la ref del nuevoProducto.getDescripcion() y lo buscamos en el vector
		productoEscogido = (ProductoModelo) treeMap.get(nuevoProducto.getDescripcion());
		sesion.setAttribute("productoEscogido", productoEscogido);
		
	%>

	<h2>¿Cuántas unidades del producto <font color="blue"> <%= productoEscogido.getDescripcion()%> </font> desea comprar?</h2>
	
	<form action = "comprar5.jsp" method = get>
		Cantidad:
		<input type="number" min="0" max="<% out.println(productoEscogido.getStock());%>" name="cantidad">
		
		<input type= "submit" value = "Confirmar">
	</form>


</body>
</html>