package cu.desoft.gtm.sigeml.administracion.seguridad.service;

import java.util.List;

import cu.desoft.gtm.sigeml.administracion.seguridad.domain.Permiso;

public interface PermisoService {
	public void incluirPermiso(Permiso permiso);
	public void actualizarPermiso(Permiso permiso);
	public void eliminarPermiso(Permiso permiso) throws Exception;
	public List<Permiso> listarPermisos();
}
