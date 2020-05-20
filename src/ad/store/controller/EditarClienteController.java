package ad.store.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ad.store.entity.Categoria;
import ad.store.entity.Cliente;
import ad.store.entity.Producto;
import ad.store.service.UserService;
@Controller
public class EditarClienteController {
	private Cliente cli;
	private Cliente cliente;
	private String name;
	private String pass;
	private HttpServletResponse response;
	
	@Autowired
	UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(method = RequestMethod.GET,value = "editar_User" )
	public ModelAndView editarView(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession sesion = request.getSession();
		long id = (long) sesion.getAttribute("idSession");
		Cliente cliente = userService.obtenerCliente(id);
		mav.addObject("cliente", cliente);
		mav.setViewName("editar_User");
		return mav;
	}
	
	
	@RequestMapping(method = RequestMethod.POST,value = "editar_User")
	//@PostMapping("/editar_User")
	public ModelAndView handleEdit(	HttpServletRequest request,@RequestParam("username") String username, 
									@RequestParam("password") String password,
									@RequestParam("direccionEnvio") String direccionEnvio,
									@RequestParam("nombre") String nombre,
									@RequestParam("apellidos") String apellidos,
									@RequestParam("email") String email,
									@RequestParam("fechaNa") Date fechaNa,
									@RequestParam("banco") String banco,
									@RequestParam("numTarjeta") long numTarjeta,
									@RequestParam("titular") String titular,
									@RequestParam("codigoS") int codigoS,
									@RequestParam("direccionFa") String  direccionFa) {
		
		HttpSession session = request.getSession();
		
		name=(String) session.getAttribute("accountSession");
		pass=(String) session.getAttribute("passSession");
		Cliente cli = userService.logIn(name, pass);
		Long id= cli.getIdCliente();
		cli.setIdCliente(id);
		cli.setNombreUsuario(username);
		//cli.setPassword(password);
		cli.setPassword(bCryptPasswordEncoder.encode(password));
		cli.setDireccionEnvio(direccionEnvio);
		cli.setNombre(nombre);
		cli.setApellidos(apellidos);
		cli.setEmail(email);
		cli.setFechaNa(fechaNa);
		cli.setBanco(banco);
		cli.setNumTarjeta(numTarjeta);
		cli.setTitular(titular);
		cli.setCodigoS(codigoS);
		cli.setDireccionFa(direccionFa);
		Cliente cliente = userService.editarCliente(cli);

		ModelAndView mav = new ModelAndView();
		session.setAttribute("accountSession", cli.getNombreUsuario());
		session.setAttribute("passSession", cli.getPassword());
		mav.addObject("account", cliente);
		mav.setViewName("profile");
		return mav;
	}
	@RequestMapping(value = "/Borrar")
	public void handleDelete(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession sesion = request.getSession();
		name=(String) sesion.getAttribute("accountSession");
		pass=(String) sesion.getAttribute("passSession");
		Cliente cli = userService.logIn(name, pass);
		Long id= cli.getIdCliente();
		userService.eliminarCliente(id);
	    sesion.invalidate();

			response.sendRedirect("/A&DStore/");


	}
}
