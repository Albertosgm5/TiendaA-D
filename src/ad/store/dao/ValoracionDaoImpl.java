package ad.store.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ad.store.entity.Categoria;
import ad.store.entity.Compra;
import ad.store.entity.Producto;
import ad.store.entity.Valoracion;

@Repository
@Component("ValoracionDao")
public class ValoracionDaoImpl extends GenericDaoImpl<Valoracion> implements ValoracionDao {
	private long idProducto;

	@Override
	public List<Valoracion> listarValoracionPorProducto(Producto producto) {
		idProducto = producto.getIdProducto();

		Query query = this.em.createQuery("FROM Valoracion Where idProducto = :idProducto");
		query.setParameter("idProducto", idProducto);

		List<Valoracion> valoraciones = query.getResultList();

		if (valoraciones != null) {
			return valoraciones;
		}
		return null;
	}

	@Override
	public Valoracion hacerValoracion(int valoracion, Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

}
