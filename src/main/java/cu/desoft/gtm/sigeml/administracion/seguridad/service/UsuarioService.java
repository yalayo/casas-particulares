package cu.desoft.gtm.sigeml.administracion.seguridad.service;

import java.util.List;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Permiso;
import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Usuario;

public interface UsuarioService {
	public void incluirUsuario(Usuario usuario);
	public void actualizarUsuario(Usuario usuario);
	public void eliminarUsuario(Usuario usuario) throws Exception;
	public List<Usuario> listarUsuarios();
	
	public String obtenerUsuarioAutenticado();
	public List<Permiso> obtenerPermisosUsuarioAutenticado();
}
