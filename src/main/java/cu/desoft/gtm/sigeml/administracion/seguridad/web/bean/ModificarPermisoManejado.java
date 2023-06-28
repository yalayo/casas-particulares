package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import javax.faces.event.ActionEvent;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Permiso;

public class ModificarPermisoManejado extends PermisoBaseManejado {
	private Permiso permiso;
	
	public ModificarPermisoManejado() {
		
	}
	
	public void modificar(ActionEvent e) {					
		getPermisoService().actualizarPermiso(permiso);	
		adicionarMensajeInformacion("El permiso ha sido modificado correctamente.");
		retornarUrlAnterior();
	}

	public void cancelar(ActionEvent e){
		retornarUrlAnterior();
	}
	
	public Permiso getPermiso() {
		return permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

}
