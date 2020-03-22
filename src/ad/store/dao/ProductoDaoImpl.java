package ad.store.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ad.store.entity.Producto;


@Repository
@Component("ProductoDao")
public class ProductoDaoImpl extends GenericDaoImpl<Producto> implements ProductoDao {

	@Override
	public List<Producto> listarProductosPorNombre(String nombreProducto) {
		Query query = this.em
                .createQuery("select u FROM modulo u where u.nombreModulo= :nombre");
        query.setParameter("nombre", nombreProducto);
        List<Producto> lProducto = query.getResultList();
        
        if (lProducto != null ) {
            return lProducto;
        }
		return null;
	}

	@Override
	public List<Producto> listarProductos() {
		Query query = this.em
                .createQuery("FROM producto");
        List<Producto> lProducto = query.getResultList();
        
        if (lProducto != null ) {
            return lProducto;
        }
		return null;
	}


	@Override
	public Producto crearProducto(String nombre, float precio, int stock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto obtenerProducto(long idProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto editarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarProducto(long idProducto) {
		
	}

	@Override
	public List<Producto> obtenerProductosNombre(String nombre, int count, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> obtenerProductosPorPrecio(float minPrecio, float maxPrecio, int count, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> obtenerProductosPorNombreYPrecio(String nombre, float minPrecio, float maxPrecio, int count,
			int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
