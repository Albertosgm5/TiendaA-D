package ad.store.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCompra")
	private long idCompra;
	@Column(name = "idCliente")
	private long idCliente;
	@Column(name = "idProducto")
	private long idProducto;
	@Column(name = "unidades")
	private int unidades;
	@Column(name = "fecha")
	private Date fecha;
	
	public Compra(long idCompra, long idCliente, long idProducto, int unidades, Date fecha) {
		super();
		this.idCompra = idCompra;
		this.idCliente = idCliente;
		this.idProducto = idProducto;
		this.unidades = unidades;
		this.fecha=fecha;
	}
	public Compra() {
	}

	public long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(long idCompra) {
		this.idCompra = idCompra;
	}

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(long idProducto) {
		this.idProducto = idProducto;
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

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", idCliente=" + idCliente + ", idProducto=" + idProducto
				+ ", unidades=" + unidades + ", fecha=" + fecha + "]";
	}

	
	
	
}
