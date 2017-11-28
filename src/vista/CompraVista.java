package vista;

import modelo.*;
import daw.com.*;

public class CompraVista {

	private CompraModelo compra;

	public CompraVista() {
		this.compra = null;
	}
	
	public CompraVista(CompraModelo compra) {
		this.compra = compra;
	}

	public CompraModelo getCompra() {
		return compra;
	}

	public void setCompra(CompraModelo compra) {
		this.compra = compra;
	}
	
	public void mostrarDatos (){
		Pantalla.escribirString(compra.toString());
	}
	
	public void exito (){
		Pantalla.escribirString("\nOperación realizada con éxito\n");
	}
	
	public void noExito(){
		Pantalla.escribirString("\nError al realizar la operación\n");
	}
	
	public void yaExiste (){
		Pantalla.escribirString("\nCompra ya existente\n"); //es cuasi-imposible que se repita en el mismo milisegundo 
	}
	
	public void noExiste(){
		Pantalla.escribirString("\nCompra no existente\n");
	}
	
	public void exitoUpdate(){
		Pantalla.escribirString("\nCompra actualizado\n");
	}
	
	public void noExitoUpdate(){
		Pantalla.escribirString("\nError al actualizar, compra no existente\n");

	}
	
	public void exitoBorrado(){
		Pantalla.escribirString("\nCompra borrado con éxito\n");

	}
	
	public void noExitoBorrado(){
		Pantalla.escribirString("\nError al borrar compra\n");

	}
	
	public void claveNoExistente(){
		Pantalla.escribirString("\nClave(s) no existente(s)\n");

	}

}
