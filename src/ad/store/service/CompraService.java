package ad.store.service;

import java.util.Date;
import java.util.List;

import ad.store.entity.Compra;

public interface CompraService {
	public Compra hacerCompra (long idCliente, long idProducto, int unidades, Date fecha);
	public List<Compra> listarCompras(long idCliente);
	public void devolverCompra(long idCompra);
	public Compra obtenerCompra(long idCliente, long idProducto);
}
