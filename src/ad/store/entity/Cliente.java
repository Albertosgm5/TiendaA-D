package ad.store.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCliente;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "nombreUsuario")
	private String nombreUsuario;
	@Column(name = "password")
	private String password;

	
//	private List<Venta> ventas;

	public Cliente() {

		
	}
	public Cliente(long idCliente, String direccion, String nombreUsuario, String password) {
		super();
		this.idCliente = idCliente;
		this.direccion = direccion;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}
	public Cliente(long idCliente, String direccion, String nombreUsuario, String password, List<Venta> ventas) {
		this.idCliente = idCliente;
		this.direccion = direccion;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
//		this.ventas = ventas;
	}
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
//	public List<Venta> getVentas() {
//		return ventas;
//	}
//	public void setVentas(List<Venta> ventas) {
//		this.ventas = ventas;
//	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", direccion=" + direccion + ", nombreUsuario=" + nombreUsuario
				+ ", password=" + password + "]";
	}
	
}
