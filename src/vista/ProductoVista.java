package vista;

import modelo.*;
import daw.com.*;

public class ProductoVista {

	private ProductoModelo producto;

	public ProductoVista() {
		this.producto = null;
	}
	
	public ProductoVista(ProductoModelo producto) {
		this.producto = producto;
	}

	public ProductoModelo getProducto() {
		return producto;
	}
	public void setProducto(ProductoModelo producto) {
		this.producto = producto;
	}
	
	public void mostrarDatos (){
		Pantalla.escribirString(producto.toString());
	}
	
	public void mostrarStock(){
		System.out.println("\nHay " + producto.getStock() +"unidades en stock\n");
	}
	
	public void exito (){
		Pantalla.escribirString("\nOperación realizada con éxito\n");
	}
	
	public void noExito(){
		Pantalla.escribirString("\nError al realizar la operación\n");
	}
	
	public void yaExiste (){
		Pantalla.escribirString("\nProducto ya existente\n");
	}
	
	public void noExiste(){
		Pantalla.escribirString("\nProducto no existente\n");
	}
	
	public void exitoUpdate(){
		Pantalla.escribirString("\nProducto actualizado\n");
	}
	
	public void noExitoUpdate(){
		Pantalla.escribirString("\nError al actualizar, producto no existente\n");

	}
	
	public void exitoBorrado(){
		Pantalla.escribirString("\nProducto borrado con éxito\n");

	}
	
	public void noExitoBorrado(){
		Pantalla.escribirString("\nError al borrar producto\n");

	}
	
	public void noStock(){
		Pantalla.escribirString("\nSin existencias\n");

	}
}
