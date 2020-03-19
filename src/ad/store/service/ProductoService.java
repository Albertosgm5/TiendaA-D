package ad.store.service;

import java.util.List;

import ad.store.entity.Producto;

public interface ProductoService {

	public List<Producto> listarProductos();
	
	public List<Producto> listarProductosPorNombre(String nombreProducto);

	public Producto obtenerProducto(long idProducto);
	
	
}
