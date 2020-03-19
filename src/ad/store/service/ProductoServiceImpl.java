package ad.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.store.dao.ProductoDao;
import ad.store.entity.Producto;

@Transactional
@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoDao productoDao;

	@Override
	public List<Producto> listarProductos() {
		return productoDao.listarProductos();
	}

	@Override
	public List<Producto> listarProductosPorNombre(String nombreProducto) {
		return productoDao.listarProductosPorNombre(nombreProducto);
	}

	@Override
	public Producto obtenerProducto(long idModulo) {
		return productoDao.find(idModulo);
	}

}
