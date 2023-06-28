/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.registro.reservaciones.web.bean;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import app.directorio.casas.domain.Casa;
import app.directorio.casas.web.bean.CasaManejado;
import app.directorio.personas.domain.Persona;
import app.registro.productos.domain.Producto;
import app.registro.reservaciones.domain.Reservacion;

/**
 *
 * @author david
 */

public class ListarReservacionesManejado extends ReservacionBaseManejado {    
    private List<Reservacion> reservaciones;	
    
    private Casa casa;
    private String metodo;
    
	private HtmlDataTable table;
	
	private String nombre;
	private String numero;
	private String numeroReservaCubanacan;
	private String numeroReservaCubatur;
	
	public ListarReservacionesManejado() {		
		
	}
	
	public void adicionar(ActionEvent e) {		
		removeBeanSession("reservacionManejado");
		removeBeanSession("listarReservacionesManejado");
		ReservacionManejado adicionar = (ReservacionManejado) getBeanValue("reservacionManejado");

		adicionar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());		
		adicionar.getApplicationBeanManejado().navigateTo("/web/paginas/reservaciones/adicionarReservacion.jsp");
	}
	
	public void modificar(ActionEvent e) {		
		Reservacion reservacion = (Reservacion)table.getRowData();

		removeBeanSession("reservacionManejado");
		removeBeanSession("listarReservacionesManejado");
		ReservacionManejado mostrar = (ReservacionManejado) getBeanValue("reservacionManejado");

		mostrar.setReservacion(reservacion);
		mostrar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		
		mostrar.getApplicationBeanManejado().navigateTo("/web/paginas/reservaciones/adicionarReservacion.jsp");
	}
	
	public void mostrar(ActionEvent e) {
		// TODO Mostrar de otra forma
		Reservacion reservacion = (Reservacion)table.getRowData();

		removeBeanSession("reservacionManejado");
		removeBeanSession("listarReservacionesManejado");
		ReservacionManejado mostrar = (ReservacionManejado) getBeanValue("reservacionManejado");

		mostrar.setReservacion(reservacion);
		mostrar.setUrlAnterior("/web/paginas/reservaciones/listarReservaciones.jsp");
		
		mostrar.getApplicationBeanManejado().navigateTo("/web/paginas/reservaciones/adicionarReservacion.jsp");
	}
	
	public void cancelar(ActionEvent e) {
		retornarUrlAnterior();
	}
	
	public void seleccionar(ActionEvent e) {		
		Reservacion reservacion = (Reservacion)table.getRowData();
		
		try {
			if(casa != null) {
				getReservacionService().reservarCasa(reservacion, casa.getId());
				
				CasaManejado casaManejado = (CasaManejado)getBeanValue("casaManejado");
				casaManejado.reCargarCasa();
			}	
			
			retornarUrlAnterior();
		}
		
		catch (Exception ex) {
			adicionarMensajeError(ex.getMessage());
		}
	}
	
	public void eliminar(ActionEvent e) {		
		try {
			Reservacion reservacion = (Reservacion)table.getRowData();
	
			removeBeanSession("listarReservacionesManejado"); 
			
			eliminar(reservacion);		
			List<Producto> productos =  reservacion.getProductos();		
			
			if(productos != null) {
				for(int i = 0; i < productos.size(); i ++) {
					Producto p = productos.get(i);
					eliminar(p);
				}
			}	
			
			adicionarMensajeInformacion("Reservacion eliminada correctamente.");
		}
		
		catch (Exception ex) {
			adicionarMensajeError(ex.getMessage());
		}
    }
	
	public void consultar(ActionEvent e) {    	
		reservaciones = this.getReservacionService().consultar(nombre, numero, numeroReservaCubanacan, numeroReservaCubatur);
		
		if(reservaciones.isEmpty())
			adicionarMensajeInformacion("No se encontraron coincidencias");
    }

	public List<Reservacion> getReservaciones() {
		if(reservaciones == null)
			reservaciones = (List<Reservacion>)obtenerTodos(Reservacion.class);
		
		return reservaciones;
	}

	public void setReservaciones(List<Reservacion> reservaciones) {
		this.reservaciones = reservaciones;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNumeroReservaCubanacan() {
		return numeroReservaCubanacan;
	}

	public void setNumeroReservaCubanacan(String numeroReservaCubanacan) {
		this.numeroReservaCubanacan = numeroReservaCubanacan;
	}

	public String getNumeroReservaCubatur() {
		return numeroReservaCubatur;
	}

	public void setNumeroReservaCubatur(String numeroReservaCubatur) {
		this.numeroReservaCubatur = numeroReservaCubatur;
	}  
}
