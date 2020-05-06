package ad.store.service;





import ad.store.entity.Cliente;
import ad.store.entity.Compra;
import ad.store.entity.Producto;
import ad.store.entity.Venta;

public interface VentaService {
	Venta hacerVenta(Cliente cliente, Producto producto, Compra compra, int unidades);
	Venta obtenerVenta(Cliente cliente, Producto producto, Compra compra);
}
