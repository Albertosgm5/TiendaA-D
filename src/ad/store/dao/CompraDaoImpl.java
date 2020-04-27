package ad.store.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ad.store.entity.Compra;



@Repository
@Component("CompraDao")
public class CompraDaoImpl extends GenericDaoImpl<Compra> implements CompraDao{

	@Override
	public Compra hacerCompra(long idCliente, long idProducto, int unidades, Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> listarCompras(long idCliente) {
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
	public Compra obtenerCompra(long idCliente, long idProducto) {
		// TODO Auto-generated method stub
		return null;
	}

}
