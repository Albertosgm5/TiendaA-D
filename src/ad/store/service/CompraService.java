package ad.store.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import ad.store.entity.Cliente;
import ad.store.entity.Compra;
import ad.store.entity.Producto;

public interface CompraService {
	public Compra hacerCompra (Cliente cliente, Set<Producto> producto, Date fecha, float precioT);
	public List<Compra> listarCompras(Cliente cliente);
	public void devolverCompra(long idCompra);
	public Compra obtenerCompra(Cliente cliente, Producto producto);
	public Compra obtenerCompraPorId(long idCompra);
}
