/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.directorio.configuracion.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import app.directorio.casas.web.bean.GestionarCasasManejado;
import app.directorio.configuracion.domain.Criterio;
import app.directorio.configuracion.domain.Pregunta;

/**
 *
 * @author david
 */

public class SeleccionarPreguntasManejado extends ConfiguracionBaseManejado {    
    private List<Pregunta> preguntas;
    private List<Criterio> criterios;
	
	private HtmlDataTable table;
	
	private String nombre;
	
	public SeleccionarPreguntasManejado() {		
		
	}
	
	public void adicionarCriterio(Criterio criterio) {
		if(criterios == null)
			criterios = new ArrayList<Criterio>();
		
		criterios.add(criterio);
		
		Pregunta pregunta = criterio.getPregunta();
		
		for(int i = 0; i < preguntas.size(); i ++) {
			Pregunta p = preguntas.get(i);
			
			if(p.getId().equals(pregunta.getId())) {
				preguntas.remove(i);
				return;
			}
		}
	}
	
	public void seleccionar(ActionEvent e) {		
		Pregunta pregunta = (Pregunta)table.getRowData();

		removeBeanSession("criterioManejado");		
		CriterioManejado criterioManejado = (CriterioManejado) getBeanValue("criterioManejado");
		criterioManejado.setPregunta(pregunta);
		
		criterioManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());		
		getApplicationBeanManejado().navigateTo("/web/paginas/configuracion/adicionarCriterio.jsp");
	}
	
	public void mostrar(ActionEvent e) {
		
	}
	
	public void consultar(ActionEvent e) {    	
		preguntas = this.getPreguntaService().consultar(nombre);
		
		if(preguntas.isEmpty())
			adicionarMensajeInformacion("No se encontraron coincidencias");
    }
	
	public void filtrar(ActionEvent e) {
		if(criterios == null) {
			adicionarMensajeError("Debe seleccionar al menos un criterio de busqueda.");
			return;
		}
		
		removeBeanSession("gestionarCasasManejado");
		GestionarCasasManejado gestionarCasasManejado = (GestionarCasasManejado)getBeanValue("gestionarCasasManejado");
		gestionarCasasManejado.setCriterios(criterios);
		
		getApplicationBeanManejado().navigateTo("/web/paginas/casas/gestionarCasas.jsp");
	}
	
	public List<Pregunta> getPreguntas() {
		if(preguntas == null)
			preguntas = (List<Pregunta>)obtenerTodos(Pregunta.class);
		
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public List<Criterio> getCriterios() {
		if(criterios == null)
			criterios = new ArrayList<Criterio>();
		
		return criterios;
	}

	public void setCriterios(List<Criterio> criterios) {
		this.criterios = criterios;
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
	
	public String getDatosCriterios() {
		if(getCriterios().isEmpty())
			return "Sin criterios";
		
		return "Relizar busqueda con " + criterios.size() + " criterios";
	}
}
