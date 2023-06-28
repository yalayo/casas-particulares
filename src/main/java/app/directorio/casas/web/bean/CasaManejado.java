package app.directorio.casas.web.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIComponentBase;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;

import org.apache.myfaces.custom.div.Div;

import app.directorio.casas.domain.Casa;
import app.directorio.comun.web.bean.ApplicationBaseBean;
import app.directorio.configuracion.domain.Pregunta;
import app.directorio.datos.web.bean.DatoManejado;
import app.directorio.personas.web.bean.ListarPersonasManejado;
import app.directorio.personas.web.bean.PersonaManejado;
import app.registro.reservaciones.domain.Reservacion;
import app.registro.reservaciones.service.ReservacionService;
import app.registro.reservaciones.web.bean.ListarReservacionesManejado;

public class CasaManejado extends CasaBaseManejado {
	private Casa casa;
	private String nombreCasa;
	
	private List<Reservacion> reservaciones;
	
	private boolean mostrarNombre;
	
	private Div principal;
		
	public CasaManejado() {
		casa = new Casa();
		
		mostrarNombre = false;
	}
	
	public void reCargarCasa() {
		casa = (Casa)obtenerPorId(casa.getId(), Casa.class);
	}
	
	public void actualizarNombre(ActionEvent e) {
		mostrarNombre = false;
	}
	
	public void actualizarDatos(ActionEvent e) {
		if(casa.getId() == null)
			salvar(casa);
		
		else
			actualizar(casa);
		
		adicionarMensajeInformacion("Los datos han sido actualizados.");
	}
	
	public void registrarCasa(ActionEvent e) {
		if(casa.getId() == null)
			salvar(casa);
		
		else
			actualizar(casa);
		
		adicionarMensajeInformacion("Arrendatario registrado satisfactoriamente.");
		retornarUrlAnterior();
	}
	
	public void aceptar(ActionEvent e) {
		retornarUrlAnterior();
	}
	
	public void cancelar(ActionEvent e) {
		retornarUrlAnterior();
	}
	
	public void seleccionarDuenho(ActionEvent e) {
		ListarPersonasManejado listar = (ListarPersonasManejado)getBeanValue("listarPersonasManejado");
		listar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		listar.setCasa(casa);
		listar.setMetodo("setDuenho");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/personas/seleccionarPersona.jsp");
	}
	
	public void seleccionarAdministrador(ActionEvent e) {
		ListarPersonasManejado listar = (ListarPersonasManejado)getBeanValue("listarPersonasManejado");
		listar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		listar.setCasa(casa);
		listar.setMetodo("setAdministrador");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/personas/seleccionarPersona.jsp");
	}
	
	public void seleccionarBeneficiado(ActionEvent e) {
		ListarPersonasManejado listar = (ListarPersonasManejado)getBeanValue("listarPersonasManejado");
		listar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		listar.setCasa(casa);
		listar.setMetodo("setBeneficiado");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/personas/seleccionarPersona.jsp");
	}
	
	public void seleccionarCobrador(ActionEvent e) {
		ListarPersonasManejado listar = (ListarPersonasManejado)getBeanValue("listarPersonasManejado");
		listar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		listar.setCasa(casa);
		listar.setMetodo("setCobrador");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/personas/seleccionarPersona.jsp");
	}
	
	public void seleccionarReservacion(ActionEvent e) {
		removeBeanSession("listarReservacionesManejado");
		
		List<Reservacion> reservaciones = getReservacionService().reservacionesDisponibles(new Date());
		
		ListarReservacionesManejado  listar = (ListarReservacionesManejado)getBeanValue("listarReservacionesManejado");
		listar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		listar.setReservaciones(reservaciones);
		listar.setCasa(casa);
		listar.setMetodo("setCasa");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/reservaciones/seleccionarReservacion.jsp");
	}
	
	public void verReservaciones(ActionEvent e) {		
		removeBeanSession("listarReservacionesManejado");
		
		List<Reservacion> reservaciones = getReservacionService().reservacionesCasa(casa.getId());
		ListarReservacionesManejado listar = (ListarReservacionesManejado)getBeanValue("listarReservacionesManejado");
		listar.setReservaciones(reservaciones);
		listar.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		
		getApplicationBeanManejado().navigateTo("/web/paginas/reservaciones/reservacionesCasa.jsp");
	}
	
	public void registrarDireccionCasa(ActionEvent e) {
		DireccionManejado direccionManejado = (DireccionManejado)getBeanValue("direccionManejado");
		direccionManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		direccionManejado.setEntidad(casa);
		direccionManejado.setMetodo("setDireccion");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/direccion/datosDireccion.jsp");
	}
	
	public void registrarDuenhoCasa(ActionEvent e) {
		PersonaManejado personaManejado = (PersonaManejado)getBeanValue("personaManejado");
		personaManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		personaManejado.setEntidad(casa);
		personaManejado.setMetodo("setDuenho");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/personas/datosPersona.jsp");
	}
	
	public void registrarAdministradorCasa(ActionEvent e) {
		PersonaManejado personaManejado = (PersonaManejado)getBeanValue("personaManejado");
		personaManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		personaManejado.setEntidad(casa);
		personaManejado.setMetodo("setAdministrador");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/personas/datosPersona.jsp");
	}
	
	public void registrarBeneficiadoCasa(ActionEvent e) {
		PersonaManejado personaManejado = (PersonaManejado)getBeanValue("personaManejado");
		personaManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		personaManejado.setEntidad(casa);
		personaManejado.setMetodo("setBeneficiado");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/personas/datosPersona.jsp");
	}
	
	public void registrarCobradorCasa(ActionEvent e) {
		PersonaManejado personaManejado = (PersonaManejado)getBeanValue("personaManejado");
		personaManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		personaManejado.setEntidad(casa);
		personaManejado.setMetodo("setCobrador");
		
		getApplicationBeanManejado().navigateTo("/web/paginas/personas/datosPersona.jsp");
	}
	
	public void registrarDatosFinancieros(ActionEvent e) {
				
		//getApplicationBeanManejado().navigateTo("/web/paginas/personas/datosPersona.jsp");
	}
	
	public void registrarDatosEdificio(ActionEvent e) {		
		//cargarPreguntasEdificio();
		removeBeanSession("datoManejado");
		
		DatoManejado datoManejado = (DatoManejado)getBeanValue("datoManejado");
		datoManejado.setCasa(casa);
		datoManejado.setSeccion(Pregunta.EDIFICIO);
		datoManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		
		getApplicationBeanManejado().navigateTo("/web/paginas/casas/datosEdificio.jsp");
	}
	
	public void registrarDatosVivienda(ActionEvent e) {		
		removeBeanSession("datoManejado");
		
		DatoManejado datoManejado = (DatoManejado)getBeanValue("datoManejado");
		datoManejado.setCasa(casa);
		datoManejado.setSeccion(Pregunta.VIVIENDA);
		datoManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		
		getApplicationBeanManejado().navigateTo("/web/paginas/casas/datosEdificio.jsp");
	}
	
	public void registrarDatosHabitacion(ActionEvent e) {		
		removeBeanSession("datoManejado");
		
		DatoManejado datoManejado = (DatoManejado)getBeanValue("datoManejado");
		datoManejado.setCasa(casa);
		datoManejado.setSeccion(Pregunta.HABITACION);
		datoManejado.setUrlAnterior(getApplicationBeanManejado().getCurrentViewId());
		
		getApplicationBeanManejado().navigateTo("/web/paginas/casas/datosEdificio.jsp");
	}
	
	private void cargarPreguntasEdificio() {
		HtmlOutputLabel label = new HtmlOutputLabel();
		label.setValue("Prueba");
		label.setParent(principal);
		
		//principal.getChildren().add(label);
		List<UIComponentBase> chidrens = new ArrayList<UIComponentBase>();
		chidrens.add(label);
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
		
		if(casa != null)
			mostrarNombre = true;
	}

	public void setNombreCasa(String nombreCasa) {
		this.nombreCasa = nombreCasa;
		this.casa.setNombre(nombreCasa);
		
		mostrarNombre = true;
	}

	public String getNombreCasa() {
		return casa.getNombre();
	}

	public Div getPrincipal() {
		return principal;
	}

	public void setPrincipal(Div principal) {
		this.principal = principal;
	}

	public boolean isMostrarNombre() {				
		return mostrarNombre;
	}
	
	public boolean isMostrarDatos() {
		if(casa != null) {
			if(casa.getNombre() != null)
				return true;
		}
		
		return false;
	}

	public String getDireccionCasa() {
		if(casa.getDireccion() == null)
			return "Registrar";
		
		return casa.getDireccion().toString();
	}

	public String getDuenhoCasa() {
		if(casa.getDuenho() == null)
			return "Registrar";
		
		return casa.getDuenho().toString();
	}

	public String getAdministradorCasa() {
		if(casa.getAdministrador() == null)
			return "Registrar";
		
		return casa.getAdministrador().toString();
	}

	public String getBeneficiadoCasa() {
		if(casa.getBeneficiado() == null)
			return "Registrar";
		
		return casa.getBeneficiado().toString();
	}

	public String getCobradorCasa() {
		if(casa.getCobrador() == null)
			return "Registrar";
		
		return casa.getCobrador().toString();
	}
	
	public String getReservaciones() {
		reservaciones = getReservacionService().reservacionesCasa(casa.getId());
		
		if(reservaciones == null || reservaciones.isEmpty())
			return "Sin reservaciones";
		
		else
			return reservaciones.size() + " Registrado(s)";
	}
}
