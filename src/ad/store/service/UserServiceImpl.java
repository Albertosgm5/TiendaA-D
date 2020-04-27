package ad.store.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.store.dao.ProductoDao;
import ad.store.dao.RolRepository;
import ad.store.entity.Cliente;
import ad.store.entity.Producto;
import ad.store.entity.Rol;
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
	private RolRepository rolRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private ProductoDao productoDao;

	
	@Override
	public Cliente altaCliente(String nombreUsuario,String password, String direccionEnvio, String nombre,
			String apellidos, String email, Date fechaNa, String banco, long numTarjeta, String titular,
			int codigoS, String direccionFa) {
		Cliente cliente = new Cliente();
		cliente.setNombreUsuario(nombreUsuario);
		cliente.setDireccionEnvio(direccionEnvio);
		//cliente.setPassword(password);
		cliente.setPassword(bCryptPasswordEncoder.encode(password));
		cliente.setNombre(nombre);
		cliente.setApellidos(apellidos);
		cliente.setEmail(email);
		cliente.setFechaNa(fechaNa);
		cliente.setBanco(banco);
		cliente.setNumTarjeta(numTarjeta);
		cliente.setTitular(titular);
		cliente.setCodigoS(codigoS);
		cliente.setDireccionFa(direccionFa);
		Set<Rol> roles  =new HashSet<Rol>();
		Rol rol = rolRepository.getOne(1);
		roles.add(rol);
		cliente.setRoles(roles);
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
	public Cliente logIn(String userName, String password) {
		return userDao.logIn(userName, password);
	}



	@Override
	public boolean logOut(Cliente cliente) {
		return userDao.logOut(cliente);
	}



	@Override
	public Cliente findByUsername(String nombre) {
		return userDao.findByUsername(nombre);

	}





	
}
