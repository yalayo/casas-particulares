package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.event.ActionEvent;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Usuario;

public class ListarUsuarioManejado extends UsuarioBaseManejado {
	
	private List<Usuario> usuarios;
	
	private HtmlDataTable table;
	
	public ListarUsuarioManejado() {		
		usuarios = getUsuarioService().listarUsuarios();
	}
	
	public void adicionar(ActionEvent e) {		
		removeBeanSession("usuarioManejado");
		//removeBeanSession("listarUsuarioManejado");
		UsuarioManejado adicionar = (UsuarioManejado) getBeanValue("usuarioManejado");

		adicionar.setUrlAnterior("/web/paginas/administracion/seguridad/listarUsuario.jsp");		
		adicionar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/adicionarUsuario.jsp");
	}
	
	public void gestionarPerfiles(ActionEvent e) {		
		removeBeanSession("listarUsuarioManejado");
		removeBeanSession("listarPerfilManejado");
		ListarPerfilManejado listar = (ListarPerfilManejado) getBeanValue("listarPerfilManejado");

		listar.setUrlAnterior("/web/paginas/administracion/seguridad/listarUsuario.jsp");		
		listar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/listarPerfil.jsp");
	}
	
	public void modificar(ActionEvent e) {
		Usuario usuario = (Usuario)table.getRowData();
		
		removeBeanSession("modificarUsuarioManejado");
		removeBeanSession("listarUsuarioManejado");
		ModificarUsuarioManejado modificar = (ModificarUsuarioManejado) getBeanValue("modificarUsuarioManejado");

		modificar.setUsuario(usuario);
		modificar.setUrlAnterior("/web/paginas/administracion/seguridad/listarUsuario.jsp");
		modificar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/modificarUsuario.jsp");
	}
	
	public void mostrar(ActionEvent e) {
		Usuario usuario = (Usuario)table.getRowData();

		removeBeanSession("mostrarUsuarioManejado");
		MostrarUsuarioManejado mostrar = (MostrarUsuarioManejado) getBeanValue("mostrarUsuarioManejado");
        
		mostrar.setUsuario(usuario);
		mostrar.setUrlAnterior("/web/paginas/administracion/seguridad/listarUsuarioNuevo.jsp");
		//mostrar.setNotificarCambiosEntidad(notificarCambiosEntidad);
		
		mostrar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/verUsuarios.jsp");
	}
	
	public void eliminar(ActionEvent e){
		Usuario usuario = (Usuario)table.getRowData();

		removeBeanSession("mostrarUsuarioManejado");
		EliminarUsuarioManejado eliminar = (EliminarUsuarioManejado) getBeanValue("eliminarUsuarioManejado");

		eliminar.setUsuario(usuario);
		eliminar.setUrlAnterior("/web/paginas/administracion/seguridad/listarUsuario.jsp");
		//mostrar.setNotificarCambiosEntidad(notificarCambiosEntidad);
		adicionarMensajeInformacion("La acci�n solicitada es irreversible el Usuario sera eliminado del sistema");
		
		eliminar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/eliminarUsuario.jsp");
	}
	
	public List<Usuario> getUsuarios() {
		if(usuarios == null)
			usuarios = getUsuarioService().listarUsuarios();
		
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public HtmlDataTable getTable() {
		return table;
	}

	public void setTable(HtmlDataTable table) {
		this.table = table;
	}
}
