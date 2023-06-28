package app.directorio.personas.web.bean;

import javax.faces.event.ActionEvent;

import app.directorio.casas.web.bean.DireccionManejado;
import app.directorio.comun.web.bean.ApplicationBaseBean;
import app.directorio.personas.domain.Persona;

public class PersonaManejado extends ApplicationBaseBean {		
	private Persona persona;
	private Object entidad;
	private String metodo;
	
	public PersonaManejado() {
		
	}
	
	public void reCargarPersona() {
		persona = (Persona)obtenerPorId(persona.getId(), Persona.class);
	}
	
	public void registrarDatos(ActionEvent e) {		
		if(persona.getId() == null)
			salvar(persona);
		
		else
			actualizar(persona);
		
		if(entidad != null)
			relacionar(entidad, persona, metodo);
		
		removeBeanSession("personaManejado");
		retornarUrlAnterior();
	}
	
	public void actualizarDatos(ActionEvent e) {
		if(persona.getId() == null)
			salvar(persona);
		
		else
			actualizar(persona);
		
		adicionarMensajeInformacion("Los datos han sido actualizados.");
	}
	
	public void cancelar(ActionEvent e) {
		retornarUrlAnterior();
	}
	
	public void registrarDireccion(ActionEvent e) {		
		DireccionManejado direccionManejado = (DireccionManejado)getBeanValue("direccionManejado");
		direccionManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		direccionManejado.setEntidad(persona);
		direccionManejado.setMetodo("setDireccion");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/direccion/datosDireccion.jsp");
	}

	public Persona getPersona() {
		if(persona == null)
			persona = new Persona();
		
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getDireccion() {					
		if(persona.getDireccion() == null)
			return "Registrar";
		
		return persona.getDireccion().toString();
	}
	
	public void setEntidad(Object entidad) {
		this.entidad = entidad;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public boolean isRegistrada() {
		if(persona != null) {
			if(persona.getNombre() != null)
				return true;
		}
		
		return false;
	}
}
