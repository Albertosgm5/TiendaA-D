package ad.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.store.dao.ProductoDao;
import ad.store.entity.Cliente;
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

	@Override
	public Producto crearProducto(String nombre, float precio, int stock, String categoria, String descripcion) {
		Producto producto = new Producto();
		producto.setNombreProducto(nombre);
		producto.setPrecio(precio);
		producto.setStock(stock);
		producto.setCategoria(categoria);
		producto.setDescripcion(descripcion);;
		return productoDao.create(producto);
	}

	@Override
	public Producto editarProducto(Producto producto) {
		return productoDao.update(producto);
	}

	@Override
	public void eliminarProducto(long idProducto) {
		productoDao.delete(idProducto);
	}

	@Override
	public List<Producto> listarProductosPorPrecio(float minPrecio, float maxPrecio, int count, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> listarProductosPorNombreYPrecio(String nombre, float minPrecio, float maxPrecio, int count,
			int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
