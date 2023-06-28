package cu.desoft.gtm.sigeml.administracion.seguridad.facade;

import java.util.List;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Perfil;
import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Permiso;
import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Usuario;

public interface SeguridadFacade {
	public void incluirUsuario(Usuario usuario);
	public void actualizarUsuario(Usuario usuario);
	public void eliminarUsuario(Usuario usuario);
	
	public void incluirPerfil(Perfil perfil);
	public void actualizarPerfil(Perfil perfil);
	public void eliminarPerfil(Perfil perfil);
	
	public void incluirPermiso(Permiso permiso);
	public void actualizarPermiso(Permiso permiso);
	public void eliminarPermiso(Permiso permiso);
	
	public List<Usuario> listarUsuarios();
	public List<Perfil> listarPerfiles();
	public List<Permiso> listarPermisos();
}
