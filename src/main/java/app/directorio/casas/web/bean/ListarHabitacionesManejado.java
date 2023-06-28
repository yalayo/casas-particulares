/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.directorio.casas.web.bean;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import app.directorio.casas.domain.Casa;
import app.directorio.casas.domain.Habitacion;
import app.directorio.comun.web.bean.ApplicationBaseBean;
import app.directorio.configuracion.domain.Pregunta;
import app.directorio.datos.web.bean.DatoManejado;
import app.directorio.personas.domain.Persona;
import app.directorio.personas.web.bean.PersonaManejado;

/**
 *
 * @author david
 */

public class ListarHabitacionesManejado extends ApplicationBaseBean {    
    private List<Habitacion> habitaciones;
    private Casa casa;
    private String metodo;
	
	private HtmlDataTable table;
	
	private String nombre;
	
	public ListarHabitacionesManejado() {		
		
	}
	
	public void adicionar(ActionEvent e) {		
		removeBeanSession("personaManejado");
		removeBeanSession("listarPersonasManejado");
		
		PersonaManejado personaManejado = (PersonaManejado)getBeanValue("personaManejado");
		personaManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
				
		getApplicationBeanManejado().navigateTo("/web/paginas/personas/datosPersona.jsp");
	}
	
	public void modificar(ActionEvent e) {		
		Persona persona = (Persona)table.getRowData();

		removeBeanSession("personaManejado");
		removeBeanSession("listarPersonasManejado");
		PersonaManejado modificar = (PersonaManejado) getBeanValue("personaManejado");

		modificar.setPersona(persona);
		modificar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		
		modificar.getApplicationBeanManejado().navigateTo("/web/paginas/personas/datosPersona.jsp");
	}
	
	public void mostrar(ActionEvent e) {
		/*Trabajador trabajador = (Trabajador)table.getRowData();

		removeBeanSession("mostrarTrabajadorManejado");
		removeBeanSession("listarTrabajadoresManejado");
		MostrarTrabajadorManejado mostrar = (MostrarTrabajadorManejado) getBeanValue("mostrarTrabajadorManejado");

		mostrar.setTrabajador(trabajador);
		mostrar.setUrlAnterior("/web/paginas/trabajadores/listarTrabajadores.jsp");
		
		mostrar.getApplicationBeanManejado().navigateTo("/web/paginas/trabajadors/verTrabajador.jsp");*/
	}
	
	public void seleccionar(ActionEvent e) {		
		Habitacion habitacion = (Habitacion)table.getRowData();
		
		removeBeanSession("datoManejado");
		
		DatoManejado datoManejado = (DatoManejado)getBeanValue("datoManejado");
		datoManejado.setHabitacion(habitacion);
		datoManejado.setSeccion(Pregunta.VIVIENDA);
		datoManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		
		getApplicationBeanManejado().navigateTo("/web/paginas/casas/datosEdificio.jsp");
	}
	
	public void eliminar(ActionEvent e) {		
    	try {
			Persona persona = (Persona)table.getRowData();
			
			eliminar(persona);
			
			removeBeanSession("listarPersonasManejado");	
			adicionarMensajeInformacion("Persona eliminada correctamente.");
    	}
    	
    	catch (Exception ex) {
			adicionarMensajeError(ex.getMessage());
		}
    }
	
	public void cancelar(ActionEvent e) {
		retornarUrlAnterior();
	}
	
	public void consultar(ActionEvent e) {
		adicionarMensajeError("Funcionalidad no soportada hasta el momento.");
	}

	public List<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(List<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
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
