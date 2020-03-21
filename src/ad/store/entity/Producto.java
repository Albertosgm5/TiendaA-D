package ad.store.entity;


public class Producto {
	private long idProducto;
	private String nombreProducto;
	private float precio;
	private int stock;
	
	public Producto(long idProducto, String nombreProducto, float precio, int stock) {
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.stock = stock;
	}
	public Producto(String nombreProducto, float precio, int stock) {
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.stock = stock;
	}
	public Producto() {
	}
	public long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precio=" + precio
				+ ", stock=" + stock + "]";
	}
	
}
