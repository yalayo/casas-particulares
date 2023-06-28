package app.directorio.comun.web.bean;

import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;

import org.ajax4jsf.component.html.HtmlAjaxCommandLink;

import app.directorio.configuracion.web.bean.PreguntaManejado;
import app.registro.reservaciones.domain.Reservacion;
import app.registro.reservaciones.service.ReservacionService;
import app.registro.reservaciones.web.bean.ListarReservacionesManejado;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Permiso;
import cu.desoft.gtm.sigeml.administracion.seguridad.service.UsuarioService;
import cu.desoft.gtm.sigeml.administracion.seguridad.web.bean.ListarUsuarioManejado;
import cu.desoft.gtm.sigeml.comun.web.bean.ListarNomencladorManejado;
import cu.desoft.gtm.sigeml.core.jsf.bean.BaseBean;

public class ApplicationManejado extends BaseBean {
	private UsuarioService usuarioService;
	
	private HtmlAjaxCommandLink docCommandLink;	
	
	public ApplicationManejado() {
		
	}
	
	public boolean mostrarDocumentos() {
		return false;
	}
	
	public void verArrendatarios(ActionEvent actionEvent) {
		removeBeanSession("listarCasasManejado");
		getApplicationBeanManejado().navigateTo("/web/paginas/casas/listarCasas.jsp");
	}
	
	public void verPersonas(ActionEvent actionEvent) { 
		removeBeanSession("listarPersonasManejado");
		getApplicationBeanManejado().navigateTo("/web/paginas/personas/listarPersonas.jsp");
	}
	
	public void verReservaciones(ActionEvent actionEvent) {
		removeBeanSession("listarReservacionesManejado");
		getApplicationBeanManejado().navigateTo("/web/paginas/reservaciones/listarReservaciones.jsp");
	}
	
	public void verProductos(ActionEvent actionEvent) {
		removeBeanSession("listarProductosManejado");
		getApplicationBeanManejado().navigateTo("/web/paginas/productos/listarProductos.jsp");
	}

	public void verTrabajadores(ActionEvent actionEvent) {
		/*ListarTrabajadoresManejado listar = (ListarTrabajadoresManejado)getBeanValue("listarTrabajadoresManejado");
		listar.setUrlAnterior(getApplicationBeanManejado().getUrl());		
		listar.getApplicationBeanManejado().navigateTo("/web/paginas/trabajadores/listarTrabajadores.jsp");*/
	}
	
	public void verNomencladores(ActionEvent actionEvent) {
		removeBeanSession("listarNomencladorManejado");		
		getApplicationBeanManejado().navigateTo("/web/paginas/administracion/nomenclador/listarNomenclador.jsp");
	}
	
	public void verAnuncio(ActionEvent actionEvent) {
		/*removeBeanSession("modificarAnuncioManejado");
		
		ModificarAnuncioManejado modificarAnuncioManejado = (ModificarAnuncioManejado)getBeanValue("modificarAnuncioManejado");
		modificarAnuncioManejado.setUrlAnterior(getApplicationBeanManejado().getUrl());		
		modificarAnuncioManejado.getApplicationBeanManejado().navigateTo("/web/paginas/anuncio/modificarAnuncio.jsp");*/
	}

	public void verUsuarios(ActionEvent actionEvent) {
		ListarUsuarioManejado listar = (ListarUsuarioManejado)getBeanValue("listarUsuarioManejado");
		listar.setUrlAnterior(getApplicationBeanManejado().getUrl());		
		listar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/listarUsuario.jsp");
	}
	
	public void verPreguntas(ActionEvent actionEvent) {
		removeBeanSession("listarPreguntasManejado");		
		getApplicationBeanManejado().navigateTo("/web/paginas/configuracion/listarPreguntas.jsp");
	}
	
	public void buscarCasas(ActionEvent actionEvent) {
		removeBeanSession("seleccionarPreguntasManejado");		
		getApplicationBeanManejado().navigateTo("/web/paginas/configuracion/seleccionarPreguntas.jsp");
	}
	
	public void reservacionesMes(ActionEvent actionEvent) {
		removeBeanSession("listarReservacionesManejado");
		
		ReservacionService reservacionService = (ReservacionService)getBeanValue("reservacionService");
		List<Reservacion> reservaciones = reservacionService.reservacionesMes(new Date());
		ListarReservacionesManejado listar = (ListarReservacionesManejado)getBeanValue("listarReservacionesManejado");
		listar.setReservaciones(reservaciones);
		
		getApplicationBeanManejado().navigateTo("/web/paginas/reservaciones/reservacionesMes.jsp");
	}
	
	public boolean tienePermiso(String permiso) {		
		List<Permiso> permisos = getUsuarioService().obtenerPermisosUsuarioAutenticado();
		
		for(int i = 0; i < permisos.size(); i ++) {
			Permiso p = permisos.get(i);
			
			if(p.getNombre().equals(permiso))
				return true;
		}
		
		return false;
	}

	public UsuarioService getUsuarioService() {
		if(usuarioService == null)
			usuarioService = (UsuarioService)getBeanValue("usuarioService");
		
        return usuarioService;
	}

	public HtmlAjaxCommandLink getDocCommandLink() {
		return docCommandLink;
	}

	public void setDocCommandLink(HtmlAjaxCommandLink docCommandLink) {
		this.docCommandLink = docCommandLink;
	}

	public boolean isOpcionArrendatario() {		
		return tienePermiso("PERMISO_VER_ARRENDATARIOS") || tienePermiso("PERMISO_ADMIN");
	}

	public boolean isOpcionPersona() {
		return tienePermiso("PERMISO_VER_PERSONAS") || tienePermiso("PERMISO_ADMIN");
	}

	public boolean isOpcionReservacion() {
		return tienePermiso("PERMISO_VER_RESERVACIONES") || tienePermiso("PERMISO_ADMIN");
	}
	
	public boolean isOpcionProducto() {
		return tienePermiso("PERMISO_VER_PRODUCTOS") || tienePermiso("PERMISO_ADMIN");
	}
	
	public boolean isOpcionBusqueda() {
		return tienePermiso("PERMISO_BUSCAR_CASA") || tienePermiso("PERMISO_ADMIN");
	}
	
	public boolean isOpcionPregunta() {
		return tienePermiso("PERMISO_ADMINISTRAR_PREGUNTAS") || tienePermiso("PERMISO_ADMIN");
	}

	public boolean isOpcionNomenclador() {
		return tienePermiso("PERMISO_ADMIN");
	}

	public boolean isOpcionUsuario() {
		return tienePermiso("PERMISO_ADMIN");
	}
}
