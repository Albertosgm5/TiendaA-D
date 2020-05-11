package ad.store.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ad.store.entity.Categoria;
import ad.store.entity.Producto;



@Repository
@Component("CategoriaDao")
public class CategoriaDaoImpl extends GenericDaoImpl<Categoria> implements CategoriaDao{
	private long idProducto;
	
	@Override
	public Categoria crearCategoria(String nombreCategoria, String descripcionCategoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> listarCategoriasPorProducto(Producto producto) {
		idProducto=producto.getIdProducto();
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		return null;
	}

	@Override
	public void borrarCategoria(long idCategoria) {

	}

	@Override
	public Categoria obtenerCategoria(String nombre, Producto producto) {
		return null;
	}

	@Override
	public Categoria obtenerCategoriaPorId(long idCategoria) {
		return null;
	}

	@Override
	public Categoria editarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> listarCategorias() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	

}
