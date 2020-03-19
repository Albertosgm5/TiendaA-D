package ad.store.service;

import java.util.List;

import ad.store.entity.Producto;

public interface ModuloService {

	public List<Producto> listarModulos();
	
	public List<Producto> listarModulosPorNombre(String nombreModulo);

	public Producto obtenerModulo(long idModulo);
	
}
