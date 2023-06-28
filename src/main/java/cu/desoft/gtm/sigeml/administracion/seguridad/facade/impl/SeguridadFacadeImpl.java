package cu.desoft.gtm.sigeml.administracion.seguridad.facade.impl;

import java.util.List;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Perfil;
import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Permiso;
import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Usuario;
import cu.desoft.gtm.sigeml.administracion.seguridad.facade.SeguridadFacade;
import cu.desoft.gtm.sigeml.administracion.seguridad.service.PerfilService;
import cu.desoft.gtm.sigeml.administracion.seguridad.service.PermisoService;
import cu.desoft.gtm.sigeml.administracion.seguridad.service.UsuarioService;

public class SeguridadFacadeImpl implements SeguridadFacade {
	private UsuarioService usuarioService;
	private PerfilService perfilService;
	private PermisoService permisoService;
	
	public SeguridadFacadeImpl() {
		super();
	}
	
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public PerfilService getPerfilService() {
		return perfilService;
	}

	public void setPerfilService(PerfilService perfilService) {
		this.perfilService = perfilService;
	}

	public PermisoService getPermisoService() {
		return permisoService;
	}

	public void setPermisoService(PermisoService permisoService) {
		this.permisoService = permisoService;
	}

	public void incluirUsuario(Usuario usuario) {
		usuarioService.incluirUsuario(usuario);
	}
	
	public void actualizarUsuario(Usuario usuario) {
		usuarioService.actualizarUsuario(usuario);
	}

	public void eliminarUsuario(Usuario usuario) {
		//usuarioService.eliminarUsuario(usuario);
	}

	public void actualizarPerfil(Perfil perfil) {
		perfilService.actualizarPerfil(perfil);
	}

	public void actualizarPermiso(Permiso permiso) {
		permisoService.actualizarPermiso(permiso);
	}

	public void eliminarPerfil(Perfil perfil) {
		//perfilService.eliminarPerfil(perfil);
	}

	public void eliminarPermiso(Permiso permiso) {
		//permisoService.eliminarPermiso(permiso);
	}

	public void incluirPerfil(Perfil perfil) {
		perfilService.incluirPerfil(perfil);		
	}

	public void incluirPermiso(Permiso permiso) {
		permisoService.incluirPermiso(permiso);		
	}

	public List<Perfil> listarPerfiles() {
		return perfilService.listarPerfiles();
	}

	public List<Permiso> listarPermisos() {
		return permisoService.listarPermisos();
	}

	public List<Usuario> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}
}
