<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "dao.*" %>
<%@ page import = "modelo.*" %>
<%@ page import = "controlador.*" %>
<%@ page import = "javax.servlet.http.HttpSession" %>
<%@ page import = "java.util.*" %>

<jsp:useBean id="nuevaCompra" class="modelo.CompraModelo" scope="page"/>
<jsp:setProperty name="nuevaCompra" property="cantidad"/> 
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="refresh" content="10;URL='comprar3.jsp'" />
	<title>Validación Saldo</title>
</head>
<body>

	
		<%
	
			UsuarioModelo usuario = new UsuarioModelo();
			ProductoModelo producto = new ProductoModelo();
			Cesta cesta = new Cesta();
			
			HttpSession sesion = request.getSession();
			usuario = (UsuarioModelo) sesion.getAttribute("usuarioLogged");
			producto = (ProductoModelo) sesion.getAttribute("productoEscogido");
			cesta = (Cesta) sesion.getAttribute("cesta");
			
			Float precio = producto.getPvp() * nuevaCompra.getCantidad();
		
			if (usuario.getSaldo() > producto.getPvp() * nuevaCompra.getCantidad()){
		
			CompraModelo lineaCompra = new CompraModelo(usuario.getNif(),producto,nuevaCompra.getCantidad());
		
			//si la línea de compra ya existe, lo que añadimos es la suma de la nueva cantidad, no una línea de compra nueva
			if (cesta.getContenedorCompras().containsKey(producto.getDescripcion())){
				CompraModelo compraExistente = cesta.getContenedorCompras().get(producto.getDescripcion());
				compraExistente.setCantidad(compraExistente.getCantidad() + nuevaCompra.getCantidad());
			}
			else //si la línea de compra no existe, simplemente la añadimos
				cesta.aniadirLineaCompra(lineaCompra);
		
			//actualizar el saldo del usuario
		
			UsuarioControlador controlador = new UsuarioControlador(usuario);
			Float sustraendo = producto.getPvp() * nuevaCompra.getCantidad();
			controlador.restarSaldo(sustraendo);
		
			//actualizar el stock del producto
		
			ProductoControlador controladorProd = new ProductoControlador(producto);
			
			controladorProd.restarStock(nuevaCompra.getCantidad());
			
			response.sendRedirect("comprar6.jsp");		
			}

		%>
	
	<h3> <font color = "blue"> <%=usuario.getNombre() %></font>, tienes <font color = "blue"> <%=usuario.getSaldo() %></font> euros de saldo</h3>
	
	<h3>Tu compra de <font color = "blue"><%= nuevaCompra.getCantidad() %></font> unidades, a <font color = "blue"><%= producto.getPvp() %></font> la unidad, asciende a <font color = "blue"><%= precio %></font> euros </h3>
	
	<h2><font color = "red">Saldo insuficiente</font></h2>



</body>
</html>