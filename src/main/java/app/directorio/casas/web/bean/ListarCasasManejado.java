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
import app.directorio.comun.web.bean.ApplicationBaseBean;

/**
 *
 * @author david
 */

public class ListarCasasManejado extends ApplicationBaseBean {    
    private List<Casa> casas;
	
	private HtmlDataTable table;
	
	private String nombre;
	
	public ListarCasasManejado() {		
		
	}
	
	public void adicionar(ActionEvent e) {		
		removeBeanSession("casaManejado");
		removeBeanSession("listarCasasManejado");
		CasaManejado adicionar = (CasaManejado) getBeanValue("casaManejado");

		adicionar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());		
		adicionar.getApplicationBeanManejado().navigateTo("/web/paginas/casas/adicionarCasa.jsp");
	}
	
	public void modificar(ActionEvent e) {		
		Casa casa = (Casa)table.getRowData();

		removeBeanSession("casaManejado");
		removeBeanSession("listarTrabajadoresManejado");
		CasaManejado mostrar = (CasaManejado) getBeanValue("casaManejado");

		mostrar.setCasa(casa);
		mostrar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		
		mostrar.getApplicationBeanManejado().navigateTo("/web/paginas/casas/adicionarCasa.jsp");
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
			casas = (List<Casa>)obtenerTodos(Casa.class);
		
		return casas;
	}

	public void setCasas(List<Casa> casas) {
		this.casas = casas;
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
