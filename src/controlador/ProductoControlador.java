package controlador;

import modelo.*;
import daw.com.Teclado;;

public class ProductoControlador {

	private ProductoModelo producto;
	
	public ProductoControlador(){
		this.producto = null;
	}
	
	public ProductoControlador(ProductoModelo producto){
		this.producto = producto;
	}

	public ProductoModelo getProducto() {
		return producto;
	}
	public void setProducto(ProductoModelo producto) {
		this.producto = producto;
	}
	
	public float totalCompra(int cuantos){
		
		float total = cuantos * producto.getPvp();
		
		return total;
	}
	
	public void restarStock(int cuantos){
		producto.setStock(producto.getStock() - cuantos);
	}

	public void leerDatos ()
	{
		leerPK(); 
		leerResto();
	}
	
	public void leerPK(){
		producto.setRef(Teclado.leerString("Ref:"));
	}
	
	public void leerResto(){
		producto.setDescripcion(Teclado.leerString("Descripcion:"));
		producto.setPvp(Teclado.leerFloat("Pvp:"));
		producto.setStock(Teclado.leerInt("Stock:"));
		//SETEAMOS EL NOMBRE (PK) DE LA CATEGORIA
		producto.setCategoria(Teclado.leerString("Categoria:"));
	}
}
