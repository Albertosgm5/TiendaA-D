package ad.store.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ad.store.dao.ProductoDaoImpl;
import ad.store.entity.Cliente;
import ad.store.dao.UserDaoImpl;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl userDaoImpl;

	

	@Autowired
	private ProductoDaoImpl productoDaoImpl;



	@Override
	public Cliente altaCliente(String nombreUsuario, String direccion, String password) {
		Cliente cliente = new Cliente();
		cliente.setNombreUsuario(nombreUsuario);
		cliente.setDireccion(direccion);
		cliente.setPassword(password);
		return userDaoImpl.create(cliente);
	}



	@Override
	public Cliente obtenerCliente(long idCliente) {
		return userDaoImpl.find(idCliente);
	}



	@Override
	public Cliente editarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void eliminarCliente(long idCliente) {
		userDaoImpl.delete(idCliente);
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
