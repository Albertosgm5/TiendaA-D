package ad.store.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import ad.store.service.UserServiceImpl;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	UserService userService;
	


	@RequestMapping("/perfil")
	public ModelAndView perfilCliente(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		long idCliente = (long) session.getAttribute("idSession");
		Cliente cliente = userService.obtenerCliente(idCliente);
		mav.addObject("account", cliente);
		mav.setViewName("profile");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/cerrar")
	public void perfilCliente(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession sesion = request.getSession();
	    sesion.invalidate();
	    response.sendRedirect("/A&DStore/");
	}
	
	
	
	
	
}
