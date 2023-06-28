package app.directorio.configuracion.service.impl;

import java.util.ArrayList;
import java.util.List;

import app.comun.service.impl.ApplicationServiceImpl;
import app.directorio.configuracion.domain.Pregunta;
import app.directorio.configuracion.service.PreguntaService;
import app.registro.productos.domain.Producto;

public class PreguntaServiceImpl extends ApplicationServiceImpl implements PreguntaService {
	@Override
	public List<Pregunta> consultar(String texto) {
		List<Pregunta> preguntas = (List<Pregunta>)obtenerTodos(Pregunta.class);
    	List<Pregunta> lista = new ArrayList<Pregunta>();
    	
    	for(int i = 0; i < preguntas.size(); i ++) {
    		Pregunta p = preguntas.get(i);
    		boolean adicionar = false;
    		
    		if(!texto.isEmpty()) {
    			if(p.getTexto() != null) {
	    			if(p.getTexto().startsWith(texto)) 
	    				adicionar = true;
	    			
	    			else
	    				adicionar = false;
    			}
    		}
    		
    		else
    			lista.add(p);
    		
    		if(adicionar)
    			lista.add(p);
    	}
    	
    	return lista;
	}
	
	@Override
	public List<Pregunta> obtenerPreguntasPorSeccion(String seccion) {
		List<Pregunta> preguntas = (List<Pregunta>)applicationDao.obtenerTodos(Pregunta.class);
		List<Pregunta> lista = new ArrayList<Pregunta>();
		
		for(int i = 0; i < preguntas.size(); i ++) {
			Pregunta p = preguntas.get(i);
			
			if(p.getSeccion().equals(seccion))
				lista.add(p);
		}
		
		return lista;
	}
}
