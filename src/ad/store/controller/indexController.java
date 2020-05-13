package ad.store.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ad.store.entity.Producto;
import ad.store.service.ProductoService;
import ad.store.service.ProductoServiceImpl;



@Controller
public class indexController {
	@Autowired
	private ProductoService productoService;
	@GetMapping({"/","index"})
	public String index(Model model) {
		List<Producto> productos = productoService.listarProductos();
		 ArrayList<Producto>oferta = new ArrayList<Producto>();
	        for(int i = 0;i<8 && i< productos.size();i++) {
	        	oferta.add(productos.get(i));

	        		
	        }
		model.addAttribute("productos", oferta);
		return "index";
	}
}
