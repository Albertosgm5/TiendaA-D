package ad.store.dao;





import ad.store.entity.Cliente;
import ad.store.entity.Producto;
import ad.store.entity.Venta;

public interface VentaDao extends GenericDao<Venta>{
	public Venta hacerVenta (Cliente cliente, Producto producto, int unidades);
	public Venta obtenerVenta(Cliente cliente, Producto producto);
	
}
