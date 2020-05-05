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
@Table(name = "respuestas")
public class Respuestas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRespuesta")
	private long idRespuesta;
	
	@Column(name = "textoRespuesta")
	private String textoRespuesta;
	
	@ManyToOne
	@JoinColumn(name = "idPregunta")
	private Pregunta pregunta;
	
	public Respuestas(Pregunta pregunta, String textoRespuesta) {
		super();
		this.pregunta = pregunta;
		this.textoRespuesta = textoRespuesta;
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
	
	
}
