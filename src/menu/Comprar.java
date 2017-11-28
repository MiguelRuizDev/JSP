package menu;

import java.util.Date;

import dao.*;
import daw.com.Teclado;
import controlador.*;
import vista.*;
import modelo.*;

public class Comprar implements MenuAction{
	
	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
	
		
		UsuarioModelo usuario = new UsuarioModelo ();
		UsuarioControlador controladorUser = new UsuarioControlador (usuario);
		UsuarioVista vistaUser = new UsuarioVista(usuario);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		ProductoModelo producto = new ProductoModelo();
		ProductoControlador controladorProd = new ProductoControlador(producto);
		ProductoVista vistaProd = new ProductoVista(producto);
		ProductoDAO productoDAO = new ProductoDAO();
		
		controladorUser.leerPK();
		
		//SETEAMOS CON EL USUARIO RELLENO
		usuario = usuarioDAO.findByKey(usuario.getNif());
		controladorUser.setUsuario(usuario);
		vistaUser.setUsuario(usuario);
		
	
		if(usuario != null){
			
			boolean bandera = false;//PSEUDO ROLLBACK
			
			while(usuario.getSaldo() > 0 && !bandera){
				
				controladorProd.leerPK();
				
				//CONDICION DE EXISTENCIA DE PRODUCTO
				producto = productoDAO.findByKey(producto.getRef());
				controladorProd.setProducto(producto);
				vistaProd.setProducto(producto);
				
				if(producto != null){
					
					vistaProd.mostrarStock();
					
					int cantidad = Teclado.leerInt("Cuantas unidades desea comprar?");
					
					if(producto.getStock() >= cantidad){ //CONDICION DE SUFICIENTE STOCK
						
						
						if(controladorProd.totalCompra(cantidad) <= usuario.getSaldo()){//CONDICION DE SALDO SUFICIENTE
							
							//SE REALIZA LA COMPRA
							
							CompraModelo compra = new CompraModelo(usuario.getNif(), producto,new Date(), cantidad);
							CompraVista vistaComp = new CompraVista(compra);
							CompraControlador controladorComp = new CompraControlador(compra);
							CompraDAO compraDAO = new CompraDAO();
							
							
							if(compraDAO.insert(compra)){
																	
								//RESTAMOS EL COSTE DE LA COMPRA AL USUARIO Y LA CANTIDAD AL STOCK
								controladorUser.restarSaldo(controladorProd.totalCompra(cantidad));
								controladorProd.restarStock(cantidad);
								
								//ACTUALIZAMOS DATOS EN LA BBDD
								usuarioDAO.update(usuario);
								productoDAO.update(producto);
								
								String respuesta = Teclado.leerString("Sigue comprando? (S/N)");
								
								if (respuesta.equals("N")) //SI "S" EL BUCLE SE REPITE						
																										
									bandera = true;//BANDERA, QUE SALTA SIEMPRE QUE HAYA QUE PARAR EL PROCESO DE COMPRA
								
							}
							else{
								vistaComp.noExito();
								bandera = true;
							}
						}
						else{
							vistaUser.noSaldo();
							bandera = true;
						}
					}
					else{
						vistaProd.noStock();
						bandera = true;
					}
				}
				else{
					vistaProd.noExiste();
					bandera = true;
				}
			}
		}
		else
			vistaUser.noExiste();
			
	}
}
