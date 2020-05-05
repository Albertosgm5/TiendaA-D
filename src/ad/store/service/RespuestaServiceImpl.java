package ad.store.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.store.dao.CompraDao;
import ad.store.dao.PreguntaDao;
import ad.store.dao.RespuestaDao;
import ad.store.entity.Cliente;
import ad.store.entity.Compra;
import ad.store.entity.Pregunta;
import ad.store.entity.Producto;
import ad.store.entity.Respuesta;

@Transactional
@Service
public class RespuestaServiceImpl implements RespuestaService{
	@Autowired
	RespuestaDao respuestaDao;

	@Override
	public Respuesta responder(String respuesta, Pregunta pregunta, Cliente cliente) {
		Respuesta res = new Respuesta();
		res.setTextoRespuesta(respuesta);
		res.setPregunta(pregunta);
		res.setCliente(cliente);
		return respuestaDao.create(res);
	}

	@Override
	public List<Respuesta> listarRespuestas(Pregunta pregunta, Cliente cliente) {
		return respuestaDao.listarRespuestas(pregunta,cliente);
	}
		
}
