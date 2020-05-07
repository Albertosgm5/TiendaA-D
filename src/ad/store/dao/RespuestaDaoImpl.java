package ad.store.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import ad.store.entity.Cliente;
import ad.store.entity.Compra;
import ad.store.entity.Producto;
import ad.store.entity.Respuesta;
import ad.store.entity.Pregunta;



@Repository
@Component("RespuestaDao")
public class RespuestaDaoImpl extends GenericDaoImpl<Respuesta> implements RespuestaDao{
	private long idCliente;
	private long idPregunta;
	@Override
	public Respuesta responder(String respuesta, Pregunta pregunta, Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Respuesta> listarRespuestas(Pregunta pregunta, Cliente cliente) {
		idCliente=cliente.getIdCliente();
		idPregunta=pregunta.getIdPregunta();
		List<Respuesta> respuestas = new ArrayList<Respuesta>();
        
        Query query = this.em
                .createQuery("FROM Respuesta Where idCliente = :idCliente  AND idPregunta = :idPregunta", Respuesta.class);
		query.setParameter("idCliente", idCliente);
		query.setParameter("idPregunta", idPregunta);
		respuestas = query.getResultList();
        if (respuestas != null ) {
            return respuestas;
        }
		return null;
	}
	





	


	

}
