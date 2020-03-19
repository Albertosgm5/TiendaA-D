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
	public List<Producto> listarModulosPorNombre(String nombreModulo) {
		Query query = this.em
                .createQuery("select u FROM modulo u where u.nombreModulo= :nombre");
        query.setParameter("nombre", nombreModulo);
        List<Producto> lModulo = query.getResultList();
        
        if (lModulo != null ) {
            return lModulo;
        }
		return null;
	}

	@Override
	public List<Producto> listarModulos() {
		Query query = this.em
                .createQuery("FROM modulo");
        List<Producto> lModulo = query.getResultList();
        
        if (lModulo != null ) {
            return lModulo;
        }
		return null;
	}

}
