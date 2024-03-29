package ad.store.dao;


import java.util.List;
import ad.store.entity.Producto;
import ad.store.entity.Valoracion;

public interface ValoracionDao extends GenericDao<Valoracion>{
	public List<Valoracion> listarValoracionPorProducto(Producto producto);
	public Valoracion hacerValoracion (int valoracion, Producto producto);
}
