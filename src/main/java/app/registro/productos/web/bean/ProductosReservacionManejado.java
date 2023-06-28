/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.registro.productos.web.bean;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import app.registro.productos.domain.Producto;
import app.registro.reservaciones.domain.Reservacion;

/**
 *
 * @author david
 */

public class ProductosReservacionManejado extends ProductoBaseManejado {    
    private Reservacion reservacion;
	private List<Producto> productos;	
	private HtmlDataTable table;
	
	private String nombre;
	
	public ProductosReservacionManejado() {		
		
	}
	
	public void adicionar(ActionEvent e) {		
		removeBeanSession("productoManejado");
		removeBeanSession("listarProductosManejado");
		/*ProductoManejado adicionar = (ProductoManejado) getBeanValue("productoManejado");

		adicionar.setUrlAnterior("/web/paginas/productos/listarProductos.jsp");		
		adicionar.getApplicationBeanManejado().navigateTo("/web/paginas/productos/adicionarProducto.jsp");*/
	}
	
	public void modificar(ActionEvent e) {		
		Producto producto = (Producto)table.getRowData();

		/*removeBeanSession("reservacionManejado");
		removeBeanSession("listarReservacionesManejado");
		ReservacionManejado mostrar = (ReservacionManejado) getBeanValue("reservacionManejado");

		mostrar.setReservacion(reservacion);
		mostrar.setUrlAnterior("/web/paginas/reservaciones/listarReservaciones.jsp");
		
		mostrar.getApplicationBeanManejado().navigateTo("/web/paginas/reservaciones/adicionarReservacion.jsp");*/
	}
	
	public void mostrar(ActionEvent e) {
		// TODO Mostrar de otra forma
		Producto producto = (Producto)table.getRowData();

		/*removeBeanSession("reservacionManejado");
		removeBeanSession("listarReservacionesManejado");
		ReservacionManejado mostrar = (ReservacionManejado) getBeanValue("reservacionManejado");

		mostrar.setReservacion(reservacion);
		mostrar.setUrlAnterior("/web/paginas/reservaciones/listarReservaciones.jsp");
		
		mostrar.getApplicationBeanManejado().navigateTo("/web/paginas/reservaciones/adicionarReservacion.jsp");*/
	}
	
	public void eliminar(ActionEvent e) {		
		try {
			Producto producto = (Producto)table.getRowData();
			
			reservacion.eliminarProducto(producto);
			
			actualizar(reservacion);
			eliminar(producto);
					
			adicionarMensajeInformacion("Producto eliminado de la reservacion.");
		}
		
		catch (Exception ex) {
			adicionarMensajeError(ex.getMessage());
		}
    }
	
	public void consultar(ActionEvent e) {    	
		productos = this.getProductoService().consultar(nombre);
		
		if(productos.isEmpty())
			adicionarMensajeInformacion("No se encontraron coincidencias");
    }
	
	public void aceptar(ActionEvent e) {    	
		retornarUrlAnterior();
    }

	public void setReservacion(Reservacion reservacion) {
		this.reservacion = reservacion;
	}

	public List<Producto> getProductos() {				
		return reservacion.getProductos();
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
