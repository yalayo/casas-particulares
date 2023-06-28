package app.directorio.configuracion.web.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import app.directorio.comun.web.bean.ApplicationBaseBean;
import app.directorio.configuracion.domain.Pregunta;
import app.directorio.configuracion.domain.PreguntaBinaria;
import app.directorio.configuracion.domain.PreguntaEspecifica;
import app.directorio.configuracion.domain.PreguntaFecha;
import app.directorio.configuracion.domain.PreguntaSeleccion;
import cu.desoft.gtm.sigeml.comun.domain.Nomenclador;

public class RespuestaManejado extends ApplicationBaseBean {
	private Pregunta pregunta;
	
	private List<Nomenclador> respuestas;	
	private HtmlDataTable table;
	
	private String numero;
	private String texto;
	
	//private boolean preguntaBinaria;
	private boolean preguntaSimple;
	//private boolean preguntaFecha;
	//private boolean preguntaSeleccion;
	
	private String respuesta;
	private String tipoRespuesta;
	private String seccion;
	
	public RespuestaManejado() {
		tipoRespuesta = Pregunta.ESPECIFICA;
	}
	
	public void registrarDatos(ActionEvent e) {		
		if(tipoRespuesta.equals(Pregunta.BINARIA)) {
			pregunta = new PreguntaBinaria();			
		}
		
		else if(tipoRespuesta.equals(Pregunta.FECHA)) {
			pregunta = new PreguntaFecha();
		}
		
		else if(tipoRespuesta.equals(Pregunta.SELECCION)) {
			pregunta = new PreguntaSeleccion();
			
			
			if(respuestas == null || respuestas.isEmpty()) {
				adicionarMensajeError("Debe registrar al menos una posible respuesta.");
				return;
			}
			
			salvar(pregunta);
			PreguntaSeleccion ps = (PreguntaSeleccion)pregunta;
			
			for(int i = 0; i < respuestas.size(); i ++) {
				Nomenclador resp = respuestas.get(i);
				resp.setKeyWord(pregunta.getId().toString()); // TODO El numero debe ser unico
			}
			
			ps.setRespuestas(respuestas);
		}
		
		else {
			pregunta = new PreguntaEspecifica();
			
		    PreguntaEspecifica pe = (PreguntaEspecifica)pregunta;
		    pe.setSimple(preguntaSimple);		    
		}
		
		pregunta.setNumero(Integer.parseInt(numero));
		pregunta.setTexto(texto);
		pregunta.setSeccion(seccion);
		
		if(pregunta.getId() == null)
			salvar(pregunta);
		
		else
			actualizar(pregunta);
		
		removeBeanSession("preguntaManejado");
		retornarUrlAnterior();
	}
	
	public void actualizarDatos(ActionEvent e) {
		/*if(persona.getId() == null)
			salvar(persona);
		
		else
			actualizar(persona);*/
		
		adicionarMensajeInformacion("Los datos han sido actualizados.");
	}
	
	public void registrarRespuestas(ActionEvent e) {
		setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		getApplicationBeanManejado().navigateTo("/web/paginas/configuracion/registrarRespuestas.jsp");
	}
	
	public void registrarPosibleRespuesta(ActionEvent e) {
		Nomenclador nuevo = null;
		
		for(int i = 0; i < respuestas.size(); i ++) {
			Nomenclador n = respuestas.get(i);
			
			if(n.getValue().equals(respuesta)) {
				adicionarMensajeError("No se pueden repetir las posibles respuestas.");
				return;
			}			
		}
		
		nuevo = new Nomenclador();
		nuevo.setValue(respuesta);
		
		respuestas.add(nuevo);
		
		respuesta = "";
	}
	
	public void cancelar(ActionEvent e) {
		retornarUrlAnterior();
	}

	public Pregunta getPregunta() {				
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public List<Nomenclador> getRespuestas() {
		if(respuestas == null)
			respuestas = new ArrayList<Nomenclador>();
		
		return respuestas;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public boolean isMostrarPreguntaSimple() {
		return tipoRespuesta.equals(Pregunta.ESPECIFICA);
	}
	
	public boolean isPreguntaSimple() {
		return preguntaSimple;
	}

	public void setPreguntaSimple(boolean preguntaSimple) {
		this.preguntaSimple = preguntaSimple;
	}

	public boolean isPreguntaSeleccion() {
		return tipoRespuesta.equals(Pregunta.SELECCION);
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getTipoRespuesta() {
		return tipoRespuesta;
	}

	public void setTipoRespuesta(String tipoRespuesta) {
		this.tipoRespuesta = tipoRespuesta;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getRegistro() {
		if(getRespuestas().isEmpty())
			return "Registrar Respuestas";
		
		return respuestas.size() + " Posibles Respuestas registradas";
	}
}
