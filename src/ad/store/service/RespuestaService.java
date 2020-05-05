package ad.store.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import ad.store.entity.Cliente;
import ad.store.entity.Pregunta;
import ad.store.entity.Producto;
import ad.store.entity.Respuesta;

public interface RespuestaService {
	public Respuesta responder (String respuesta, Pregunta pregunta, Cliente cliente);
	public List<Respuesta> listarRespuestas(Pregunta pregunta, Cliente cliente);
	
}
