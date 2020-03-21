package ad.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ad.store.service.ProductoService;

@Controller
@RequestMapping(value = "/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	
}
