package ad.store.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ad.store.entity.Cliente;
import ad.store.entity.Compra;
import ad.store.entity.Producto;



@Repository
@Component("CompraDao")
public class CompraDaoImpl extends GenericDaoImpl<Compra> implements CompraDao{
	private long idCliente;
	@Override
	public Compra hacerCompra(Cliente cliente, Producto producto, int unidades, Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> listarCompras(Cliente cliente) {
		idCliente=cliente.getIdCliente();
		List<Compra> compra = new ArrayList<Compra>();

        compra = this.em
                .createQuery("FROM Compra Where idCliente = ?"+idCliente, Compra.class).getResultList();
        if (compra != null ) {
            return compra;
        }
		return null;
	}

	@Override
	public void devolverCompra(long idCompra) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Compra obtenerCompra(Cliente cliente, Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compra obtenerCompraPorId(long idCompra) {
		// TODO Auto-generated method stub
		return null;
	}

}
