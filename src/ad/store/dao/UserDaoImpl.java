package ad.store.dao;



import java.util.Date;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ad.store.entity.Cliente;
import ad.store.entity.Compra;
import ad.store.entity.Producto;
import ad.store.entity.Venta;


@Repository
@Component("UserDao")
public class UserDaoImpl extends GenericDaoImpl<Cliente> implements UserDao {

	
	@Override
	public Cliente altaCliente(String nombreUsuario, String direccionEnvio, String password, String nombre,
			String apellidos, String email, Date fechaNa, String banco, long numTarjeta, String titular,
			int codigoS, String direccionFa) {
		
		return null;
	}

	@Override
	public Cliente obtenerCliente(long idCliente) {
		return null;
	}

	@Override
	public Cliente editarCliente(Cliente cliente) {
		return null;
	}

	@Override
	public void eliminarCliente(long idCliente) {
		
		
	}

	@Override
	public Cliente logIn(String nombreUsuario, String password) {
		try {
			Query query = this.em.createQuery("From Cliente c Where c.nombreUsuario = :nombreUsuario AND c.password = :password");
			query.setParameter("nombreUsuario", nombreUsuario);
			query.setParameter("password", password);
			Cliente cliente = (Cliente) query.getSingleResult();
			if (cliente != null) {
				return cliente;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean logOut(Cliente cliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cliente findByUsername(String nombre) {
		try {
			Query query = this.em.createQuery("From Cliente c Where c.nombreUsuario = :nombreUsuario");
			query.setParameter("nombreUsuario", nombre);
			Cliente cliente = (Cliente) query.getSingleResult();
			if (cliente != null) {
				return cliente;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void eliminarCompras(long idCliente, Compra compra) {
		Cliente c = this.find(idCliente);
		c.deleteCompra(compra);
	}
	
	
}


