package ad.store.dao;



import java.util.ArrayList;
import java.util.List;

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
	public List<Venta> listarVentas(Cliente cliente, Producto producto) {
		idCliente=cliente.getIdCliente();
		idProducto=producto.getIdProducto();
		List<Venta> ventas = new ArrayList<Venta>();

        ventas = this.em
                .createQuery("FROM Venta Where idCliente = "+idCliente+", idProducto ="+idProducto, Venta.class).getResultList();
        if (ventas != null ) {
            return ventas;
        }
		return null;
	}


}
