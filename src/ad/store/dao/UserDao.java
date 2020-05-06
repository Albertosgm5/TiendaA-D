package ad.store.dao;


import java.util.Date;

import ad.store.entity.Cliente;
import ad.store.entity.Compra;

public interface UserDao extends GenericDao<Cliente>{

	public Cliente altaCliente(String nombreUsuario, String direccionEnvio, String password, String nombre,
			String apellidos, String email, Date fechaNa, String banco, long numTarjeta, String titular,
			int codigoS, String direccionFa);
	
	public Cliente obtenerCliente(long idCliente);
	
	public Cliente editarCliente(Cliente cliente);
	
	public void eliminarCliente(long idCliente);
	
	public Cliente logIn(String nombreUsuario, String password);
	
	public boolean logOut(Cliente cliente);
	
	public Cliente findByUsername(String nombre);

	public void eliminarCompras(long idCliente, Compra compra);
	
}
