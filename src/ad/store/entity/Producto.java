package ad.store.entity;

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
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProducto")
	private long idProducto;
	@Column(name = "nombreProducto")
	private String nombreProducto;
	@Column(name = "precio")
	private float precio;
	@Column(name = "stock")
	private int stock;
	@Column(name = "categoria")
	private String categoria;
	@Column(name = "descripcion")
	private String descripcion;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "compra_producto", joinColumns = @JoinColumn(name = "idProducto"), inverseJoinColumns = @JoinColumn(name = "idCompra"))
	private Set<Compra> compras = new HashSet<>();
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Venta> ventas = new HashSet<>();
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Pregunta> preguntas= new HashSet<>();
	

	public Producto(long idProducto, String nombreProducto, float precio, int stock,String categoria, String descripcion) {
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
		this.descripcion = descripcion;
	}
	public Producto(String nombreProducto, float precio, int stock, String categoria, String descripcion) {
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
		this.descripcion = descripcion;
	}
	public Producto() {
	}
	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra>  compras) {
		this.compras =  compras;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
	
	
	public Set<Venta> getVentas() {
		return ventas;
	}
	public void setVentas(Set<Venta> ventas) {
		this.ventas = ventas;
	}
	public Set<Pregunta> getPreguntas() {
		return preguntas;
	}
	public void setPreguntas(Set<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precio=" + precio
				+ ", stock=" + stock +", categoria=" + categoria+", stock=" + descripcion+ "]";
	}
	
}
