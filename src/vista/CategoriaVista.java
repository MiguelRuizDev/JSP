package vista;

import modelo.*;
import daw.com.*;

public class CategoriaVista  {
	
	private CategoriaModelo categoria;

	public CategoriaVista(){
		this.categoria = null;
	}
	
	public CategoriaVista(CategoriaModelo categoria) {
		this.categoria = categoria;
	}
    
	public CategoriaModelo getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaModelo categoria) {
		this.categoria = categoria;
	}
	
	public void mostrarDatos (){
		Pantalla.escribirString(categoria.toString());
	}
	
	public void exito (){
		Pantalla.escribirString("\nOperaci�n realizada con �xito\n");
	}
	
	public void noExito(){
		Pantalla.escribirString("\nError al realizar la operaci�n\n");
	}
	
	public void yaExiste (){
		Pantalla.escribirString("\nCategor�a ya existente\n");
	}
	
	public void noExiste(){
		Pantalla.escribirString("\nCategor�a no existente\n");
	}
	
	public void exitoUpdate(){
		Pantalla.escribirString("\nCategor�a actualizada\n");
	}
	
	public void noExitoUpdate(){
		Pantalla.escribirString("\nError al actualizar, categor�a no existente\n");

	}
	
	public void exitoBorrado(){
		Pantalla.escribirString("\nCategor�a borrada con �xito\n");

	}
	
	public void noExitoBorrado(){
		Pantalla.escribirString("\nError al borrar categor�a\n");

	}

}
