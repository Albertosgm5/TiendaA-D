package ad.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.store.dao.ProductoDaoImpl;
import ad.store.entity.Producto;

@Transactional
@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	ProductoDaoImpl productoDaoImpl;

	@Override
	public List<Producto> listarProductos() {
		return productoDaoImpl.listarProductos();
	}

	@Override
	public List<Producto> listarProductosPorNombre(String nombreProducto) {
		return productoDaoImpl.listarProductosPorNombre(nombreProducto);
	}

	@Override
	public Producto obtenerProducto(long idProducto) {
		return productoDaoImpl.find(idProducto);
	}

}
