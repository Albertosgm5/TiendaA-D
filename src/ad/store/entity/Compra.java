package ad.store.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCompra")
	private long idCompra;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Cliente> clientes = new HashSet<>();
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "compra_producto", 
	joinColumns = @JoinColumn(name = "idCompra"),
	inverseJoinColumns = @JoinColumn(name = "idProducto"))
	private Set<Producto> productos = new HashSet<>();
	@Column(name = "unidades")
	private int unidades;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "precioTotal")
	private float precioT;
	
	
	

	public Compra(long idCompra, Set<Cliente> clientes, Set<Producto> productos, int unidades, Date fecha,
			float precioT) {
		super();
		this.idCompra = idCompra;
		this.clientes = clientes;
		this.productos = productos;
		this.unidades = unidades;
		this.fecha = fecha;
		this.precioT = precioT;
	}

	public Compra() {
	}

	public long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(long idCompra) {
		this.idCompra = idCompra;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
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
		return "Compra [idCompra=" + idCompra + ", clientes=" + clientes + ", productos=" + productos + ", unidades="
				+ unidades + ", fecha=" + fecha + ", precioT=" + precioT + "]";
	}

}
