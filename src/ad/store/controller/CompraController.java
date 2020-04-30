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
import ad.store.service.ProductoService;
import ad.store.service.UserService;

@Controller
@RequestMapping(value = "/compras")
public class CompraController {
	private Date fechaC;
	private long idC;
	@Autowired
	CompraService compraService;
	UserService userService;
	ProductoService productoService;

	@RequestMapping(method = RequestMethod.GET, value = "/cesta")
	public ModelAndView cesta(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		List<Producto> cProductos = (List<Producto>) session.getAttribute("lProductoSession");
		mav.addObject("productos", cProductos);
		mav.setViewName("carro_Compra");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "crear_Compra")
	public void handlecrear(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		long id = (long) session.getAttribute("idSession");
		Cliente cliente = userService.obtenerCliente(id);
		Date fecha = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fecha);
		List<Producto> productos = (List<Producto>) session.getAttribute("lProductoSession");
		for (Producto product : productos) {
			int unidades = product.getStock();
			long idP = product.getIdProducto();
			float pre = product.getPrecio();
			float precioT = pre * unidades;
			Producto producto = productoService.obtenerProducto(idP);
			int stock = producto.getStock();
			int stockResul = stock - unidades;
			producto.setStock(stockResul);
			productoService.editarProducto(producto);
			Compra compra = compraService.hacerCompra(cliente, producto, unidades, fecha, precioT);
		}
		ModelAndView mav = new ModelAndView();

		response.sendRedirect("/A&DStore/");
	}

	/*@RequestMapping(value = "/BorrarC")
	public void handleDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession sesion = request.getSession();
		idC = (long) sesion.getAttribute("compraSession");
		fechaC = (Date) sesion.getAttribute("fechaCompraSession");
		Compra comp = compraService.obtenerCompraPorId(idC);
		Long id = comp.getIdCompra();
		Calendar fecha = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		;
		cal.setTime(fechaC);
		cal.add(Calendar.DAY_OF_YEAR, 15);
		if (fecha.DAY_OF_YEAR <= cal.DAY_OF_YEAR) {
			compraService.devolverCompra(id);
			sesion.invalidate();

			response.sendRedirect("/A&DStore/");
		} else {
			System.out.println("Compra no valida");
		}
	}*/

	@RequestMapping(method = RequestMethod.POST, value = "miscompras")
	public ModelAndView listarProductos(HttpServletRequest request) {
		HttpSession session = request.getSession();
		long id = (long) session.getAttribute("idSession");
		Cliente cliente = userService.obtenerCliente(id);
		ModelAndView mav = new ModelAndView();

		List<Compra> compra = compraService.listarCompras(cliente);

		mav.addObject("compras", compra);
		mav.setViewName("listarcompras");
		return mav;
	}

}
