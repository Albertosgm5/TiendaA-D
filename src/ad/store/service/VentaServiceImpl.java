package ad.store.service;




import java.util.List;

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
	public Venta hacerVenta (Cliente cliente, Producto producto, int unidades) {
		Venta venta = new Venta();
		venta.setCliente(cliente);
		venta.setProducto(producto);
		venta.setUnidades(unidades);
		return ventaDao.create(venta);
	}
	@Override
	public Venta obtenerVenta(Cliente cliente, Producto producto) {
		return ventaDao.obtenerVenta(cliente, producto);
	}
	@Override
	public void eliminarVenta(Venta venta) {
		productoDao.eliminarVentas(venta);
		
	}
	
	public void eliminarCompra(Compra compra) {
		productoDao.eliminarCompra(compra);
	}

}
