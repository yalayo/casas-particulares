package app.directorio.datos.domain;

import app.directorio.casas.domain.Casa;
import app.directorio.casas.domain.Habitacion;
import app.directorio.configuracion.domain.Pregunta;
import cu.desoft.gtm.sigeml.comun.domain.EntidadPersistente;

public class Dato extends EntidadPersistente {
	private String respuesta;
	private Boolean registrado;
	private Casa casa;
	private Habitacion habitacion;
	private Pregunta pregunta;
	
	public Dato() {
		
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Boolean getRegistrado() {
		return registrado;
	}

	public void setRegistrado(Boolean registrado) {
		this.registrado = registrado;
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
}
