package ad.store.dao;


import ad.store.entity.Cliente;

public interface UserDao extends GenericDao<Cliente>{

	public Cliente altaCliente(String nombreUsuario, String direccion, String password);
	
	public Cliente obtenerCliente(long idCliente);
	
	public Cliente editarCliente(Cliente cliente);
	
	public void eliminarCliente(long idCliente);
	
	public Cliente logIn(String email, String password);
	
	public boolean logOut(Cliente cliente);
	
}
