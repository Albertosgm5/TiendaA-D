package ad.store.entity;
import java.util.Date;

public class Venta {
	private long idVenta;
	private long idCliente;
	private Date fechaVentas;
	private float descuento;
	
	public Venta() {
		
	}
	public Venta(long idVenta, float descuento, Date fechaVentas) {
		this.idVenta = idVenta;
		this.fechaVentas = fechaVentas;
		this.descuento = descuento;
	}
	/*public Venta(long idCliente, float descuento, Date fechaVentas) {
		this.idCliente = idCliente;
		this.fechaVentas = fechaVentas;
		this.descuento = descuento;
	}*/
	public Venta(long idVenta, Date fechaVentas, float descuento) {
		this.idVenta = idVenta;
		this.fechaVentas = fechaVentas;
		this.descuento = descuento;
	}
	public long getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}
	public Date getFechaVentas() {
		return fechaVentas;
	}
	public void setFechaVentas(Date fechaVentas) {
		this.fechaVentas = fechaVentas;
	}
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", fechaVentas=" + fechaVentas + ", descuento=" + descuento
				+ "]";
	}
	
	
	
}
