package ad.store.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ad.store.entity.Cliente;
import ad.store.entity.Compra;
import ad.store.entity.Producto;
import ad.store.entity.Pregunta;



@Repository
@Component("PreguntaDao")
public class PreguntaDaoImpl extends GenericDaoImpl<Pregunta> implements PreguntaDao{
	private long idCliente;
	private long idProducto;
	


	@Override
	public Pregunta hacerPregunta(String pregunta, Producto producto, Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Pregunta> listarPreguntas(Producto producto, Cliente cliente) {
		idCliente=cliente.getIdCliente();
		idProducto=producto.getIdProducto();
		List<Pregunta> preguntas = new ArrayList<Pregunta>();

        preguntas = this.em
                .createQuery("FROM Pregunta Where idCliente = "+idCliente+" and idProducto = "+idProducto, Pregunta.class).getResultList();
        if (preguntas != null ) {
            return preguntas;
        }
		return null;
	}


	

}