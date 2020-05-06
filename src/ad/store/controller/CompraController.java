package ad.store.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import ad.store.entity.Compra;
import ad.store.entity.Producto;
import ad.store.entity.Venta;
import ad.store.service.CompraService;
import ad.store.service.ProductoService;
import ad.store.service.UserService;
import ad.store.service.VentaService;

@Controller
@RequestMapping(value = "/compras")
public class CompraController {
	private Date fechaC;
	private long idC;
	@Autowired
	CompraService compraService;
	@Autowired
	UserService userService;
	@Autowired
	ProductoService productoService;
	@Autowired
	VentaService ventaService;
	
	@RequestMapping(method = RequestMethod.GET, value="/detallesCompra/{idCompra}")
	public ModelAndView perfilCompra(HttpServletRequest request,
			@PathVariable ("idCompra") long idCompra) {
		HttpSession session = request.getSession();
		long id = (long) session.getAttribute("idSession");
		Cliente cliente = userService.obtenerCliente(id);
		ModelAndView mav = new ModelAndView();
		Compra compra = compraService.obtenerCompraPorId(idCompra);
		List <Venta> ventas = new ArrayList<Venta>();
		Set<Producto> productos = new HashSet<>();
		productos = compra.getProductos();
		for(Producto producto : productos) {
			ventas.add(ventaService.obtenerVenta(cliente, producto, compra));
		}
		mav.addObject("ventas", ventas);
		mav.addObject("compra", compra);
		mav.setViewName("detallescompra");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/cesta")
	public ModelAndView cesta(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		List<Producto> cProductos = (List<Producto>) session.getAttribute("lProductoSession");
		mav.addObject("productos", cProductos);
		mav.setViewName("carro_Compra");
		return mav;
	}

	@RequestMapping("/crear_Compra")
	public void handlecrear(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		long id = (long) session.getAttribute("idSession");
		Cliente cliente = userService.obtenerCliente(id);
		Date fecha = new Date();
		Calendar cal = Calendar.getInstance();
		fecha=cal.getTime();
		List<Producto> productos = (List<Producto>) session.getAttribute("lProductoSession");
		int unidades = 0;
		float precioT = 3.99f;
		Set<Producto> productos2 = new HashSet<>();
		for (Producto product : productos) {
			unidades = product.getStock();
			float pre = product.getPrecio();
			precioT += pre * unidades;
			productos2.add(product);
		}
		Compra compra = compraService.hacerCompra(cliente, productos2, fecha, precioT);
		for (Producto product : productos) {
			unidades = product.getStock();
			long idP = product.getIdProducto();
			Producto producto = productoService.obtenerProducto(idP);
			int stock = producto.getStock();
			int stockResul = stock - unidades;
			producto.setStock(stockResul);
			productoService.editarProducto(producto);
			Venta venta = ventaService.hacerVenta(cliente, producto, compra, unidades);
		}
		session.setAttribute("lProductoSession", new ArrayList<Producto>());
		ModelAndView mav = new ModelAndView();

		response.sendRedirect("/A&DStore/");
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/devolucion/{idCompra}")
	public void handleDelete(HttpServletRequest request, HttpServletResponse response,@PathVariable ("idCompra") long idCompra) throws IOException {
		Compra compra = compraService.obtenerCompraPorId(idCompra);
		HttpSession session = request.getSession();
		Cliente c = userService.obtenerCliente((long) session.getAttribute("idSession"));
		Long id = compra.getIdCompra();
		fechaC = compra.getFecha();
		Calendar fecha = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaC);
		cal.add(Calendar.DAY_OF_YEAR, 15);
		if (fecha.DAY_OF_YEAR <= cal.DAY_OF_YEAR) {
			List <Venta> ventas = new ArrayList<Venta>();
			Set<Producto> productos = new HashSet<>();
			productos = compra.getProductos();
			for(Producto producto : productos) {
				ventas.add(ventaService.obtenerVenta(c, producto, compra));
			}
			int cont = 0;
			for(Producto producto : productos) {
				productoService.eliminarComprayVenta(producto.getIdProducto(), ventas.get(cont).getIdVenta(), idCompra);
				cont++;
			}
			
			userService.eliminarCompra(c.getIdCliente(), idCompra);

			response.sendRedirect("/A&DStore/");
		} else {
			System.out.println("Compra no valida");
		}
	}

	@RequestMapping("/miscompras")
	public ModelAndView listarCompras(HttpServletRequest request) {
		HttpSession session = request.getSession();
		long id = (long) session.getAttribute("idSession");
		Cliente cliente = userService.obtenerCliente(id);
		ModelAndView mav = new ModelAndView();

		List<Compra> compras = compraService.listarCompras(cliente);
		mav.addObject("compras", compras);
		mav.setViewName("listarcompras");
		return mav;
	}

}
