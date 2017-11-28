package modelo;

import java.util.Date;


public class CompraModelo {

	private String usuario;
	private ProductoModelo producto;
	private Date fecha;
	private int cantidad;
	
	public CompraModelo (){
		this("", new ProductoModelo(),0);
	}



	public CompraModelo (String usuario, ProductoModelo producto, int cantidad) {
		
		this.usuario = usuario;
		
		this.producto = producto;
		
		this.fecha = new Date();
		
		this.cantidad = cantidad;
	}
	
	public CompraModelo (String usuario, ProductoModelo producto, Date fecha, int cantidad) {
		
		this.usuario = usuario;
		
		this.producto = producto;
		
		this.fecha = fecha;
		
		this.cantidad = cantidad;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public ProductoModelo getProducto() {
		return producto;
	}
	public void setProducto(ProductoModelo producto) {
		this.producto = producto;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	//FUNCIÓN ADICIONAL PARA USAR JUNTO CON EL dao.findByKey
	public String getClaves(){
		return this.usuario + "$$$" + this.producto + "$$$" + this.fecha;
	}
	
	@Override
	public String toString() {
		return "CompraModelo [nif=" + usuario + ", ref=" + producto + ", fecha=" + fecha + ", cantidad=" + cantidad + "]";
	}
}
