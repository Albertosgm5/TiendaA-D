package ad.store.dao;




import java.util.List;

import ad.store.entity.Cliente;
import ad.store.entity.Producto;
import ad.store.entity.Venta;

public interface VentaDao extends GenericDao<Venta>{
	public Venta hacerVenta (Cliente cliente, Producto producto, int unidades);
	public List<Venta> listarVentas(Cliente cliente, Producto producto);
	
}
