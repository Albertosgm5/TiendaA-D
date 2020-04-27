package ad.store.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ad.store.entity.Compra;
import ad.store.entity.Producto;
import ad.store.service.CompraService;

@Controller
@RequestMapping(value = "/compras")
public class CompraController {
	private Date fechaC;
	private long idC;
	@Autowired
	CompraService compraService;
	
	/*@RequestMapping(method = RequestMethod.POST,value = "crear_Producto")
	public void handlecrear(HttpServletRequest request,HttpServletResponse response,
									@RequestParam("unidades") int unidades) throws IOException {
		Compra compra = compraService.hacerProducto(idCliente, idProducto, unidades, fecha);

		ModelAndView mav = new ModelAndView();
		if (compra == null) {
			mav.addObject("exception", "Username or password are empty.");
			mav.setViewName("index");
		}
		HttpSession session = request.getSession();
		session.setAttribute("compraSession", idCompra);
		session.setAttribute("fechaCompraSession", fecha);
		 response.sendRedirect("/A&DStore/");
	}*/
	
	/*@RequestMapping(value = "/BorrarC")
	public void handleDelete(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession sesion = request.getSession();
		idC=(long) sesion.getAttribute("compraSession");
		fechaC=(Date) sesion.getAttribute("fechaCompraSession");
		Compra comp = compraService.obtenerCompra(idC);
		Long id= comp.getIdCompra();
		compraService.devolverCompra(id);
	    sesion.invalidate();

			response.sendRedirect("/A&DStore/");
	}*/

}
