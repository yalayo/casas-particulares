package app.registro.reservaciones.web.bean;

import javax.faces.event.ActionEvent;

import app.directorio.comun.web.bean.ApplicationBaseBean;
import app.registro.reservaciones.domain.Factura;
import app.registro.reservaciones.domain.Reservacion;

public class FacturaManejado extends ApplicationBaseBean {		
	private Factura factura;
	private Object entidad;
	private String metodo;
	
	public FacturaManejado() {
		
	}
	
	public void registrarDatos(ActionEvent e) {
		salvar(factura);
		relacionar(entidad, factura, metodo);
		//actualizar(entidad);
		
		if(entidad instanceof Reservacion) {
			ReservacionManejado reservacionManejado = (ReservacionManejado)getBeanValue("reservacionManejado");
			reservacionManejado.reCargarReservacion();
		}
		
		else {
			//PersonaManejado personaManejado = (PersonaManejado)getBeanValue("personaManejado");
			//personaManejado.reCargarPersona();  Otro bean manejado
		}
		
		removeBeanSession("facturaManejado");
		retornarUrlAnterior();
	}
	
	public void cancelar(ActionEvent e) {
		retornarUrlAnterior();
	}

	public Factura getFactura() {
		if(factura == null)
			factura = new Factura();
			
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public void setEntidad(Object entidad) {
		this.entidad = entidad;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
}
