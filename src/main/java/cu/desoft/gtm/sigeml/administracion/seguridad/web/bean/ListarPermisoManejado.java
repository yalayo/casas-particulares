package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Permiso;

public class ListarPermisoManejado extends PermisoBaseManejado {
	
	private List<Permiso> permisos;
	
	private HtmlDataTable table;
	
	public ListarPermisoManejado() {		
		
	}
	
	public void adicionar(ActionEvent e) {		
		removeBeanSession("permisoManejado");
		removeBeanSession("listarPermisoManejado");
		PermisoManejado adicionar = (PermisoManejado) getBeanValue("permisoManejado");

		adicionar.setUrlAnterior("/web/paginas/administracion/seguridad/listarPermiso.jsp");		
		adicionar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/adicionarPermiso.jsp");
	}
	
	public void modificar(ActionEvent e) {
		Permiso permiso = (Permiso)table.getRowData();

		removeBeanSession("modificarPermisoManejado");
		ModificarPermisoManejado modificar = (ModificarPermisoManejado) getBeanValue("modificarPermisoManejado");

		modificar.setPermiso(permiso);
		modificar.setUrlAnterior("/web/paginas/administracion/seguridad/listarPermiso.jsp");
		// TODO Ver lo de la notificacion de cambio en la entidad
		
		modificar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/modificarPermiso.jsp");
	}
	
	public void mostrar(ActionEvent e) {
		Permiso permiso = (Permiso)table.getRowData();

		removeBeanSession("mostrarPermisoManejado");
		MostrarPermisoManejado mostrar = (MostrarPermisoManejado) getBeanValue("mostrarPermisoManejado");

		mostrar.setPermiso(permiso);
		mostrar.setUrlAnterior("/web/paginas/administracion/seguridad/listarPerfil.jsp");
		//mostrar.setNotificarCambiosEntidad(notificarCambiosEntidad);
		
		mostrar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/verPermiso.jsp");
	}

	public List<Permiso> getPermisos() {
		if(permisos == null)
			permisos = getPermisoService().listarPermisos();
		
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

	public HtmlDataTable getTable() {
		return table;
	}

	public void setTable(HtmlDataTable table) {
		this.table = table;
	}
}
