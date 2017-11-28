package controlador;

import java.util.Date;

import daw.com.Teclado;
import modelo.*;

public class CompraControlador {

	private CompraModelo compra;

	public CompraControlador() {
		this.compra = null;
	}
	
	public CompraControlador(CompraModelo compra) {
		this.compra = compra;
	}

	public CompraModelo getCompra() {
		return compra;
	}
	public void setCompra(CompraModelo compra) {
		this.compra = compra;
	}

	public void leerDatos (){
		leerPK(); 
		leerResto();
	}
	
	public void leerPK(){

		compra.setUsuario(Teclado.leerString("Nif:"));
		compra.getProducto().setRef(Teclado.leerString("Ref:"));
		//LA FECHA SE GENERA AUTOMÁTICAMENTE
		compra.setFecha(new Date(Teclado.leerString("Fecha:")));
	}
	
	public void leerResto(){
		compra.setCantidad(Teclado.leerInt("Cantidad:"));		
		
	}
}
