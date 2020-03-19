package ad.store.dao;

import java.util.List;

import ad.store.entity.Producto;

public interface ProductoDao extends GenericDao<Producto>{

	public List<Producto> listarProductos();
	
	public List<Producto> listarProductoPorNombre(String nombreModulo);
	
	public Producto crearProducto (String nombre, float precio, int stock);
	
	public Producto obtenerProducto (long idProducto);
	
	public Producto editarProducto(Producto producto);
	
	public boolean eliminarProducto(long idProducto);
	
	public List<Producto> obtenerProductosNombre (String nombre, int count, int index);
	
	
}
