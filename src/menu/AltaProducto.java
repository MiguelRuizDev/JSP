package menu;

import dao.*;
import controlador.*;
import vista.*;
import modelo.*;


public class AltaProducto implements MenuAction {

	public AltaProducto(){
		
	}
	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		
		ProductoModelo producto = new ProductoModelo();
		ProductoControlador controlador = new ProductoControlador(producto);
		ProductoVista vista = new ProductoVista(producto);
		ProductoDAO productoDAO = new ProductoDAO(); 
		
		controlador.leerPK();
				
		if(productoDAO.findByKey(producto.getRef()) == null){	
		
			controlador.leerResto();
			
			if (!productoDAO.insert(producto))
				vista.noExito();
		}
		else
			vista.yaExiste();
	}

}
