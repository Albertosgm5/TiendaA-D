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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "respuesta")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRespuesta")
	private long idRespuesta;
	
	@Column(name = "textoRespuesta")
	private String textoRespuesta;
	
	@ManyToOne
	@JoinColumn(name = "idPregunta")
	private Pregunta pregunta;
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	
	
	public Respuesta(long idRespuesta, String textoRespuesta, Pregunta pregunta, Cliente cliente) {
		super();
		this.idRespuesta = idRespuesta;
		this.textoRespuesta = textoRespuesta;
		this.pregunta = pregunta;
		this.cliente = cliente;
	}
	public Respuesta() {
		
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public long getIdRespuesta() {
		return idRespuesta;
	}
	public void setIdRespuesta(long idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	public Pregunta getPregunta() {
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	public String getTextoRespuesta() {
		return textoRespuesta;
	}
	public void setTextoRespuesta(String textoRespuesta) {
		this.textoRespuesta = textoRespuesta;
	}
	@Override
	public String toString() {
		return "Respuesta [idRespuesta=" + idRespuesta + ", textoRespuesta=" + textoRespuesta + ", pregunta=" + pregunta
				+ ", cliente=" + cliente + "]";
	}
	
	
}
