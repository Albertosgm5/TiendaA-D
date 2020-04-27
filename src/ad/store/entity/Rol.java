package ad.store.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRol;
	@Column(name = "nombre_rol")
	private String nombreRol;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "CLIENTE_ROL", joinColumns = @JoinColumn(name = "ID_ROL"), inverseJoinColumns = @JoinColumn(name = "ID_CLIENTE"))
    private Set<Cliente> clientes;
    public Rol() {
    	
    }
	public Rol(long idRol, String nombreRol){
		this.idRol = idRol;
		this.nombreRol = nombreRol;
	}
	
	
	public long getIdRol() {
		return idRol;
	}
	public void setIdRol(long idRol) {
		this.idRol = idRol;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	public Set<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	
}
