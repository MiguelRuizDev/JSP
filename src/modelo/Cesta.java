package modelo;
import java.util.*;

public class Cesta {
	
	private Date fechaCesta;
	
	private TreeMap <String, CompraModelo> contenedorCompras;
	
	public Cesta (){
		this.contenedorCompras = new TreeMap();
		this.fechaCesta = new Date();
	}

	public TreeMap<String,CompraModelo> getContenedorCompras() {
		return contenedorCompras;
	}

	public void setContenedorCompras(TreeMap<String,CompraModelo> contenedorCompras) {
		this.contenedorCompras = contenedorCompras;
	}
	
	public void aniadirLineaCompra (CompraModelo lineaCompra){
		lineaCompra.setFecha(fechaCesta);
		contenedorCompras.put(lineaCompra.getProducto().getDescripcion(), lineaCompra);
	}
	
	
		
	
	
	

}
