package ad.store.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ad.store.entity.Cliente;
import ad.store.entity.Producto;
import ad.store.service.UserService;
@Controller
public class EditarCliente {
	private Cliente cli;
	private Cliente cliente;
	private String name;
	private String pass;
	@Autowired
	UserService userService;
	HttpSession session;
	
	@RequestMapping(method = RequestMethod.GET,value = "editar_User2" )
	public String editarView() {
		return "editar_User2";
	}
	
	
	@RequestMapping(method = RequestMethod.POST,value = "editar_User2")
	public ModelAndView handleEdit(@RequestParam("username") String username, 
									@RequestParam("password") String password,
									@RequestParam("direccion") String direccion) {
		name=(String) session.getAttribute("accountSession");
		pass=(String) session.getAttribute("passSession");
		Cliente cli = userService.logIn(name, pass);
		Long id= cli.getIdCliente();
		cli.setIdCliente(id);
		cli.setNombreUsuario(username);
		cli.setPassword(password);
		cli.setDireccion(direccion);
		Cliente cliente = userService.editarCliente(cli);

		ModelAndView mav = new ModelAndView();
	
		mav.addObject("account", cliente);
		mav.setViewName("profile");
		return mav;
	}
	@RequestMapping(method = RequestMethod.POST,value = "Borrar")
	public ModelAndView handleDelete(@RequestParam("username") String username, 
									@RequestParam("password") String password,
									@RequestParam("direccion") String direccion) {
		name=(String) session.getAttribute("accountSession");
		pass=(String) session.getAttribute("passSession");
		Cliente cli = userService.logIn(name, pass);
		Long id= cli.getIdCliente();
		Cliente cliente = userService.obtenerCliente(id);
		userService.eliminarCliente(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
}
