package ad.store.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ad.store.entity.Producto;


@Repository
@Component("ModuloDao")
public class ProductoDaoImpl extends GenericDaoImpl<Producto> implements ProductoDao {

	@Override
	public List<Producto> listarModulosPorNombre(String nombreProducto) {
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
	public List<Producto> listarModulos() {
		Query query = this.em
                .createQuery("FROM producto");
        List<Producto> lProducto = query.getResultList();
        
        if (lProducto != null ) {
            return lProducto;
        }
		return null;
	}

}
