package ad.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.store.dao.CategoriaDao;
import ad.store.dao.ProductoDao;
import ad.store.entity.Categoria;
import ad.store.entity.Producto;

@Transactional
@Service
public class CategoriaServiceImpl implements CategoriaService{
	@Autowired
	CategoriaDao categoriaDao;

	@Autowired
	ProductoDao productoDao;

	@Override
	public Categoria crearCategoria(String nombreCategoria, String descripcionCategoria) {
		Categoria categoria = new Categoria();
		categoria.setNombreCategoria(nombreCategoria);
		categoria.setDescripcionCategoria(descripcionCategoria);
		return categoriaDao.create(categoria);
	}

	@Override
	public Categoria listarCategoriaPorProducto(Producto producto) {
		return categoriaDao.listarCategoriaPorProducto(producto);
	}

	@Override
	public void borrarCategoria(long idCategoria) {
		categoriaDao.delete(idCategoria);
	}

	@Override
	public Categoria obtenerCategoria(String nombre) {
		return categoriaDao.obtenerCategoria(nombre);
	}

	@Override
	public Categoria obtenerCategoriaPorId(long idCategoria) {
		return categoriaDao.find(idCategoria);
	}

	@Override
	public Categoria editarCategoria(Categoria categoria) {
		return categoriaDao.update(categoria);
	}

	@Override
	public List<Categoria> listarCategorias() {
		// TODO Auto-generated method stub
		return categoriaDao.listarCategorias();
	}
	
	

}
