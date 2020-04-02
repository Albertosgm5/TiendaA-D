package ad.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import ad.store.entity.Cliente;
import ad.store.service.UserService;
import ad.store.service.UserServiceImpl;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	UserService userService;



	@RequestMapping(method = RequestMethod.GET, value = "/perfil/{id}")
	public ModelAndView perfilProfesor(@PathVariable("id") long idCliente) {

		ModelAndView mav = new ModelAndView();

		Cliente cliente = userService.obtenerCliente(idCliente);

		mav.addObject("cliente", cliente);
		mav.setViewName("cliente_perfil");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST,value = "editar_User")
	public ModelAndView handleEdit(@RequestParam("username") String username, 
									@RequestParam("password") String password,
									@RequestParam("direccion") String direccion) {
		Cliente cli = null;
		cli.setNombreUsuario(username);
		cli.setPassword(password);
		cli.setDireccion(direccion);
		Cliente cliente = userService.editarCliente(cli);

		ModelAndView mav = new ModelAndView();
		if (cliente == null) {
			mav.addObject("exception", "Username or password are empty.");
			mav.setViewName("editar_User");
		}
	
		mav.addObject("account", cliente);
		mav.setViewName("profile");
		return mav;
	}
	@RequestMapping(method = RequestMethod.POST,value = "profile")
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
