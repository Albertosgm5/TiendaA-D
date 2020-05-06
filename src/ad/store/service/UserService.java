package ad.store.service;

import java.util.Date;
import java.util.List;

import ad.store.entity.Cliente;



public interface UserService {

	public Cliente altaCliente(String nombreUsuario, String direccionEnvio, String password, String nombre,
			String apellidos, String email, Date fechaNa, String banco, long numTarjeta, String titular,
			int codigoS, String direccionFa);
	
	public Cliente obtenerCliente (long idCliente);
	
	public Cliente editarCliente(Cliente cliente);
	
	public void eliminarCliente (long idCliente);
	
	public Cliente logIn(String userName, String password);
	
	public boolean logOut(Cliente cliente);
	
	public Cliente findByUsername(String nombre);

	public void eliminarCompra(long idCliente, long idCompra);
	
}
