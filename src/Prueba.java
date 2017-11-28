import dao.*;
import modelo.*;
import vista.*;
import controlador.*;


public class Prueba {

	ProductoModelo producto = new ProductoModelo();
	//UsuarioVista vista = new UsuarioVista(producto);
	ProductoControlador controlador = new ProductoControlador(producto);
	ProductoDAO dao = new ProductoDAO();
	

	//INSERTAR
	/*
	controlador.leerDatos();
	dao.insert(producto);
	
	
	//BORRAR
	//dao.delete("culo");
	
	//ACTUALIZAR
	/*controlador.leerDatos();
	dao.update(producto);*/
	
	//FINDBYKEY
	/*String key = Teclado.leerString("Clave:");
	producto = dao.findByKey(key);
	ProductoVista vista = new ProductoVista(producto);
	vista.mostrarDatos();*/
	

	//FINDALL
	/*
	Iterator <ProductoModelo> al;
	al = dao.findAll();
	
	while (al.hasNext()) { 
		System.out.println(al.next().toString());
	}*/
}
