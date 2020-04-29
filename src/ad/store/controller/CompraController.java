package ad.store.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ad.store.entity.Cliente;
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
	
	@RequestMapping(method = RequestMethod.GET,value="/cesta")
	public ModelAndView cesta(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		List<Producto>cProductos = (List<Producto>) session.getAttribute("lProductoSession");
		mav.addObject("productos", cProductos);
		mav.setViewName("carro_Compra");
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "crear_Producto")
	public void handlecrear(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("cliente") Cliente cliente, @RequestParam("producto") Producto producto,
			@RequestParam("unidades") int unidades, @RequestParam("fecha") Date fecha) throws IOException {
		
		Compra compra = compraService.hacerCompra(cliente, producto, unidades, fecha);
		Compra comp = compraService.obtenerCompra(cliente, producto);
		long idCompra=comp.getIdCompra();
		Date fech=comp.getFecha();
		ModelAndView mav = new ModelAndView();
		if (compra == null) {
			mav.addObject("exception", "Username or password are empty.");
			mav.setViewName("index");
		}
		HttpSession session = request.getSession();
		session.setAttribute("compraSession", idCompra);
		session.setAttribute("fechaCompraSession", fech);
		 response.sendRedirect("/A&DStore/");
	}
	
	@RequestMapping(value = "/BorrarC")
	public void handleDelete(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession sesion = request.getSession();
		idC=(long) sesion.getAttribute("compraSession");
		fechaC=(Date) sesion.getAttribute("fechaCompraSession");
		Compra comp = compraService.obtenerCompraPorId(idC);
		Long id= comp.getIdCompra();
		Calendar fecha = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();;
		cal.setTime(fechaC);
		cal.add(Calendar.DAY_OF_YEAR, 15); 
		if(fecha.DAY_OF_YEAR<=cal.DAY_OF_YEAR) {
		compraService.devolverCompra(id);
	    sesion.invalidate();

			response.sendRedirect("/A&DStore/");
		}else {
			System.out.println("Compra no valida");
		}
	}
	@RequestMapping(method = RequestMethod.POST, value = "/listC")
	public ModelAndView listarProductos(@RequestParam("cliente") Cliente cliente){
		
		ModelAndView mav = new ModelAndView();
		
		List<Compra> compra = compraService.listarCompras(cliente);

		mav.addObject("compras", compra);
		mav.setViewName("listarcompras");
		return mav;
	}

}
