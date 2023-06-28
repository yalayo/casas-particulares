package app.directorio.configuracion.domain;

import java.util.List;

import cu.desoft.gtm.sigeml.comun.domain.Nomenclador;

public class PreguntaSeleccion extends Pregunta {
	private List<Nomenclador> respuestas;
	
	public PreguntaSeleccion() {
		
	}

	public List<Nomenclador> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Nomenclador> respuestas) {
		this.respuestas = respuestas;
	}
}
