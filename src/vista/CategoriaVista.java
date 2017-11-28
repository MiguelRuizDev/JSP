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
		Pantalla.escribirString("\nOperación realizada con éxito\n");
	}
	
	public void noExito(){
		Pantalla.escribirString("\nError al realizar la operación\n");
	}
	
	public void yaExiste (){
		Pantalla.escribirString("\nCategoría ya existente\n");
	}
	
	public void noExiste(){
		Pantalla.escribirString("\nCategoría no existente\n");
	}
	
	public void exitoUpdate(){
		Pantalla.escribirString("\nCategoría actualizada\n");
	}
	
	public void noExitoUpdate(){
		Pantalla.escribirString("\nError al actualizar, categoría no existente\n");

	}
	
	public void exitoBorrado(){
		Pantalla.escribirString("\nCategoría borrada con éxito\n");

	}
	
	public void noExitoBorrado(){
		Pantalla.escribirString("\nError al borrar categoría\n");

	}

}
