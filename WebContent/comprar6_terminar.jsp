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
	<meta http-equiv="refresh" content="5;URL='index.html'" />
	<title>Finalizando</title>
</head>
<body>

	<%
		Cesta cesta = new Cesta();
		CompraModelo lineaCompra= new CompraModelo();
		CompraDAO daoCompra = new CompraDAO();
		
		HttpSession sesion = request.getSession();
		cesta = (Cesta) sesion.getAttribute("cesta");
		TreeMap <String,CompraModelo> contenedorCompras = cesta.getContenedorCompras();
		
		//insertamos línea de compra en BD
		for (CompraModelo comp : contenedorCompras.values()){
			daoCompra.insert(comp);
			
			//por cada línea de compra, hay una actualización de stock
			ProductoModelo producto = new ProductoModelo();
			producto = comp.getProducto();
			ProductoControlador controladorProd = new ProductoControlador(producto);
			controladorProd.restarStock(comp.getCantidad());
			
			ProductoDAO daoProd = new ProductoDAO();
			daoProd.update(producto);
		}
		
		//actualizamos el saldo 
		UsuarioModelo usuario = new UsuarioModelo();
		usuario = (UsuarioModelo) sesion.getAttribute("usuarioLogged");
		UsuarioDAO daoUser = new UsuarioDAO();
		daoUser.update(usuario);
		
		//finalizamos sesion
		sesion.invalidate();	
	%>

	<h2>Compra realizada</h2>
	
	<h3>Gracias por usar nuestros sevicios</h3>

</body>
</html>