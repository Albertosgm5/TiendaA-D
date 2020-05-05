package ad.store.dao;

import java.util.List;

import ad.store.entity.Compra;
import ad.store.entity.Producto;
import ad.store.entity.Venta;

public interface ProductoDao extends GenericDao<Producto>{

	public List<Producto> listarProductos();
	
	public List<Producto> listarProductosPorNombre(String nombreModulo);
	
	public Producto crearProducto (String nombre, float precio, int stock, String categoria, String descripcion);
	
	public Producto obtenerProducto (long idProducto);
	
	public Producto obtenerProductoPorNombre(String nombreProducto);
	
	public Producto editarProducto(Producto producto);
	
	public void eliminarProducto(long idProducto);
	
	public List<Producto> obtenerProductosNombre (String nombre, int count, int index);
	
	public List<Producto> obtenerProductosPorPrecio (float minPrecio, float maxPrecio, int count, int index);
	
	public List<Producto> obtenerProductosPorNombreYPrecio (String nombre , float minPrecio, float maxPrecio, int count, int index);
	
	public void eliminarCompra(Compra compra);
	
	public void eliminarVentas(Venta venta);
	
}
