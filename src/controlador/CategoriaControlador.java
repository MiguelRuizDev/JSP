package controlador;

import daw.com.Teclado;
import modelo.*;

public class CategoriaControlador  {
	
	private CategoriaModelo categoria;

	public CategoriaControlador(){
		this.categoria = null;
	}
	
	public CategoriaControlador(CategoriaModelo categoria) {
		this.categoria = categoria;
	}
    
	public CategoriaModelo getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaModelo categoria) {
		this.categoria = categoria;
	}
	
	public void leerDatos(){
		leerPK();
		leerResto ();
	}
	
	public void leerPK() {
		categoria.setNombre(Teclado.leerString("Nombre:"));
	}

	public void leerResto () {
		categoria.setDescripcion(Teclado.leerString("Descripcion:"));
	}
	
	

}
