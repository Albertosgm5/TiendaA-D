package ad.store.service;

import java.util.List;

import org.hibernate.Session;
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
		/*Cliente cliente = recuperarCliente(idCliente);
		return cliente;*/
		return null;
	}



	@Override
	public Cliente editarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Boolean eliminarCliente(long idCliente) {
		//Cliente cliente = recuperarCliente(session, idCliente);
		boolean eliminado = false;
		/*try {
		userDao.delete(cliente);
		eliminado = true;
		} catch (RuntimeException e) {
			
		} catch (Exception e) {}*/
		return eliminado;
	}
	/*public Cliente recuperarCliente(long id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Cliente cliente = new Cliente();
		
		session.beginTransaction();
	
		cliente = (Cliente) session.load(Cliente.class, id);
		session.getTransaction().commit();
		
		return cliente;
	}*/


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
