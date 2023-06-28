package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import javax.faces.event.ActionEvent;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Usuario;

public class EliminarUsuarioManejado extends UsuarioBaseManejado {
	private Usuario usuario;	
	
	public EliminarUsuarioManejado() {
		
	}
	
	public void eliminar(ActionEvent e) {					
		try {
			getUsuarioService().eliminarUsuario(usuario);
			adicionarMensajeInformacion("El usuario ha sido eliminado correctamente.");
			removeBeanSession("listarUsuarioManejado");
			retornarUrlAnterior();
		} 
		
		catch (Exception e1) {
			adicionarMensajeError(e1.getMessage());
		}
				
	}

	public void cancelar(ActionEvent e) {					
		retornarUrlAnterior();		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	

}
