package ad.store.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

import ad.store.entity.Categoria;
import ad.store.entity.Cliente;
import ad.store.entity.Compra;
import ad.store.entity.Pregunta;
import ad.store.entity.Producto;
import ad.store.entity.Respuesta;
import ad.store.service.CategoriaService;
import ad.store.service.PreguntaService;
import ad.store.service.ProductoService;
import ad.store.service.RespuestaService;
import ad.store.service.UserService;

@Controller
@RequestMapping(value = "/categoria")
public class CategoriaController {
	@Autowired
	CategoriaService categoriaService;
	

	@RequestMapping("/detallesCategoria/{idCategoria}")
	public ModelAndView perfilCategoria(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("idCategoria") long idCategoria) {
		HttpSession sesion = request.getSession();
		ModelAndView mav = new ModelAndView();
		Categoria categoria = categoriaService.obtenerCategoriaPorId(idCategoria);
		sesion.setAttribute("CategoriaSession", categoria);
		mav.addObject("categoria", categoria);
		mav.setViewName("detallesproducto");
		return mav;
	}



	@RequestMapping(method = RequestMethod.POST, value = "/list")
	public ModelAndView listarCategorias() {

		ModelAndView mav = new ModelAndView();
		
		List<Categoria> lCategoria = categoriaService.listarCategorias();

		mav.addObject("categorias", lCategoria);
		mav.setViewName("listarproductos");
		return mav;
	}


	@RequestMapping(method = RequestMethod.GET, value = "crear_Categoria")
	public String signUpView() {
		return "crear_Categoria";
	}

	@RequestMapping(method = RequestMethod.POST, value = "crear_Categoria")
	public void handleSignUp(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("nombreCategoria") String nombreCategoria, 
			@RequestParam("descripcionCategoria") String descripcionCategoria) throws IOException {
		Categoria categoria = categoriaService.crearCategoria(nombreCategoria, descripcionCategoria);

		ModelAndView mav = new ModelAndView();
		if (categoria == null) {
			mav.addObject("exception", "Username or password are empty.");
			mav.setViewName("index");
		}
		HttpSession session = request.getSession();

		session.setAttribute("categoriaSession", nombreCategoria);
		response.sendRedirect("/A&DStore/");
	}

	@RequestMapping("/editar_Categoria/{idCategoria}")
	public ModelAndView updateView(@PathVariable("idCategoria") long idCategoria) {
		ModelAndView mav = new ModelAndView();
		Categoria categoria = categoriaService.obtenerCategoriaPorId(idCategoria);
		mav.addObject("categoria", categoria);
		mav.setViewName("editar_Categoria");
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/editar_Categoria/{idCategoria}")
	public void handleEdit(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("idCategoria") long idCategoria, @RequestParam("nombreCategoria") String nombreCategoria,
			@RequestParam("descripcionCategoria") String descripcionCategoria)
			throws IOException {

		Categoria cat = categoriaService.obtenerCategoriaPorId(idCategoria);
		cat.setNombreCategoria(nombreCategoria);
		cat.setDescripcionCategoria(descripcionCategoria);

		categoriaService.editarCategoria(cat);
		response.sendRedirect("/A&DStore/producto/detallesProducto/" + idCategoria);

	}

	@RequestMapping(value = "/borrarcategoria/{idCategoria}")
	public void handleDelete(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("idCategoria") long idCategoria) throws IOException {
		categoriaService.borrarCategoria(idCategoria);
		response.sendRedirect("/A&DStore/");

	}



}
