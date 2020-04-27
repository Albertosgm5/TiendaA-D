package ad.store.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.store.dao.CompraDao;
import ad.store.entity.Compra;

@Transactional
@Service
public class CompraServiceImpl implements CompraService{
	@Autowired
	CompraDao compraDao;

	@Override
	public Compra hacerCompra(long idCliente, long idProducto, int unidades, Date fecha) {
		Compra compra = new Compra();
		compra.setIdCliente(idCliente);
		compra.setIdProducto(idProducto);
		compra.setUnidades(unidades);
		compra.setFecha(fecha);
		return compraDao.create(compra);
	}

	@Override
	public List<Compra> listarCompras(long idCliente) {
		return compraDao.listarCompras(idCliente);
	}

	@Override
	public void devolverCompra(long idCompra) {
		compraDao.delete(idCompra);
		
	}

	@Override
	public Compra obtenerCompra(long idCliente, long idProducto) {
		return compraDao.obtenerCompra(idCliente,idProducto);
	}

}
