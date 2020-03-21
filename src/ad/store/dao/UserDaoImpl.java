package ad.store.dao;



import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ad.store.entity.Cliente;


@Repository
@Component("UserDao")
public class UserDaoImpl extends GenericDaoImpl<Cliente> implements UserDao {

	@Override
	public Cliente altaCliente(String nombreUsuario, String direccion, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente obtenerCliente(long idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente editarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarCliente(long idCliente) {
		
	}

	@Override
	public Cliente logIn(String nombreUsuario, String direccion, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean logOut(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}


