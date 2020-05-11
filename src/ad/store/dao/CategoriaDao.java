package ad.store.dao;


import java.util.List;

import ad.store.entity.Categoria;
import ad.store.entity.Producto;

public interface CategoriaDao extends GenericDao<Categoria>{
	public Categoria crearCategoria (String nombreCategoria, String descripcionCategoria);
	public List<Categoria> listarCategoriasPorProducto(Producto producto);
	public List<Categoria> listarCategorias();
	public void borrarCategoria(long idCategoria);
	public Categoria editarCategoria(Categoria categoria);
	public Categoria obtenerCategoria(String nombre,Producto producto);
	public Categoria obtenerCategoriaPorId(long idCategoria);
}