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
	public Cliente logIn(String email, String password) {
		try {
			Query query = this.em.createQuery("From Clientes c Where c.email =:email AND c.password =:password");
			query.setParameter("email", email);
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
