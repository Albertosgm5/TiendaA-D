package ad.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.store.entity.Cliente;
import ad.store.dao.UserDao;



@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao UserDao;

	

	@Override
	public Cliente crearPorfesor(Cliente cliente) {

		return UserDao.create(cliente);
	}

	@Override
	public void eliminarPorfesor(long idProfesor) {

		profesorDao.delete(idProfesor);
	}

	@Override
	public List<Profesor> listarProfesorPorNombreYApellidos(String nombreyapellidos) {

		return profesorDao.buscarPorfesorPorNombreYApellidos(nombreyapellidos);
	}

	@Override
	public List<Modulo> listarModulosNombre(String nombreModulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Modulo> listarModulosProfesor(long idProfesor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profesor> listarProfesores() {
		return profesorDao.listarPorfesores();
	}

	@Override
	public Profesor obtenerProfesor(long idProfesor) {
		return profesorDao.find(idProfesor);
	}

	@Override
	public List<Modulo> listarModulos() {
		return moduloDao.listarModulos();
	}

	@Override
	public Profesor anadirEmail(long idProfesor, Email email) {

		return profesorDao.anadirEmail(idProfesor, email);
	}

	@Override
	public Email crearEmail(Email email) {

		return emailDao.create(email);
	}

	@Override
	public void eliminarEmail(long idProfesor, Email email) {

		Profesor p = profesorDao.find(idProfesor);
		p.removeEmails(email);
		emailDao.update(email);

	}

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
