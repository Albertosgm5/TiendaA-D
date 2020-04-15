package ad.store.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ad.store.dao.UserDao;
import ad.store.entity.Account;
import ad.store.entity.Cliente;
import ad.store.service.ProductoService;
import ad.store.service.UserService;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired
	private UserService userService;
	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView handleLogin(HttpServletRequest request, HttpSession session)  {

		ModelAndView mav = new ModelAndView();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Cliente cliente = userService.logIn(username, password);
		String nom=cliente.getNombreUsuario();
		String pass=cliente.getPassword();
		
		if (username.equals(nom) && password.equals(pass)) {
			
			Account account = new Account(username, password);
			mav.addObject("account", account);
			mav.setViewName("profile");
			session.setAttribute("accountSession", username);
			return mav;
		}else {
			mav.addObject("exception", "Este usuario no existe en nuestro sistema.");
			mav.setViewName("singup");
			return mav;
		}
	}

}
