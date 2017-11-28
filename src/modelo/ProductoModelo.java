package modelo;

public class ProductoModelo {

	private String ref;
	private String descripcion;
	private float pvp;
	private int stock;
	private String categoria;
	
	public ProductoModelo (){
		this("", "", 0, 1, "");
	}
	
	public ProductoModelo (String ref, String descripcion, float pvp, int stock, String categoria) {
		this.ref = ref;
		this.descripcion = descripcion;
		this.pvp = pvp;
		this.stock = stock;
		this.categoria = categoria;
	}

	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public float getPvp() {
		return pvp;
	}
	public void setPvp(float pvp) {
		this.pvp = pvp;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	

	@Override
	public String toString() {
		return "ProductoModelo [ref=" + ref + ", descripcion=" + descripcion + ", pvp=" + pvp + ", stock=" + stock + ", categoria=" + categoria + "]";
	}
	
	
	

}
