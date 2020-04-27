package ad.store.service;

import java.util.Date;
import java.util.List;

import ad.store.entity.Cliente;
import ad.store.entity.Compra;
import ad.store.entity.Producto;

public interface CompraService {
	public Compra hacerCompra (Cliente cliente, Producto producto, int unidades, Date fecha);
	public List<Compra> listarCompras(Cliente cliente);
	public void devolverCompra(long idCompra);
	public Compra obtenerCompra(Cliente cliente, Producto producto);
}
