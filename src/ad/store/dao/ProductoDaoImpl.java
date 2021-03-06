package ad.store.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Query;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ad.store.dto.ProductoDto;
import ad.store.entity.Categoria;
import ad.store.entity.Compra;
import ad.store.entity.Producto;
import ad.store.entity.Venta;

@Repository
@Component("ProductoDao")
public class ProductoDaoImpl extends GenericDaoImpl<Producto> implements ProductoDao {
	
    @Autowired
    private ModelMapper modelMapper;
	
	@Override
	public List<Producto> listarProductosPorNombre(String nombreProducto) {
		Query query = this.em
                .createQuery("FROM Producto u where u.nombreProducto LIKE :nombre",Producto.class);
        query.setParameter("nombre",'%'+ nombreProducto +'%');
        List<Producto> lProducto = query.getResultList();
        
        
        if (lProducto != null ) {
            return lProducto;
        }
		return null;
	}
	@Override
	public Producto obtenerProductoPorNombre(String nombreProducto) {
		Query query = this.em
                .createQuery("FROM Producto u where u.nombreProducto = :nombreProducto",Producto.class);
        query.setParameter("nombreProducto",nombreProducto);
        Producto producto = (Producto) query.getSingleResult();
        
        
        if (producto != null ) {
            return producto;
        }
		return null;
	}

	@Override
	public List<Producto> listarProductos() {
		List<Producto> lProducto = new ArrayList<Producto>();

        lProducto = this.em
                .createQuery("FROM Producto", Producto.class).getResultList();
        
        if (lProducto != null ) {
            return lProducto;
        }
		return null;
	}


	@Override
	public Producto crearProducto(String nombre, float precio, int stock, Categoria categoria, String descripcion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto obtenerProducto(long idProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto editarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarProducto(long idProducto) {
		
	}

	@Override
	public List<Producto> obtenerProductosNombre(String nombre, int count, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> obtenerProductosPorPrecio(float minPrecio, float maxPrecio, int count, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoDto> obtenerProductosPorNombre(String nombreProducto) {
		 List<Producto> lProducto = null;
		if(nombreProducto.equalsIgnoreCase("")) {
			Query query = this.em
	                .createQuery("FROM Producto",Producto.class);
	        lProducto = query.getResultList();
		}else {
			Query query = this.em
	                .createQuery("FROM Producto u where u.nombreProducto LIKE :nombre",Producto.class);
	        query.setParameter("nombre",'%'+ nombreProducto +'%');
	        lProducto = query.getResultList();
		}
        
        
        if (lProducto == null ) {
            return null;
        }
        return lProducto.stream()
		          .map(this::convertToProductoDto)
		          .collect(Collectors.toList());
	}
	@Override
	public void eliminarCompra(long idProducto, Compra compra) {
		Producto p = this.find(idProducto);
		p.deleteCompras(compra);
	}
	@Override
	public void eliminarVentas(long idProducto, Venta venta) {
		Producto p = this.find(idProducto);
		p.deleteVentas(venta);
	}
	@Override
	public List<Producto> listarProductosPorCategoria(Categoria categoria) {
		long idCategoria= categoria.getIdCategoria();
		
		Query query = this.em.createQuery("From Producto Where idCategoria = :idCategoria");
		query.setParameter("idCategoria", idCategoria);
		List<Producto> lProducto = query.getResultList();
        
        if (lProducto != null ) {
            return lProducto;
        }
		return null;
	}

	private ProductoDto convertToProductoDto(Producto producto) {
		ProductoDto profesotDto = modelMapper.map(producto, ProductoDto.class);
        return profesotDto;
    }

}
