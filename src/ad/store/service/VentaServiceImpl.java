package ad.store.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.store.dao.ProductoDao;
import ad.store.dao.VentaDao;
import ad.store.entity.Cliente;
import ad.store.entity.Compra;
import ad.store.entity.Producto;
import ad.store.entity.Venta;

@Transactional
@Service
public class VentaServiceImpl implements VentaService{
	@Autowired
	VentaDao ventaDao;
	
	@Autowired
	ProductoDao productoDao;

	@Override
	public Venta hacerVenta (Cliente cliente, Producto producto, Compra compra, int unidades) {
		Venta venta = new Venta();
		venta.setCliente(cliente);
		venta.setProducto(producto);
		venta.setCompra(compra);
		venta.setUnidades(unidades);
		return ventaDao.create(venta);
	}
	@Override
	public Venta obtenerVenta(Cliente cliente, Producto producto, Compra compra) {
		return ventaDao.obtenerVenta(cliente, producto, compra);
	}

}
