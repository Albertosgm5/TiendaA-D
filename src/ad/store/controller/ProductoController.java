package ad.store.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ad.store.entity.Categoria;
import ad.store.entity.Cliente;
import ad.store.entity.Compra;
import ad.store.entity.Imagen;
import ad.store.entity.Pregunta;
import ad.store.entity.Producto;
import ad.store.entity.Respuesta;
import ad.store.service.CategoriaService;
import ad.store.service.ImagenService;
import ad.store.service.PreguntaService;
import ad.store.service.ProductoService;
import ad.store.service.RespuestaService;
import ad.store.service.UserService;

@Controller
@RequestMapping(value = "/producto")
public class ProductoController {
	private String name;
	@Autowired
	ProductoService productoService;
	@Autowired
	CategoriaService categoriaService;
	@Autowired
	PreguntaService preguntaService;
	@Autowired
	RespuestaService respuestaService;
	@Autowired
	UserService userService;
	@Autowired
	ImagenService imagenService;

	@RequestMapping("/detallesProducto/{idProducto}")
	public ModelAndView perfilProducto(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("idProducto") long idProducto) {
		HttpSession sesion = request.getSession();
		ModelAndView mav = new ModelAndView();
		long id = (long) sesion.getAttribute("idSession");
		Cliente cliente = userService.obtenerCliente(id);
		Producto producto = productoService.obtenerProducto(idProducto);
		List<Pregunta> preguntas = preguntaService.listarPreguntas(producto, cliente);
		Categoria categoria = categoriaService.listarCategoriaPorProducto(producto);
		List<ArrayList> respuestas = new ArrayList<ArrayList>();
		for (Pregunta pregunta : preguntas) {
			ArrayList<Respuesta> listar = new ArrayList<Respuesta>();
			listar = (ArrayList<Respuesta>) respuestaService.listarRespuestas(pregunta, cliente);
			respuestas.add(listar);
		}
		sesion.setAttribute("ProductoSession", producto);
		mav.addObject("producto", producto);
		mav.addObject("categoria", categoria);
		if (preguntas != null) {
			mav.addObject("preguntas", preguntas);
		}
		if (respuestas != null) {
			mav.addObject("respuestas", respuestas);
		}
		mav.setViewName("detallesproducto");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/detallesProducto/{idProducto}")
	public ModelAndView agregarCesta(@PathVariable("idProducto") long idProducto,
			@RequestParam("cantidad") int cantidad, HttpServletResponse response, HttpServletRequest request)
			throws IOException {

		boolean existe = false;
		ModelAndView mav = new ModelAndView();
		int cantidad2 = cantidad;
		Producto productoCesta = productoService.obtenerProducto(idProducto);
		Producto productoVista = productoService.obtenerProducto(idProducto);
		productoCesta.setStock(cantidad2);
		HttpSession sesion = request.getSession();
		List<Producto> cProductos = (List<Producto>) sesion.getAttribute("lProductoSession");

		for (int i = 0; i < cProductos.size(); i++) {
			if (cProductos.get(i).getIdProducto() == productoCesta.getIdProducto()) {
				cProductos.get(i).setStock(cProductos.get(i).getStock() + productoCesta.getStock());
				existe = true;
			}
		}
		if (!existe) {
			cProductos.add(productoCesta);
		}
		sesion.setAttribute("lProductoSession", cProductos);
		mav.addObject("producto", productoVista);
		mav.setViewName("detallesproducto");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/list")
	public ModelAndView listarProductos(@RequestParam("producto") String nombreProducto) {

		ModelAndView mav = new ModelAndView();
		// var xhr = new XMLHttpRequest();
		/*
		 * xhr.open('PUT','myservice/user/{id}'); xhr.setRequestHeader();
		 */
		List<Producto> lProducto = productoService.listarProductosPorNombre(nombreProducto);

		mav.addObject("productos", lProducto);
		mav.setViewName("listarproductos");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/listAjax")
	public ModelAndView listarProductosAjax(@RequestParam("producto") String nombreProducto) {

		ModelAndView mav = new ModelAndView();

		List<Producto> lProducto = productoService.listarProductosPorNombre(nombreProducto);

		mav.addObject("productos", lProducto);
		mav.setViewName("listarproductos");
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = "crear_Producto")
	public ModelAndView signUpView() {
		ModelAndView mav = new ModelAndView();
		List<Categoria> categorias = categoriaService.listarCategorias();
		mav.addObject("categorias", categorias);
		mav.setViewName("crear_Producto");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "crear_Producto")
	public void handleSignUp(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("nombreProducto") String nombre, @RequestParam("precio") float precio,
			@RequestParam("stock") int stock, @RequestParam("categoria") String categoria,
			@RequestParam("descripcion") String descripcion) throws IOException {
		Categoria c = categoriaService.obtenerCategoria(categoria);
		Producto producto = productoService.crearProducto(nombre, precio, stock, c, descripcion);

		ModelAndView mav = new ModelAndView();
		if (producto == null) {
			mav.addObject("exception", "Username or password are empty.");
			mav.setViewName("index");
		}
		HttpSession session = request.getSession();

		session.setAttribute("productoSession", nombre);
		response.sendRedirect("/A&DStore/");
	}

	@RequestMapping("/editar_Producto/{idProducto}")
	public ModelAndView updateView(@PathVariable("idProducto") long idProducto) {
		ModelAndView mav = new ModelAndView();
		Producto producto = productoService.obtenerProducto(idProducto);
		List<Categoria> categorias = categoriaService.listarCategorias();
		mav.addObject("categorias", categorias);
		mav.addObject("producto", producto);
		mav.setViewName("editar_Producto");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/agregar")
	public void cambioSesionProducto(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("nombreProducto") String cliente, @RequestParam("precio") float precio,
			@RequestParam("stock") int stock, @RequestParam("categoria") Categoria categoria,
			@RequestParam("descripcion") String descripcion) throws IOException {
		HttpSession sesion = request.getSession();
		List<Producto> cProductos = (List<Producto>) sesion.getAttribute("lProductoSession");
		Producto producto = new Producto(cliente, precio, stock, categoria, descripcion);
		cProductos.add(producto);
		sesion.setAttribute("lProductoSession", cProductos);
		response.sendRedirect("/A&DStore/");
	}

	@RequestMapping(value = "/borrarproducto/{idProducto}")
	public void handleDelete(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("idProducto") long idProducto) throws IOException {
		productoService.eliminarProducto(idProducto);
		response.sendRedirect("/A&DStore/");

	}

	@RequestMapping(method = RequestMethod.POST, value = "/preguntar/{idProducto}")
	public void preguntar(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("idProducto") long idProducto, @RequestParam("pregunta") String pre) throws IOException {
		HttpSession session = request.getSession();
		long id = (long) session.getAttribute("idSession");
		Cliente cliente = userService.obtenerCliente(id);
		Producto producto = (Producto) session.getAttribute("ProductoSession");
		preguntaService.hacerPregunta(pre, producto, cliente);

		response.sendRedirect("/A&DStore/producto/detallesProducto/" + idProducto);
//		ModelAndView mav = new ModelAndView();
//		if (pregunta == null) {
//			mav.addObject("exception", "Username or password are empty.");
//			mav.setViewName("index");
//		}
//		session.setAttribute("preguntaSession", pregunta);
//		mav.setViewName("");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/responder/{idPregunta}")
	public void responder(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("idPregunta") long idPregunta, @RequestParam("idProducto") long idProducto,
			@RequestParam("respuesta") String res) throws IOException {
		HttpSession session = request.getSession();
		long id = (long) session.getAttribute("idSession");
		Cliente cliente = userService.obtenerCliente(id);
		Pregunta pregunta = preguntaService.obtenerPregunta(idPregunta);
		respuestaService.responder(res, pregunta, cliente);
		response.sendRedirect("/A&DStore/producto/detallesProducto/" + idProducto);

//		ModelAndView mav = new ModelAndView();
//		if (respuesta == null) {
//			mav.addObject("exception", "Username or password are empty.");
//			mav.setViewName("index");
//		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/editar_Producto/{idProducto}")
	public void handleEdit(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("idProducto") long idProducto, @RequestParam("nombreProducto") String nombre,
			@RequestParam("precio") float precio, @RequestParam("stock") int stock,
			@RequestParam("categoria") String categoria, @RequestParam("descripcion") String descripcion,
			@RequestParam("imagen") MultipartFile imagen) throws IOException {

		Categoria c = categoriaService.obtenerCategoria(categoria);
		Producto pro = productoService.obtenerProducto(idProducto);
		pro.setNombreProducto(nombre);
		pro.setPrecio(precio);
		pro.setStock(stock);
		pro.setCategoria(c);
		pro.setDescripcion(descripcion);
		imagenService.actualizaFotoProducto(idProducto, imagen);
		productoService.editarProducto(pro);
		response.sendRedirect("/A&DStore/producto/detallesProducto/" + idProducto);

	}

	@RequestMapping(value = "/imagen/{idProducto}")
	public @ResponseBody ResponseEntity getImageAsResponseEntity(@PathVariable("idProducto") String idProducto) {

		try {
			Producto p = productoService.obtenerProducto(Long.parseLong(idProducto));
			Set<Imagen> imagenes = new HashSet<>();
			imagenes = p.getImagen();
			Iterator<Imagen> it = imagenes.iterator();
			byte[] media = null;
			while (it.hasNext()) {
				media = it.next().getImagen();
			}
			HttpHeaders headers = new HttpHeaders();
			headers.setCacheControl(CacheControl.noCache().getHeaderValue());
			ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
	}

}
