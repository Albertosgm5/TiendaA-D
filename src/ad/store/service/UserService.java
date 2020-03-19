package ad.store.service;

import java.util.List;



public interface UserService {

	public Cliente altaCliente(String nombreUsuario, String direccion, String password);
	public Cliente obtenerCliente (long idCliente);
	public Cliente editarCliente(Cliente cliente);
	public Boolean eliminarCliente (long idCliente);
	public Cliente logIn(String nombreUsuario, String direccion, String password);
	public Boolean logOut(Cliente cliente);
	
}
