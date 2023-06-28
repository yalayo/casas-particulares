package cu.desoft.gtm.sigeml.administracion.seguridad.service;

import java.util.List;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Perfil;

public interface PerfilService {
	public void incluirPerfil(Perfil perfil);
	public void actualizarPerfil(Perfil perfil);
	public void eliminarPerfil(Perfil perfil) throws Exception;
	public List<Perfil> listarPerfiles();
}
