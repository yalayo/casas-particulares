package app.directorio.casas.web.bean;

import javax.faces.event.ActionEvent;

import app.directorio.casas.domain.Casa;
import app.directorio.casas.domain.Direccion;
import app.directorio.comun.web.bean.ApplicationBaseBean;
import app.directorio.personas.web.bean.PersonaManejado;

public class DireccionManejado extends ApplicationBaseBean {		
	private Direccion direccion;
	private Object entidad;
	private String metodo;
	
	public DireccionManejado() {
		
	}
	
	public void registrarDatos(ActionEvent e) {
		salvar(direccion);
		relacionar(entidad, direccion, metodo);
		//actualizar(entidad);
		
		if(entidad instanceof Casa) {
			CasaManejado casaManejado = (CasaManejado)getBeanValue("casaManejado");
			casaManejado.reCargarCasa();
		}
		
		else {
			PersonaManejado personaManejado = (PersonaManejado)getBeanValue("personaManejado");
			personaManejado.reCargarPersona();
		}
		
		removeBeanSession("direccionManejado");
		retornarUrlAnterior();
	}
	
	public void cancelar(ActionEvent e) {
		retornarUrlAnterior();
	}

	public Direccion getDireccion() {
		if(direccion == null)
			direccion = new Direccion();
			
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public void setEntidad(Object entidad) {
		this.entidad = entidad;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
}
