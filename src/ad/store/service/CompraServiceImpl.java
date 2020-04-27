package ad.store.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.store.dao.CompraDao;
import ad.store.entity.Cliente;
import ad.store.entity.Compra;
import ad.store.entity.Producto;

@Transactional
@Service
public class CompraServiceImpl implements CompraService{
	@Autowired
	CompraDao compraDao;

	@Override
	public Compra hacerCompra(Cliente cliente, Producto producto, int unidades, Date fecha) {
		Compra compra = new Compra();
		compra.setCliente(cliente);
		compra.setProducto(producto);
		compra.setUnidades(unidades);
		compra.setFecha(fecha);
		return compraDao.create(compra);
	}

	@Override
	public List<Compra> listarCompras(Cliente cliente) {
		return compraDao.listarCompras(cliente);
	}

	@Override
	public void devolverCompra(long idCompra) {
		compraDao.delete(idCompra);
		
	}

	@Override
	public Compra obtenerCompra(Cliente cliente, Producto producto) {
		return compraDao.obtenerCompra(cliente,producto);
	}

}
