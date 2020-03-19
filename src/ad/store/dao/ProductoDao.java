package ad.store.dao;

import java.util.List;

import ad.store.entity.Producto;

public interface ProductoDao extends GenericDao<Producto>{

	public List<Producto> listarModulos();
	
	public List<Producto> listarModulosPorNombre(String nombreModulo);
	
	public boolean crearProducto();
	
	
	
	
	
	
}
