package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import javax.faces.event.ActionEvent;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Perfil;

public class MostrarPerfilManejado extends BaseManejado {
	private Perfil perfil;
	
	public MostrarPerfilManejado() {
		
	}	
	
	public void modificar(ActionEvent e) {					
		ModificarPerfilManejado modificar = (ModificarPerfilManejado) getBeanValue("modificarPerfilManejado");
		modificar.setPerfil(perfil);
		modificar.setUrlAnterior("/web/paginas/administracion/seguridad/verPerfil.jsp");
		modificar.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/modificarPerfil.jsp");
	}
   
    public void aceptar(ActionEvent e) {					
    	MostrarPerfilManejado mostrarPerfilManejado= (MostrarPerfilManejado)getBeanValue("mostrarPerfilManejado");
    	mostrarPerfilManejado.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/listarPerfil.jsp");
	
	}
    
    public void cancelar(ActionEvent e) {					
    	MostrarPerfilManejado mostrarPerfilManejado= (MostrarPerfilManejado)getBeanValue("mostrarPerfilManejado");
    	mostrarPerfilManejado.getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/listarPerfil.jsp");
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}		
}
