/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.directorio.casas.web.bean;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import app.directorio.casas.domain.Casa;
import app.directorio.casas.domain.Direccion;
import app.directorio.configuracion.domain.Criterio;

/**
 *
 * @author david
 */

public class GestionarCasasManejado extends CasaBaseManejado {    
    private List<Casa> casas;
    private List<Criterio> criterios;
	
	private HtmlDataTable table;
	
	private String nombre;
	
	public GestionarCasasManejado() {		
		
	}
	
	public void adicionar(ActionEvent e) {		
		removeBeanSession("casaManejado");
		removeBeanSession("listarCasasManejado");
		CasaManejado adicionar = (CasaManejado) getBeanValue("casaManejado");

		adicionar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());		
		adicionar.getApplicationBeanManejado().navigateTo("/web/paginas/casas/adicionarCasa.jsp");
	}
	
	public void reservar(ActionEvent e) {		
		Casa casa = (Casa)table.getRowData();

		removeBeanSession("casaManejado");
		removeBeanSession("gestionarCasasManejado");
		
		CasaManejado casaManejado = (CasaManejado) getBeanValue("casaManejado");
		casaManejado.setCasa(casa);
		casaManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		
		getApplicationBeanManejado().navigateTo("/web/paginas/casas/asignarReservacionCasa.jsp");
	}
	
	public void mostrar(ActionEvent e) {
		Casa casa = (Casa)table.getRowData();

		removeBeanSession("casaManejado");
		removeBeanSession("listarTrabajadoresManejado");
		CasaManejado mostrar = (CasaManejado) getBeanValue("casaManejado");

		mostrar.setCasa(casa);
		mostrar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		
		mostrar.getApplicationBeanManejado().navigateTo("/web/paginas/casas/verCasa.jsp");
	}
	
	public void eliminar(ActionEvent e) {		
		try {
			Casa casa = (Casa)table.getRowData();
			Direccion direccion = casa.getDireccion();
			
			removeBeanSession("listarCasasManejado"); 
			
			eliminar(casa);
			if(direccion != null)
				eliminar(direccion);
			
			adicionarMensajeInformacion("Arrendatario eliminado correctamente.");
		}
		
		catch (Exception ex) {
			adicionarMensajeError(ex.getMessage());
		}
    }
	
	public void consultar(ActionEvent e) {
		adicionarMensajeError("Funcionalidad no soportada hasta el momento.");
	}

	public List<Casa> getCasas() {
		if(casas == null)
			casas = getCasaService().filtrarCasas(criterios);
		
		return casas;
	}

	public void setCasas(List<Casa> casas) {
		this.casas = casas;
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
}
