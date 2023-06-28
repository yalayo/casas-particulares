package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import cu.desoft.gtm.sigeml.administracion.seguridad.service.PerfilService;
import cu.desoft.gtm.sigeml.administracion.seguridad.service.UsuarioService;
import cu.desoft.gtm.sigeml.core.jsf.bean.BaseBean;

public class UsuarioBaseManejado extends BaseBean {
	private UsuarioService usuarioService;
	private PerfilService perfilService;
	
	public UsuarioBaseManejado() {
		super();
	}

	public UsuarioService getUsuarioService() {
		if(usuarioService == null)
			usuarioService = (UsuarioService)getBeanValue("usuarioService");
		
		return usuarioService;
	}
	
	public PerfilService getPerfilService() {
		if(perfilService == null)
			perfilService = (PerfilService)getBeanValue("perfilService");
		
		return perfilService;
	}
}
