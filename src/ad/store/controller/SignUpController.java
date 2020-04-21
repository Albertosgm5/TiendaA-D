package ad.store.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ad.store.entity.Cliente;
import ad.store.service.UserService;

@Controller
public class SignUpController {
	@Autowired
	private UserService userService;
	
	//@RequestMapping(method = RequestMethod.GET,value = "signup" )
	@GetMapping("/signup")
	public String signUpView() {
		return "signup";
	}
	
	//@RequestMapping(method = RequestMethod.POST,value = "signup")
	@PostMapping("/signup")
	public ModelAndView handleSignUp(HttpServletRequest request,@RequestParam("username") String username, 
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
									@RequestParam("direccionFa") String  direccionFa){
		Cliente cliente = userService.altaCliente(username, password, direccionEnvio, nombre, apellidos, email, fechaNa, banco, numTarjeta, titular, codigoS, direccionFa);
		String pass = cliente.getPassword();
		ModelAndView mav = new ModelAndView();
		if (cliente == null) {
			mav.addObject("exception", "Username or password are empty.");
			mav.setViewName("signup");
		}
		//Account account = new Account(username, password);
		HttpSession session = request.getSession();
		mav.addObject("account", cliente);
		mav.setViewName("profile");
		session.setAttribute("accountSession", username);
		session.setAttribute("passSession", pass);
		return mav;
	}
}