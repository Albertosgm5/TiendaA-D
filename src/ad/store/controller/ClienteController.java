package ad.store.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import ad.store.entity.Cliente;
import ad.store.service.UserService;
import ad.store.service.UserServiceImpl;

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
	}*/

	
	
	
}
