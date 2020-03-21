package ad.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.store.dao.ProductoDao;
import ad.store.entity.Cliente;
import ad.store.entity.Producto;

import ad.store.dao.ProductoDao;
import ad.store.dao.UserDao;

import ad.store.entity.Producto;
import ad.store.entity.Cliente;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	

	@Autowired
	private ProductoDao productoDao;



	@Override
	public Cliente altaCliente(String nombreUsuario, String direccion, String password) {
		Cliente cliente = new Cliente();
		cliente.setNombreUsuario(nombreUsuario);
		cliente.setDireccion(direccion);
		cliente.setPassword(password);
		return userDao.create(cliente);
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
		// TODO Auto-generated method stub
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
