package ad.store.dao;


import ad.store.entity.Cliente;

public interface UserDao extends GenericDao<Cliente>{

	public Cliente altaCliente(String nombreUsuario, String direccion, String password);
	
	public Cliente obtenerCliente(long idCliente);
	
	public Cliente editarCliente(Cliente cliente);
	
	public Boolean eliminarCliente(long idCliente);
	
	public Cliente logIn(String nombreUsuario, String direccion, String password);
	
	public Boolean logOut(Cliente cliente);
	
}
