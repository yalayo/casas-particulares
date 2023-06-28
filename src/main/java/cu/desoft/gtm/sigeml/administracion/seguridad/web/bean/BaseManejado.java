package cu.desoft.gtm.sigeml.administracion.seguridad.web.bean;

import cu.desoft.gtm.sigeml.administracion.seguridad.facade.SeguridadFacade;
import cu.desoft.gtm.sigeml.core.jsf.bean.BaseBean;

public class BaseManejado extends BaseBean {
	private SeguridadFacade seguridadFacade;
	
	public BaseManejado() {
		super();
	}
	
	@Deprecated
	public SeguridadFacade getSeguridadFacade() {
		if(seguridadFacade == null) 
			seguridadFacade = (SeguridadFacade)getBeanValue("seguridadFacade");
		
		return seguridadFacade;
	}
}
