package modelo;

public class LineaDC {
	private long idLineaCompra;
	private Producto producto;
	private Venta venta;
	private float precioProducto;
	
	public LineaDC() {
	}

	public LineaDC(Producto producto, Venta venta, float precioProducto) {
		this.producto = producto;
		this.venta = venta;
		this.precioProducto = precioProducto;
	}

	public LineaDC(long idLineaCompra, Producto producto, Venta venta, float precioProducto) {
		this.idLineaCompra = idLineaCompra;
		this.producto = producto;
		this.venta = venta;
		this.precioProducto = precioProducto;
	}

	public long getIdLineaCompra() {
		return idLineaCompra;
	}
	public void setIdLineaCompra(long idLineaCompra) {
		this.idLineaCompra = idLineaCompra;
	}
	public float getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(float precioProducto) {
		this.precioProducto = precioProducto;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Venta getVenta() {
		return venta;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "LineaDC [idLineaCompra=" + idLineaCompra + ", producto=" + producto + ", venta=" + venta
				+ ", precioProducto=" + precioProducto + "]";
	}
	
}
