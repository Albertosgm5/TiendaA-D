package ad.store.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCompra")
	private long idCompra;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProducto")
	private Producto producto;
	@Column(name = "unidades")
	private int unidades;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "precioTotal")
	private float precioT;
	
	
	public Compra(long idCompra, Cliente cliente, Producto producto, int unidades, Date fecha, float precioT) {
		super();
		this.idCompra = idCompra;
		this.cliente = cliente;
		this.producto = producto;
		this.unidades = unidades;
		this.fecha = fecha;
		this.precioT=precioT;
	}

	public Compra() {
	}

	public long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(long idCompra) {
		this.idCompra = idCompra;
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
		producto = producto;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public float getPrecioT() {
		return precioT;
	}

	public void setPrecioT(float precioT) {
		this.precioT = precioT;
	}

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", cliente=" + cliente + ", producto=" + producto + ", unidades="
				+ unidades + ", fecha=" + fecha + ", precioT=" + precioT + "]";
	}

}
