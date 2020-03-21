package ad.store.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ad.store.service.UserService;


@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	UserService clienteService;


/*
	@RequestMapping(method = RequestMethod.GET, value = "/perfil/{id}")
	public ModelAndView perfilProfesor(@PathVariable("id") long idCliente) {

		ModelAndView mav = new ModelAndView();

		Cliente cliente = UserService.obtenerCliente(idCliente);

		mav.addObject("cliente", cliente);
		mav.setViewName("cliente_perfil");
		return mav;
	}
*/
	
	
	
}
