package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.event.ActionEvent;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Perfil;
import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Permiso;

public class ModificarPerfilManejado extends PerfilBaseManejado {
	private Perfil perfil;
	
	private List<Permiso> permisos;
	
	public ModificarPerfilManejado() {
		
	}
	
	private boolean contiene(List<Permiso> permisos, Permiso permiso) {
		for(int i = 0; i < permisos.size(); i ++) {
			Permiso per = permisos.get(i);
			
			if(per.getId().equals(permiso.getId()))
				return true;
		}
		
		return false;
	}
	
	private Set<Permiso> obtenerPermisosSeleccionados() {
		Set<Permiso> seleccionados = new HashSet<Permiso>();
		
		for(int i = 0; i < permisos.size(); i ++) {
			Permiso permiso = permisos.get(i);
		
			if(permiso.isSeleccionado())
				seleccionados.add(permiso);
		}
		
		return seleccionados;
	}
	
	public void modificar(ActionEvent e) {					
		perfil.setPermisos(obtenerPermisosSeleccionados());
		
		getPerfilService().actualizarPerfil(perfil);	
		adicionarMensajeInformacion("El perfil ha sido modificado correctamente.");
		getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/listarPerfil.jsp");
	}

	public void cancelar(ActionEvent e){
		retornarUrlAnterior();
	}
	
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	public List<Permiso> getPermisos() {		
		List<Permiso> lista = getPermisoService().listarPermisos();
		List<Permiso> perms = new ArrayList<Permiso>();
		perms.addAll(perfil.getPermisos());
				
		permisos = new ArrayList<Permiso>();
		
		for(int i = 0; i < lista.size(); i ++) {
			Permiso permiso = lista.get(i);
			
			if(contiene(perms, permiso)) {
				permiso.setSeleccionado(true);
				
				permisos.add(permiso);
				continue;
			}
			
			permisos.add(permiso);
		}
		
		return permisos;
	}
}
