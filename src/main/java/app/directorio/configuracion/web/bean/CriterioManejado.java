package app.directorio.configuracion.web.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import app.directorio.casas.domain.Casa;
import app.directorio.configuracion.domain.Criterio;
import app.directorio.configuracion.domain.Pregunta;
import app.directorio.configuracion.domain.PreguntaBinaria;
import app.directorio.configuracion.domain.PreguntaEspecifica;
import app.directorio.configuracion.domain.PreguntaFecha;
import app.directorio.configuracion.domain.PreguntaSeleccion;
import app.directorio.datos.domain.Dato;
import cu.desoft.gtm.sigeml.comun.domain.Nomenclador;
import cu.desoft.gtm.sigeml.core.jsf.util.InterfaceUtils;

public class CriterioManejado extends ConfiguracionBaseManejado {
	private Pregunta pregunta;
	private Criterio criterio;
	
	private List<Pregunta> preguntas;
	private List<Nomenclador> respuestas;
	private List<SelectItem> elementos;
	
	private Map<Integer, Dato> datos;
	
	private HtmlDataTable table;
	
	private String respuesta;
	private String seccion;
	private Boolean respuestaBinaria;
	private Date respuestaFecha;
	private Nomenclador respuestaSeleccion;
	private int posicionActual;
	private int posicionAnterior;
	private int posicionSiguiente;
	
	public CriterioManejado() {
		
	}
	
	private void init() {
		/*preguntas = getPreguntaService().obtenerPreguntasPorSeccion(seccion);
				
		if(!preguntas.isEmpty()) {
			pregunta = preguntas.get(0);
			cargarDatos();
			//dato = datos.get(pregunta.getId());
			
			//if(dato != null)
				//respuesta = dato.getRespuesta();
			
			posicionActual = 0;
			posicionAnterior = -1;
			posicionSiguiente = 1;
		}*/
		
		cargarDatos();
	}
	
	private void cargarDatos() {
		if(pregunta != null) {
			/*List<Dato> lista = getDatoService().obtenerDatosCasa(pregunta.getId());
			datos = new HashMap<Integer, Dato>();
			
			for(int i = 0; i < lista.size(); i ++) {
				Dato d = lista.get(i);
				Pregunta p = d.getPregunta();
				
				datos.put(p.getId(), d);			
			}*/
			
			if(pregunta instanceof PreguntaSeleccion) {
				if(respuestas == null) {
					PreguntaSeleccion ps = (PreguntaSeleccion)pregunta;
					respuestas = ps.getRespuestas();
				}
			}
		}
	}
	
	private Nomenclador obtenerRespuesta(String respuesta) {
		if(respuestas != null) {
			for(int i = 0; i < respuestas.size(); i ++) {
				Nomenclador n = respuestas.get(i);
				
				if(n.getValue().equals(respuesta))
					return n;
			}
		}
		
		return null;
	}
	
	public void registrarDatos(ActionEvent e) {		
		if(criterio == null)
			criterio = new Criterio();
		
		//dato.setCasa(casa);
		criterio.setPregunta(pregunta);
		criterio.setValor(respuesta);
		
		if(pregunta instanceof PreguntaBinaria)
			criterio.setValor(respuestaBinaria.toString());
		
		else if(pregunta instanceof PreguntaFecha)
			criterio.setValor(String.valueOf(respuestaFecha.getTime()));
		
		else if(pregunta instanceof PreguntaSeleccion)
			criterio.setValor(String.valueOf(respuestaSeleccion.getValue()));
		
		/*if(dato.getId() == null)
			salvar(dato);
		
		else
			actualizar(dato);*/
		
		SeleccionarPreguntasManejado seleccionarPreguntasManejado = (SeleccionarPreguntasManejado)getBeanValue("seleccionarPreguntasManejado");
		seleccionarPreguntasManejado.adicionarCriterio(criterio);
		
		respuesta = "";
		retornarUrlAnterior();
	}
	
	public void actualizarDatos(ActionEvent e) {
		/*if(persona.getId() == null)
			salvar(persona);
		
		else
			actualizar(persona);*/
		
		//adicionarMensajeInformacion("Los datos han sido actualizados.");
	}
	
	public void registrarRespuestas(ActionEvent e) {
		setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		getApplicationBeanManejado().navigateTo("/web/paginas/configuracion/registrarRespuestas.jsp");
	}
	
	/*public void anterior(ActionEvent e) {
		preguntaAnterior();
	}
	
	public void siguiente(ActionEvent e) {
		preguntaSiguiente();
	}*/
	
	public void cancelar(ActionEvent e) {
		retornarUrlAnterior();
	}
	
	/*private void preguntaSiguiente() {
		posicionAnterior ++;
		posicionActual ++;
		posicionSiguiente ++;
		
		respuesta = "";
		
		if(posicionActual < preguntas.size()) {
			pregunta = preguntas.get(posicionActual);
			cargarDatos();
			dato = datos.get(pregunta.getId());
			
			if(dato != null)
				respuesta = dato.getRespuesta();			
		}
	}
	
	private void preguntaAnterior() {
		posicionAnterior --;
		posicionActual --;
		posicionSiguiente --;
		
		respuesta = "";
		
		if(posicionActual >= 0) {
			pregunta = preguntas.get(posicionActual);
			cargarDatos();
			dato = datos.get(pregunta.getId());
			
			if(dato != null)
				respuesta = dato.getRespuesta();
		}
		
		cargarDatos();
	}*/

	public Pregunta getPregunta() {				
		//if(pregunta == null)
			//getPreguntas();
		
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public List<Pregunta> getPreguntas() {
		if(preguntas == null)
			init();
			
		return preguntas;
	}

	public List<Nomenclador> getRespuestas() {
		if(respuestas == null)
			respuestas = new ArrayList<Nomenclador>();
		
		return respuestas;
	}

	public List<SelectItem> getElementos() {
		if(respuestas == null)
			cargarDatos();
		
		if(elementos == null)
			elementos = InterfaceUtils.crearSelectItemAsObject(respuestas.iterator());
		
		return elementos;
	}

	public void setElementos(List<SelectItem> elementos) {
		this.elementos = elementos;
	}

	public void setRespuestas(List<Nomenclador> respuestas) {
		this.respuestas = respuestas;
	}

	public HtmlDataTable getTable() {
		return table;
	}

	public void setTable(HtmlDataTable table) {
		this.table = table;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getUrl() {
		if(pregunta == null)
			getPregunta();
		
		if(pregunta instanceof PreguntaEspecifica)
			return Criterio.URL_ESPECIFICA;
		
		else if(pregunta instanceof PreguntaBinaria)
			return Criterio.URL_BINARIA;
		
		else if(pregunta instanceof PreguntaSeleccion)
			return Criterio.URL_SELECCION;
		
		else
			return Criterio.URL_FECHA;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public boolean isRespuestaBinaria() {
		if(respuestaBinaria == null)
			respuestaBinaria = false;
		
		cargarDatos();
		/*dato = datos.get(pregunta.getId());
		
		if(dato != null) {
			respuesta = dato.getRespuesta();
			respuestaBinaria = new Boolean(respuesta);
		}*/
		
		return respuestaBinaria;
	}

	public void setRespuestaBinaria(boolean respuestaBinaria) {
		this.respuestaBinaria = respuestaBinaria;
	}

	public Date getRespuestaFecha() {
		if(respuestaFecha == null)
			respuestaFecha = new Date();
		
		cargarDatos();
		/*dato = datos.get(pregunta.getId());
		
		if(dato != null) {
			respuesta = dato.getRespuesta();
			respuestaFecha = new Date(Long.valueOf(respuesta));
		}*/
		
		return respuestaFecha;
	}

	public void setRespuestaFecha(Date respuestaFecha) {
		this.respuestaFecha = respuestaFecha;
	}

	public Nomenclador getRespuestaSeleccion() {
		if(respuestaSeleccion == null)
			respuestaSeleccion = new Nomenclador();
		
		if(respuestas == null) {
			PreguntaSeleccion ps = (PreguntaSeleccion)pregunta;
			respuestas = ps.getRespuestas();
		}
		
		cargarDatos();
		/*dato = datos.get(pregunta.getId());
		
		if(dato != null) {
			respuesta = dato.getRespuesta();
			respuestaSeleccion = obtenerRespuesta(respuesta);			
		}*/
		
		return respuestaSeleccion;
	}

	public void setRespuestaSeleccion(Nomenclador respuestaSeleccion) {
		this.respuestaSeleccion = respuestaSeleccion;
	}

	public boolean isRespuestaSimple() {
		if(pregunta instanceof PreguntaEspecifica) {
			PreguntaEspecifica p = (PreguntaEspecifica)pregunta;
			return p.getSimple();
		}
		
		return false;
	}
	
	public boolean isAnteriorEnabled() {
		return posicionAnterior != -1;
	}
	
	public boolean isSiguienteEnabled() {
		return posicionSiguiente < preguntas.size();
	}

	public String getRegistro() {
		if(getRespuestas().isEmpty())
			return "Registrar Respuestas";
		
		return respuestas.size() + " Posibles Respuestas registradas";
	}
}
