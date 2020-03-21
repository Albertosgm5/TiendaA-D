package ad.store.service;

import ad.store.entity.Cliente;



public interface UserService {

	public Cliente altaCliente(String nombreUsuario, String direccion, String password);
	public Cliente obtenerCliente (long idCliente);
	public Cliente editarCliente(Cliente cliente);
	public void eliminarCliente (long idCliente);
	public Cliente logIn(String nombreUsuario, String direccion, String password);
	public Boolean logOut(Cliente cliente);
	
}
