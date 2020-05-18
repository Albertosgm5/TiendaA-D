package ad.store.dao;

import java.util.List;
import java.util.Set;

import ad.store.dto.ProductoDto;
import ad.store.entity.Categoria;
import ad.store.entity.Compra;
import ad.store.entity.Producto;
import ad.store.entity.Venta;

public interface ProductoDao extends GenericDao<Producto>{

	public List<Producto> listarProductos();
	
	public List<Producto> listarProductosPorNombre(String nombreModulo);
	
	public List<Producto> listarProductosPorCategoria(Categoria categoria);
	
	public Producto crearProducto (String nombre, float precio, int stock, Categoria categoria, String descripcion);
	
	public Producto obtenerProducto (long idProducto);
	
	public Producto obtenerProductoPorNombre(String nombreProducto);
	
	public Producto editarProducto(Producto producto);
	
	public void eliminarProducto(long idProducto);
	
	public List<Producto> obtenerProductosNombre (String nombre, int count, int index);
	
	public List<Producto> obtenerProductosPorPrecio (float minPrecio, float maxPrecio, int count, int index);
	
	public List<ProductoDto> obtenerProductosPorNombre (String nombreProducto);

	public void eliminarCompra(long idProducto, Compra compra);

	public void eliminarVentas(long idProducto, Venta venta);
	
}
