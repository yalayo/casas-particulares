package app.registro.productos.web.bean;

import javax.faces.event.ActionEvent;

import app.directorio.comun.web.bean.ApplicationBaseBean;
import app.registro.productos.domain.Producto;
import app.registro.reservaciones.domain.Reservacion;
import app.registro.reservaciones.web.bean.ReservacionManejado;

public class ProductoManejado extends ApplicationBaseBean {		
	private Producto producto;
	private Object entidad;
	private String metodo;
	
	public ProductoManejado() {
		
	}
	
	public void registrarDatos(ActionEvent e) {
		if(producto.getId() == null)
			salvar(producto);
		
		else
			actualizar(producto);
		
		if(entidad != null)
			relacionar(entidad, producto, metodo);
				
		if(entidad instanceof Reservacion) {
			ReservacionManejado reservacionManejado = (ReservacionManejado)getBeanValue("reservacionManejado");
			reservacionManejado.reCargarReservacion();
		}
		
		else {
			//PersonaManejado personaManejado = (PersonaManejado)getBeanValue("personaManejado");
			//personaManejado.reCargarPersona();  Otro bean manejado
		}
		
		removeBeanSession("productoManejado");
		retornarUrlAnterior();
	}
	
	public void cancelar(ActionEvent e) {
		//retornarUrlAnterior();
		System.out.println(e.getComponent().getId());
		System.out.println(e.getSource().toString());
		System.out.println(e.getClass().toString());
	}

	public Producto getProducto() {
		if(producto == null)
			producto = new Producto();
			
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setEntidad(Object entidad) {
		this.entidad = entidad;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
}
