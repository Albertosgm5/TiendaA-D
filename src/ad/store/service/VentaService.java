package ad.store.service;





import ad.store.entity.Cliente;
import ad.store.entity.Producto;
import ad.store.entity.Venta;

public interface VentaService {
	public Venta hacerVenta (Cliente cliente, Producto producto, int unidades);
	public Venta obtenerVenta(Cliente cliente, Producto producto);
	public void eliminarVenta(Venta venta);
}
