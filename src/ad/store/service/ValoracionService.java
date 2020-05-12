package ad.store.service;


import java.util.List;

import ad.store.entity.Producto;
import ad.store.entity.Valoracion;

public interface ValoracionService {
	public List<Valoracion> listarValoracionPorProducto(Producto producto);
	public Valoracion hacerValoracion (int valoracion, Producto producto);
}
