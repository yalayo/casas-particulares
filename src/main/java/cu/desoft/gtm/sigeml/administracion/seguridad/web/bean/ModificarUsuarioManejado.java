package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.event.ActionEvent;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Perfil;
import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Usuario;

public class ModificarUsuarioManejado extends UsuarioBaseManejado {
	private Usuario usuario;
	
	private String password;
	private String confirmacion;
	
	private boolean habilitada;
	
	private List<Perfil> perfiles;
	
	public ModificarUsuarioManejado() {
		
	}
	
	private boolean contiene(List<Perfil> perfiles, Perfil perfil) {
		for(int i = 0; i < perfiles.size(); i ++) {
			Perfil per = perfiles.get(i);
			
			if(per.getId().equals(perfil.getId()))
				return true;
		}
		
		return false;
	}
	
	private Set<Perfil> obtenerPerfilesSeleccionados() {
		Set<Perfil> devolver = new HashSet<Perfil>();
		
		for(int i = 0; i < perfiles.size(); i ++) {
			Perfil perfil = perfiles.get(i);
		
			if(perfil.isSeleccionado())
				devolver.add(perfil);
		}
		
		return devolver;
	}
	
	public void modificar(ActionEvent e) {
		if(password.equals(confirmacion)) {		
			usuario.setPerfiles(obtenerPerfilesSeleccionados());
			
			getUsuarioService().actualizarUsuario(usuario);
			adicionarMensajeInformacion("El usuario ha sido modificado correctamente.");
			removeBeanSession("listarUsuarioManejado");
			getApplicationBeanManejado().navigateTo("/web/paginas/administracion/seguridad/listarUsuario.jsp");
			this.habilitada = true;
		}
		
		else
			adicionarMensajeError("La confirmacion no coincide con la contrasenha.");
	}

	public void cancelar(ActionEvent e){
		retornarUrlAnterior();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmacion() {
		return confirmacion;
	}

	public void setConfirmacion(String confirmacion) {
		this.confirmacion = confirmacion;
	}

	public boolean isHabilitada() {
		return habilitada;
	}

	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}

	public List<Perfil> getPerfiles() {
		List<Perfil> lista = getPerfilService().listarPerfiles();
		List<Perfil> perfs = new ArrayList<Perfil>();
		perfs.addAll(usuario.getPerfiles());
				
		perfiles = new ArrayList<Perfil>();
		
		for(int i = 0; i < lista.size(); i ++) {
			Perfil perfil = lista.get(i);
			
			if(contiene(perfs, perfil)) {
				perfil.setSeleccionado(true);
				
				perfiles.add(perfil);
				continue;
			}
			
			perfiles.add(perfil);
		}
		
		return perfiles;
	}	
}
