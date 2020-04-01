package ad.store.dao;



import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ad.store.entity.Cliente;


@Repository
@Component("UserDao")
public class UserDaoImpl extends GenericDaoImpl<Cliente> implements UserDao {

	
	@Override
	public Cliente altaCliente(String nombreUsuario, String direccion, String password) {
		
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
			Query query = this.em.createQuery("From cliente c Where c.nombreUsuario =:nombreUsuario AND c.password =:password");
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

	
	
}


