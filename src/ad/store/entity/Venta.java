package ad.store.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "venta")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVenta")
	private long idVenta;
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "idProducto")
	private Producto producto;
	@Column(name = "unidades")
	private int unidades;
	public Venta(long idVenta, Cliente cliente, Producto producto, int unidades) {
		super();
		this.cliente = cliente;
		this.producto = producto;
		this.unidades = unidades;
	}
	public Venta() {
		
	}
	
	public long getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(long idVenta) {
		this.idVenta = idVenta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", cliente=" + cliente + ", producto=" + producto + ", unidades="
				+ unidades + "]";
	}
	
	
	
}
