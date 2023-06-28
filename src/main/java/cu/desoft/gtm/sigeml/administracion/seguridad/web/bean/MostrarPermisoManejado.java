package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import javax.faces.event.ActionEvent;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Permiso;

public class MostrarPermisoManejado extends BaseManejado {
	private Permiso permiso;	

	public MostrarPermisoManejado() {
		
	}
	
	public void modificar(ActionEvent e) {					
		ModificarPermisoManejado modificar = (ModificarPermisoManejado) getBeanValue("modificarPermisoManejado");
		modificar.setPermiso(permiso);
		modificar.setUrlAnterior("/web/paginas/administracion/seguridad/verPermiso.jsp");
		modificar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/modificarPermiso.jsp");
	}
   
    public void aceptar(ActionEvent e) {					
    	MostrarPermisoManejado mostrarPermisoManejado= (MostrarPermisoManejado)getBeanValue("mostrarPermisoManejado");
    	mostrarPermisoManejado.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/listarPermiso.jsp");
	
	}
    
    public void cancelar(ActionEvent e) {					
    	MostrarPermisoManejado mostrarPermisoManejado= (MostrarPermisoManejado)getBeanValue("mostrarPermisoManejado");
    	mostrarPermisoManejado.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/listarPermiso.jsp");
	}

	public Permiso getPermiso() {
		return permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}
	
}
