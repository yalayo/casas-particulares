package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import javax.faces.event.ActionEvent;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Usuario;

public class MostrarUsuarioManejado extends UsuarioBaseManejado {
	private Usuario usuario;	

	public MostrarUsuarioManejado() {
		
	}
	
	public void modificar(ActionEvent e) {	
		
		ModificarUsuarioManejado modificar = (ModificarUsuarioManejado) getBeanValue("modificarUsuarioManejado");
		modificar.setUsuario(usuario);
		modificar.setUrlAnterior("/web/paginas/administracion/seguridad/verUsuario.jsp");
		modificar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/modificarUsuario.jsp");
	}
   
    public void aceptar(ActionEvent e) {					
    	retornarUrlAnterior();
	}
    
    public void cancelar(ActionEvent e) {					
    	MostrarUsuarioManejado mostrarUsuarioManejado= (MostrarUsuarioManejado)getBeanValue("mostrarUsuarioManejado");
    	mostrarUsuarioManejado.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/listarUsuario.jsp");
	
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
