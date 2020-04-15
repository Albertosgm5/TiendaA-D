package ad.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ad.store.entity.Cliente;
import ad.store.service.UserService;

public class EditarCliente {
	private Cliente cli;
	private Cliente cliente;
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET,value = "editar_User2" )
	public String editarView() {
		return "editar_User2";
	}
	@RequestMapping(method = RequestMethod.GET, value = "/profile/{id}")
	public ModelAndView perfilProfesor(@PathVariable("id") long idCliente) {

		ModelAndView mav = new ModelAndView();

		cliente = userService.obtenerCliente(idCliente);

		mav.addObject("cliente", cliente);
		mav.setViewName("editar_User2");
		return mav;
	}
	@RequestMapping(method = RequestMethod.POST,value = "editar_User2")
	public ModelAndView handleEdit(@RequestParam("username") String username, 
									@RequestParam("password") String password,
									@RequestParam("direccion") String direccion) {
		
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
		Cliente cli = userService.logIn(username, password);
		Long id= cli.getIdCliente();
		Cliente cliente = userService.obtenerCliente(id);
		userService.eliminarCliente(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
}
