/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.directorio.personas.web.bean;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import app.directorio.casas.domain.Casa;
import app.directorio.casas.web.bean.CasaManejado;
import app.directorio.comun.web.bean.ApplicationBaseBean;
import app.directorio.personas.domain.Persona;
import app.registro.reservaciones.domain.Reservacion;
import app.registro.reservaciones.web.bean.ReservacionManejado;

/**
 *
 * @author david
 */

public class ListarPersonasManejado extends ApplicationBaseBean {    
    private List<Persona> personas;
    private Casa casa;
    private Reservacion reservacion;
    private String metodo;
	
	private HtmlDataTable table;
	
	private String nombre;
	
	public ListarPersonasManejado() {		
		
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
		Persona persona = (Persona)table.getRowData();
		
		if(casa != null) {
			relacionar(casa, persona, metodo);
			
			CasaManejado casaManejado = (CasaManejado)getBeanValue("casaManejado");
			casaManejado.reCargarCasa();		
			
			//getApplicationBeanManejado().navigateTo("/web/paginas/casas/adicionarCasa.jsp");
		}
		
		else {
			relacionar(reservacion, persona, metodo);
			
			ReservacionManejado reservacionManejado = (ReservacionManejado)getBeanValue("reservacionManejado");
			reservacionManejado.reCargarReservacion();		
			
			//getApplicationBeanManejado().navigateTo("/web/paginas/reservaciones/otrosDatosReservacion.jsp");
		}	
		
		retornarUrlAnterior();
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

	public List<Persona> getPersonas() {
		if(personas == null)
			personas = (List<Persona>)obtenerTodos(Persona.class);
		
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public void setReservacion(Reservacion reservacion) {
		this.reservacion = reservacion;
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
