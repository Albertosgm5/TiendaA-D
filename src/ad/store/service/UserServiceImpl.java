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
	private UserDao profesorDao;

	

	@Autowired
	private ProductoDao moduloDao;



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
	public Boolean eliminarCliente(long idCliente) {
		// TODO Auto-generated method stub
		return null;
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
