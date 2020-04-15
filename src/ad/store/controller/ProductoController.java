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
import ad.store.service.ProductoService;

@Controller
@RequestMapping(value = "/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@RequestMapping("/detallesProducto/{idProducto}")
	public ModelAndView perfilCliente(@PathVariable ("idProducto") long idProducto) {

		ModelAndView mav = new ModelAndView();

		Producto producto = productoService.obtenerProducto(idProducto);
		
		mav.addObject("producto", producto);
		mav.setViewName("detallesproducto");
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/list")
	public ModelAndView listarProductos(@RequestParam("producto") String nombreProducto){

		ModelAndView mav = new ModelAndView();

		List<Producto> lProducto = productoService.listarProductosPorNombre(nombreProducto);

		mav.addObject("productos", lProducto);
		mav.setViewName("listarproductos");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET,value = "crear_Producto" )
	public String signUpView() {
		return "crear_Producto";
	}
	@RequestMapping(method = RequestMethod.POST,value = "crear_Producto")
	public void handleSignUp(HttpServletRequest request,HttpServletResponse response,@RequestParam("nombreProducto") String nombre, 
									@RequestParam("precio") float precio,
									@RequestParam("stock") int stock,
									@RequestParam("categoria") String categoria,
									@RequestParam("descripcion") String descripcion) throws IOException {
		Producto producto = productoService.crearProducto(nombre, precio, stock, categoria, descripcion);

		ModelAndView mav = new ModelAndView();
		if (producto == null) {
			mav.addObject("exception", "Username or password are empty.");
			mav.setViewName("index");
		}
		HttpSession session = request.getSession();

		session.setAttribute("productoSession", nombre);
		 response.sendRedirect("/A&DStore/");
	}
	
}
