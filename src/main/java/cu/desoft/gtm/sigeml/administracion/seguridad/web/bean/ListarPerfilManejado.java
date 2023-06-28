package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Perfil;

public class ListarPerfilManejado extends PerfilBaseManejado {
	
	private List<Perfil> perfiles;
	
	private HtmlDataTable table;
	
	public ListarPerfilManejado() {		
		
	}
	
	public void adicionar(ActionEvent e) {		
		removeBeanSession("perfilManejado");
		removeBeanSession("listarPerfilManejado");
		PerfilManejado adicionar = (PerfilManejado) getBeanValue("perfilManejado");

		adicionar.setUrlAnterior("/web/paginas/administracion/seguridad/listarPerfil.jsp");		
		adicionar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/adicionarPerfil.jsp");
	}
	
	public void gestionarPermisos(ActionEvent e) {		
		removeBeanSession("listarPerfilManejado");
		removeBeanSession("listarPermisoManejado");
		ListarPermisoManejado listar = (ListarPermisoManejado) getBeanValue("listarPermisoManejado");

		listar.setUrlAnterior("/web/paginas/administracion/seguridad/listarPerfil.jsp");		
		listar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/listarPermiso.jsp");
	}
	
	public void modificar(ActionEvent e) {
		Perfil perfil = (Perfil)table.getRowData();

		removeBeanSession("modificarPerfilManejado");
		ModificarPerfilManejado modificar = (ModificarPerfilManejado) getBeanValue("modificarPerfilManejado");

		modificar.setPerfil(perfil);
		modificar.setUrlAnterior("/web/paginas/administracion/seguridad/listarPerfil.jsp");
		// TODO Ver lo de la notificacion de cambio en la entidad
		
		modificar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/modificarPerfil.jsp");
	}
	
	public void mostrar(ActionEvent e) {
		Perfil perfil = (Perfil)table.getRowData();

		removeBeanSession("mostrarPerfilManejado");
		MostrarPerfilManejado mostrar = (MostrarPerfilManejado) getBeanValue("mostrarPerfilManejado");

		mostrar.setPerfil(perfil);
		mostrar.setUrlAnterior("/web/paginas/administracion/seguridad/listarPerfil.jsp");
		//mostrar.setNotificarCambiosEntidad(notificarCambiosEntidad);
		
		mostrar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/verPerfil.jsp");
	}

	public List<Perfil> getPerfiles() {
		if(perfiles == null)
			perfiles = getPerfilService().listarPerfiles();
		
		return perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	public HtmlDataTable getTable() {
		return table;
	}

	public void setTable(HtmlDataTable table) {
		this.table = table;
	}
}
