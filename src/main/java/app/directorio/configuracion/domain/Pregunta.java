package app.directorio.configuracion.domain;

import cu.desoft.gtm.sigeml.comun.domain.EntidadPersistente;

public class Pregunta extends EntidadPersistente {
	public static String ESPECIFICA = "esp";
	public static String BINARIA = "bin";
	public static String SELECCION = "sel";
	public static String FECHA = "fech";
	public static String EDIFICIO = "edif";
	public static String VIVIENDA = "vivienda";
	public static String HABITACION = "habitacion";
	public static String URL_ESPECIFICA = "/web/paginas/configuracion/preguntaEspecifica.jsp";
	public static String URL_BINARIA = "/web/paginas/configuracion/preguntaBinaria.jsp";
	public static String URL_SELECCION = "/web/paginas/configuracion/preguntaSeleccion.jsp";
	public static String URL_FECHA = "/web/paginas/configuracion/preguntaFecha.jsp";
	
	private Integer numero;
	private String texto;	
	private String seccion;
	//private Integer tipo;
	
	public Pregunta() {
		
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
}
