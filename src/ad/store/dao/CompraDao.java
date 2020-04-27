package ad.store.dao;

import java.util.Date;
import java.util.List;

import ad.store.entity.Compra;

public interface CompraDao extends GenericDao<Compra>{
	public Compra hacerCompra (long idCliente, long idProducto, int unidades, Date fecha);
	public List<Compra> listarCompras(long idCliente);
	public void devolverCompra(long idCompra);
	public Compra obtenerCompra(long idCliente, long idProducto);
}
