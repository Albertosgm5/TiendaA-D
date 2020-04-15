package ad.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
}
