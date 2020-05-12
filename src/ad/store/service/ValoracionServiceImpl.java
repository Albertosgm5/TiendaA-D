package ad.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.store.dao.CategoriaDao;
import ad.store.dao.ProductoDao;
import ad.store.dao.ValoracionDao;
import ad.store.entity.Categoria;
import ad.store.entity.Producto;
import ad.store.entity.Valoracion;

@Transactional
@Service
public class ValoracionServiceImpl implements ValoracionService{
	@Autowired
	ValoracionDao valoracionDao;

	@Autowired
	ProductoDao productoDao;

	@Override
	public List<Valoracion> listarValoracionPorProducto(Producto producto) {
		return valoracionDao.listarValoracionPorProducto(producto);
	}

	@Override
	public Valoracion hacerValoracion(int valoracion, Producto producto) {
		Valoracion valorar = new Valoracion();
		valorar.setValoracion(valoracion);
		valorar.setProducto(producto);
		return valoracionDao.create(valorar);
	}


}
