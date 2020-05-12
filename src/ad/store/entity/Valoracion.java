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
@Table(name = "valoracion")
public class Valoracion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idValoracion")
	private long idValoracion;
	@Column(name = "valoracion")
	private int valoracion;
	@ManyToOne
	@JoinColumn(name = "idProducto")
	private Producto producto;
	
	
	public Valoracion(long idValoracion, int valoracion, Producto producto) {
		super();
		this.idValoracion = idValoracion;
		this.valoracion = valoracion;
		this.producto = producto;
	}
	public Valoracion() {
		
	}
	public long getIdValoracion() {
		return idValoracion;
	}
	public void setIdValoracion(long idValoracion) {
		this.idValoracion = idValoracion;
	}
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	@Override
	public String toString() {
		return "Valoracion [idValoracion=" + idValoracion + ", valoracion=" + valoracion + ", producto=" + producto
				+ "]";
	}


}
