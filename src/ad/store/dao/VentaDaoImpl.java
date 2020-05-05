package ad.store.dao;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ad.store.entity.Cliente;
import ad.store.entity.Compra;
import ad.store.entity.Producto;
import ad.store.entity.Venta;



@Repository
@Component("VentaDao")
public class VentaDaoImpl extends GenericDaoImpl<Venta> implements VentaDao{
	private long idCliente;
	private long idProducto;

	@Override
	public Venta hacerVenta(Cliente cliente, Producto producto, int unidades) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venta obtenerVenta(Cliente cliente, Producto producto) {
		idCliente=cliente.getIdCliente();
		idProducto=producto.getIdProducto();
		Query query = this.em.createQuery("From Venta Where idCliente = :idCliente AND idProducto = :idProducto");
		query.setParameter("idCliente", idCliente);
		query.setParameter("idProducto", idProducto);
		Venta venta = (Venta) query.getSingleResult();
        if (venta != null ) {
            return venta;
        }
		return null;
	}


}
