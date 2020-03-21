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

//	@Override
//	public Cliente buscarPorEmail(String email) {
//		Query query = this.em.createQuery("select u FROM Profesor u where u.email= :email");
//		query.setParameter("email", email);
//		Profesor profesor = (Profesor) query.getSingleResult();
//
//		if (profesor != null) {
//			return profesor;
//		}
//		return null;
//	}
//
//	@Override
//	public List<Profesor> buscarPorfesorPorNombreYApellidos(String nombreyapellidos) {
//
//		String nym = "%" + nombreyapellidos + "%";
//		Query query = this.em.createQuery("select u FROM Profesor u where concat (u.nombre,' 'u apellidos) like  :nym");
//		query.setParameter("nym", nym);
//		List<Profesor> lProfesor = query.getResultList();
//
//		if (lProfesor != null) {
//			return lProfesor;
//		}
//		return null;
//	}
//
//	@Override
//	public List<Profesor> listarPorfesores() {
//		Query query = this.em.createQuery("FROM Profesor");
//		List<Profesor> lProfesor = query.getResultList();
//
//		if (lProfesor != null) {
//			return lProfesor;
//		}
//		return null;
//	}
//
//	@Override
//	public Profesor anadirEmail(long idProfesor, Email email) {
//
//		Profesor profesor = this.find(idProfesor);
//		profesor.addEmails(email);
//
//		return profesor;
//	}
//
//}
