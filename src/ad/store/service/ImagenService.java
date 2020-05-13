package ad.store.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ad.store.dao.ImagenDao;
import ad.store.dao.ProductoDao;
import ad.store.entity.Imagen;
import ad.store.entity.Producto;

@Transactional
@Service
public class ImagenService {

	@Autowired
	private ImagenDao imagenDao;
	
	@Autowired
	private ProductoDao productoDao;
	
	
	
	public Boolean agregarFotoProducto(long idProducto, MultipartFile file) {

		Producto p = productoDao.find(idProducto);

		if (p == null) return false;
		try {
			byte[] image = file.getBytes();
            
				Imagen img = new Imagen(p.getNombreProducto(),image);
				Set<Imagen> imagenes = new HashSet<>();
				imagenes = p.getImagen();
    			imagenes.add(img);
    			img.setProducto(p);
    			p.setImagen(imagenes);
    			imagenDao.save(img);
            
        } catch (Exception e) {
        	e.printStackTrace();
        	return false;
        }
		

		return true;
	}
	
	
}
