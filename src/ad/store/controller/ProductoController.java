package ad.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ad.store.entity.Producto;
import ad.store.service.ProductoService;

@Controller
@RequestMapping(value = "/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@RequestMapping(method = RequestMethod.GET,value = "/{id}")
	public ModelAndView perfilCliente(@PathVariable ("id") long idProducto) {

		ModelAndView mav = new ModelAndView();

		Producto producto = productoService.obtenerProducto(idProducto);
		
		mav.addObject("producto", producto);
		mav.setViewName("producto_perfil");
		return mav;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public ModelAndView listarProductos() {

		ModelAndView mav = new ModelAndView();

		List<Producto> lProducto = productoService.listarProductos();

		mav.addObject("profesores", lProducto);
		mav.setViewName("profesor_lista");
		return mav;
	}
	
}
