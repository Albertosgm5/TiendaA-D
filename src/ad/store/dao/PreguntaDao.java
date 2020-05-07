package ad.store.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import ad.store.entity.Cliente;
import ad.store.entity.Compra;
import ad.store.entity.Pregunta;
import ad.store.entity.Producto;

public interface PreguntaDao extends GenericDao<Pregunta>{
	public Pregunta hacerPregunta (String pregunta, Producto producto, Cliente cliente);
	public List<Pregunta> listarPreguntas(Producto producto, Cliente cliente);
	public Pregunta obtenerPregunta(long idPregunta);
	
}
