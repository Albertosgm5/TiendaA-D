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
		return userDao.find(idCliente);
	}



	@Override
	public Cliente editarCliente(Cliente cliente) {
		return userDao.update(cliente);
	}



	@Override
	public void eliminarCliente(long idCliente) {
		userDao.delete(idCliente);
	}



	@Override
	public Cliente logIn(String email, String password) {
		return userDao.logIn(email, password);
	}



	@Override
	public boolean logOut(Cliente cliente) {
		return userDao.logOut(cliente);
	}


	
}
