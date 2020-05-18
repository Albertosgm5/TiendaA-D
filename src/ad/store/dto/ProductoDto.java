package ad.store.dto;

public class ProductoDto {
	
	
	private long idProducto;
	private String nombreProducto;
	private float precio;
	private int stock;
	private String descripcion;
	
	public ProductoDto(long idProducto, String nombreProducto, float precio, int stock, String descripcion) {
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.stock = stock;
		this.descripcion = descripcion;
	}
	public ProductoDto(String nombreProducto, float precio, int stock, String descripcion) {
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.stock = stock;
		this.descripcion = descripcion;
	}
	public ProductoDto() {
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	

}
