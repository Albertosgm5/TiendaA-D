package ad.store.entity;

import java.util.HashSet;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "preguntas")
public class Pregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPregunta")
	private long idPregunta;
	@Column(name = "textoPregunta")
	private String pregunta;
	@ManyToOne
	@JoinColumn(name = "idProducto")
	private Set<Producto> producto = new HashSet<>();
	
	public Pregunta(String pregunta, Set<Producto> producto) {
		super();
		this.pregunta = pregunta;
		this.producto = producto;
	}
	public long getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(long idPregunta) {
		this.idPregunta = idPregunta;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public Set<Producto> getProducto() {
		return producto;
	}
	public void setProducto(Set<Producto> producto) {
		this.producto = producto;
	}

	
	
	
	
	
}
