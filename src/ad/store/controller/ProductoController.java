package ad.store.controller;

import java.io.IOException;
import java.util.Date;
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
	private String name;
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
	
	@RequestMapping(method = RequestMethod.POST,value="/detallesProducto/{idProducto}")
	public ModelAndView agregarCesta(@PathVariable ("idProducto") long idProducto,@RequestParam("cantidad") int cantidad,HttpServletResponse response,HttpServletRequest request) throws IOException {

		boolean existe = false;
		ModelAndView mav = new ModelAndView();
		int cantidad2 = cantidad;
		Producto productoCesta = productoService.obtenerProducto(idProducto);
		Producto productoVista = productoService.obtenerProducto(idProducto);
		productoCesta.setStock(cantidad2);
		HttpSession sesion = request.getSession();
		List<Producto>cProductos = (List<Producto>) sesion.getAttribute("lProductoSession");
		for(int i = 0; i<cProductos.size();i++) {
			if(cProductos.get(i).getIdProducto() == productoCesta.getIdProducto()) {
				cProductos.get(i).setStock(cProductos.get(i).getStock() + productoCesta.getStock());
				existe = true;
			}
		}
		if(!existe) {
			cProductos.add(productoCesta);
		}
		sesion.setAttribute("lProductoSession", cProductos);
		mav.addObject("producto", productoVista);
		mav.setViewName("detallesproducto");
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/list")
	public ModelAndView listarProductos(@RequestParam("producto") String nombreProducto){

		ModelAndView mav = new ModelAndView();
		//var xhr = new XMLHttpRequest();
		/*xhr.open('PUT','myservice/user/{id}');
		 * xhr.setRequestHeader();
		 * */
		List<Producto> lProducto = productoService.listarProductosPorNombre(nombreProducto);

		mav.addObject("productos", lProducto);
		mav.setViewName("listarproductos");
		return mav;
	}
	@RequestMapping(method = RequestMethod.POST, value = "/listAjax")
	public ModelAndView listarProductosAjax(@RequestParam("producto") String nombreProducto){
        
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
	@RequestMapping(method = RequestMethod.GET,value = "editar_Producto" )
	public String updateView() {
		return "editar_Producto";
	}
	@RequestMapping(method = RequestMethod.POST,value = "editar_Producto")
	public ModelAndView handleEdit(	HttpServletRequest request,HttpServletResponse response,@RequestParam("nombreProducto") String nombre, 
			@RequestParam("precio") float precio,
			@RequestParam("stock") int stock,
			@RequestParam("categoria") String categoria,
			@RequestParam("descripcion") String descripcion) {
		
		HttpSession session = request.getSession();
		
		name=(String) session.getAttribute("accountSession");
		Producto pro = productoService.obtenerProductoPorNombre(name);
		Long id= pro.getIdProducto();
		pro.setIdProducto(id);
		pro.setNombreProducto(nombre);
		pro.setPrecio(precio);
		pro.setStock(stock);
		pro.setCategoria(categoria);
		pro.setDescripcion(descripcion);
		
		Producto producto = productoService.editarProducto(pro);

		ModelAndView mav = new ModelAndView();
		session.setAttribute("productoSession", pro.getNombreProducto());
		mav.addObject("account", producto);
		mav.setViewName("profile");
		return mav;
	}
	@RequestMapping(method = RequestMethod.POST,value = "/agregar")
	public void cambioSesionProducto(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("nombreProducto")String cliente, @RequestParam("precio") float precio,
			@RequestParam("stock") int stock, @RequestParam("categoria") String categoria,
			@RequestParam("descripcion") String descripcion) throws IOException {
		HttpSession sesion = request.getSession();
		List<Producto>cProductos = (List<Producto>) sesion.getAttribute("lProductoSession");
		Producto producto = new Producto(cliente, precio, stock, categoria, descripcion);
		cProductos.add(producto);
		sesion.setAttribute("lProductoSession", cProductos);
		response.sendRedirect("/A&DStore/");
	}
	
	@RequestMapping(value = "/BorrarP")
	public void handleDelete(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession sesion = request.getSession();
		name=(String) sesion.getAttribute("productoSession");
		Producto pro = productoService.obtenerProductoPorNombre(name);
		Long id= pro.getIdProducto();
		productoService.eliminarProducto(id);
	    sesion.invalidate();

			response.sendRedirect("/A&DStore/");


	}
	
}
