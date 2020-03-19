package ad.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.store.dao.ProductoDao;
import ad.store.entity.Producto;

@Transactional
@Service
public class ModuloServiceImpl implements ModuloService {

	@Autowired
	ProductoDao productoDao;

	@Override
	public List<Producto> listarModulos() {
		return productoDao.listarModulos();
	}

	@Override
	public List<Producto> listarModulosPorNombre(String nombreModulo) {
		return productoDao.listarModulosPorNombre(nombreModulo);
	}

	@Override
	public Producto obtenerModulo(long idModulo) {
		return productoDao.find(idModulo);
	}

}
