/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.directorio.configuracion.web.bean;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import app.directorio.configuracion.domain.Pregunta;

/**
 *
 * @author david
 */

public class ListarPreguntasManejado extends ConfiguracionBaseManejado {    
    private List<Pregunta> preguntas;
	
	private HtmlDataTable table;
	
	private String nombre;
	
	public ListarPreguntasManejado() {		
		
	}
	
	public void adicionar(ActionEvent e) {		
		removeBeanSession("preguntaManejado");
		removeBeanSession("listarPreguntasManejado");
		PreguntaManejado adicionar = (PreguntaManejado) getBeanValue("preguntaManejado");

		adicionar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());		
		adicionar.getApplicationBeanManejado().navigateTo("/web/paginas/configuracion/adicionarPregunta.jsp");
	}
	
	public void modificar(ActionEvent e) {		
		Pregunta pregunta = (Pregunta)table.getRowData();

		removeBeanSession("preguntaManejado");
		removeBeanSession("listarPreguntasManejado");
		
		PreguntaManejado modificar = (PreguntaManejado) getBeanValue("preguntaManejado");
		modificar.setPregunta(pregunta);
		modificar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		
		modificar.getApplicationBeanManejado().navigateTo("/web/paginas/configuracion/adicionarPregunta.jsp");
	}
	
	public void mostrar(ActionEvent e) {
		
	}
	
	public void eliminar(ActionEvent e) {		
		try {
			Pregunta pregunta = (Pregunta)table.getRowData();
						
			removeBeanSession("listarPreguntasManejado"); 
			
			eliminar(pregunta);
			
			adicionarMensajeInformacion("Pregunta eliminada correctamente.");
		}
		
		catch (Exception ex) {
			adicionarMensajeError(ex.getMessage());
		}
    }
	
	public void consultar(ActionEvent e) {    	
		preguntas = this.getPreguntaService().consultar(nombre);
		
		if(preguntas.isEmpty())
			adicionarMensajeInformacion("No se encontraron coincidencias");
    }

	public List<Pregunta> getPreguntas() {
		if(preguntas == null)
			preguntas = (List<Pregunta>)obtenerTodos(Pregunta.class);
		
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public HtmlDataTable getTable() {
		return table;
	}

	public void setTable(HtmlDataTable table) {
		this.table = table;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}    
}
