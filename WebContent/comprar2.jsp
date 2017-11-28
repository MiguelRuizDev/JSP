<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import = "dao.*" %>
<%@ page import = "modelo.*" %>
<%@ page import = "controlador.*" %>
<%@ page import = "javax.servlet.http.HttpSession" %>
<%@ page import = "java.util.*" %>

   
<jsp:useBean id="nuevoUsuario" class="modelo.UsuarioModelo" scope="page"/>

<jsp:setProperty name="nuevoUsuario" property="login"/> 
<jsp:setProperty name="nuevoUsuario" property="password"/> 

    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta http-equiv="refresh" content="5;URL='comprar1.jsp'" />
	<title>Resultado validación</title>
</head>
<body>

	<h2>
		<% 

			UsuarioDAO dao = new UsuarioDAO();
			UsuarioModelo userGenerado = dao.login(nuevoUsuario.getLogin(), nuevoUsuario.getPassword());
			
			if (userGenerado != null){
				ProductoDAO daoprod = new ProductoDAO();
				Iterator <ProductoModelo> iter = daoprod.findAll(); 
				Vector <ProductoModelo> vector = new Vector <ProductoModelo>(); 
				
			
				while (iter.hasNext())
					vector.add(iter.next());
				
				Cesta cesta = new Cesta();			
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("vectorProductos", vector);
				sesion.setAttribute("usuarioLogged", userGenerado);
				sesion.setAttribute("cesta", cesta);
				
				response.sendRedirect("comprar3.jsp");
			}
			else
			 out.print("Error en el log-in, usuario no registrado");

%>
</h2>


</body>
</html>