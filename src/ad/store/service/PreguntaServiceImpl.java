package ad.store.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.store.dao.CompraDao;
import ad.store.dao.PreguntaDao;
import ad.store.entity.Cliente;
import ad.store.entity.Compra;
import ad.store.entity.Pregunta;
import ad.store.entity.Producto;

@Transactional
@Service
public class PreguntaServiceImpl implements PreguntaService{
	@Autowired
	PreguntaDao preguntaDao;

	@Override
	public Pregunta hacerPregunta(String pregunta, Producto producto, Cliente cliente) {
		Pregunta pre = new Pregunta();
		pre.setPregunta(pregunta);
		pre.setProducto(producto);
		pre.setCliente(cliente);
		return preguntaDao.create(pre);
	}

	@Override
	public List<Pregunta> listarPreguntas(Producto producto, Cliente cliente) {
		return preguntaDao.listarPreguntas(producto,cliente);
	}

	@Override
	public Pregunta obtenerPregunta(long idPregunta) {
		return preguntaDao.obtenerPregunta(idPregunta);
	}

}
