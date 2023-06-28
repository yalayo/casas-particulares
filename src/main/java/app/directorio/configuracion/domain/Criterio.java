package app.directorio.configuracion.domain;

import cu.desoft.gtm.sigeml.comun.domain.EntidadPersistente;

public class Criterio extends EntidadPersistente {
	public static String URL_ESPECIFICA = "/web/paginas/configuracion/criterioEspecifica.jsp";
	public static String URL_BINARIA = "/web/paginas/configuracion/criterioBinaria.jsp";
	public static String URL_SELECCION = "/web/paginas/configuracion/criterioSeleccion.jsp";
	public static String URL_FECHA = "/web/paginas/configuracion/criterioFecha.jsp";
	
	private String valor;
	private Pregunta pregunta;
	
	public Criterio() {
		
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
}
