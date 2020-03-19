package ad.store.dao;

import java.util.List;

import ad.store.entity.Producto;

public interface UserDao extends GenericDao<Producto>{

	public List<Producto> listarProductos();
	
	public List<Producto> listarProductosPorNombre(String nombreModulo);
	
	public Producto crearProducto (String nombre, float precio, int stock);
	
	public Producto obtenerProducto (long idProducto);
	
	public Producto editarProducto(Producto producto);
	
	public boolean eliminarProducto(long idProducto);
	
	public List<Producto> obtenerProductosNombre (String nombre, int count, int index);
	
	public List<Producto> obtenerProductosPorPrecio (float minPrecio, float maxPrecio, int count, int index);
	
	public List<Producto> obtenerProductosPorNombreYPrecio (String nombre , float minPrecio, float maxPrecio, int count, int index);
	
}
